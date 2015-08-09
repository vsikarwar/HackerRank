package battlefield;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CandidateCode {
	static int[][] neighbors = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};
	
	public static String[] nearest_shoot_point(int[] input1,int[] input2,int[] input3,String[] input4)
    {
		int[][] matrix = new int[input1[0]][input1[1]];
		
		int[][] blocking = new int[input4.length][];
		for(int i = 0; i<input4.length; i++){
			String[] arr = input4[i].split("#");
			int[] p = new int[2];
			p[0] = Integer.valueOf(arr[0])-1;
			p[1] = Integer.valueOf(arr[1])-1;
			blocking[i] = p;
		}
		
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				matrix[i][j] = Integer.MAX_VALUE;
			}
		}
		
		return bfs(matrix, input2, input3, blocking);
    }
	
	public static boolean shoot(int[][] matrix, int[] s, int[] target, int[][] blocking){
		for(int[] n : neighbors){
			int[] p = new int[2];
			p[0] = s[0] + n[0];
			p[1] = s[1] + n[1];
			
			while((p[0] >= 0 && p[1] >=0 && p[0] <matrix.length && p[1] < matrix.length) ){
				if(isEqual(p, target)){
					//target found;
					return true;
				}
				if(isBlocking(p, blocking))
					break;
				
				p[0] = p[0] + n[0];
				p[1] = p[1] + n[1];
			}
		}
		return false;
	}
	
	public static boolean isBlocking(int[] a, int[][] blocking){
		for(int[] b : blocking){
			if(isEqual(a,b))
				return true;
		}
		return false;
	}
	
	public static boolean isEqual(int[] a, int[] b){
		if(a[0] == b[0] && a[1] == b[1])
			return true;
		
		return false;
	}
	
	public static String[] bfs(int[][] matrix, int[] start, int[] target, int[][] blocking){
		int[][] discovered  = new int[matrix.length][matrix[0].length];
		
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				discovered[i][j] = 0;
			}
		}
		
		LinkedList<int[]> queue = new LinkedList<int[]>();
		List<int[]> solution = new ArrayList<int[]>();
		queue.add(start);
		int minDis = -1;
		
		matrix[start[0]][start[1]] = 0;
		
		while(!queue.isEmpty()){
			int[] s = queue.remove();
			if(shoot(matrix, s, target, blocking)){
				if(minDis == -1){
					minDis = matrix[s[0]][s[1]];
				}
				if(minDis > matrix[s[0]][s[1]]){
					minDis = matrix[s[0]][s[1]];
				}
				solution.add(s);
			}
				for(int[] n : neighbors){
					int[] p = new int[2];
					p[0] = s[0] + n[0];
					p[1] = s[1] + n[1];
					
					if(p[0] < 0 || p[1] <0 || p[0] >=matrix.length || p[1] >= matrix.length)
						continue;
					
					if(matrix[s[0]][s[1]] + 1 <matrix[p[0]][p[1]] ){
						matrix[p[0]][p[1]] = matrix[s[0]][s[1]] + 1;
					}
					
					if(discovered[p[0]][p[1]] == 0){
						queue.add(p);
					}
				}
				discovered[s[0]][s[1]] = 1;
			
		}
		
		return printSolution(solution, matrix, minDis);
	}
	
	public static String[] printSolution(List<int[]> solution, int[][] matrix, int min){
		Collections.sort(solution, new Comp());
		
		StringBuilder sb = new StringBuilder();
		for(int[] s : solution){
			if(matrix[s[0]][s[1]] == min){
				sb.append(s[0]+1);
				sb.append("#");
				sb.append(s[1]+1);
				sb.append(",");
			}
		}
		String res = sb.substring(0, sb.length()-1);
		return res.split(",");
	}
	
	static class Comp implements Comparator<int[]>{

		@Override
		public int compare(int[] a, int[] b) {

			if(a[0] < b[0])
				return -1;
			if(a[0] > b[0])
				return 1;
			return 0;
		}

	}
}
