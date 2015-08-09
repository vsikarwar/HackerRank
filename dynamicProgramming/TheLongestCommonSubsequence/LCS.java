package TheLongestCommonSubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class LCS {
	
	public static void main(String[] args){
		int[] a= {1, 2, 3, 4, 1};
		int[] b = {3, 4, 1, 2, 1, 3};
		lcs(a, b);
		
		
		
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().trim().split(" ");
		int[] _a = new int[Integer.parseInt(input[0])];
		int[] _b = new int[Integer.parseInt(input[1])];
		
		String[] input1 = in.nextLine().trim().split(" ");
		String[] input2 = in.nextLine().trim().split(" ");
		for(int i = 0; i<_a.length; i++){
			_a[i] = Integer.parseInt(input1[i]);
		}
		
		for(int i = 0; i<_b.length; i++){
			_b[i] = Integer.parseInt(input2[i]);
		}
		
		lcs(_a, _b);
	}
	
	public static void lcs(int[] a, int[] b){
		int[][] r = new int[a.length+1][b.length+1];
		
		for(int i = 0; i< a.length ; i++){
			r[i][0] = 0;
		}
		for(int i = 0; i< a.length ; i++){
			r[0][i] = 0;
		}
		
		for(int i = 1; i<=a.length; i++){
			for(int j = 1; j<=b.length; j++){
				if(a[i-1] == b[j-1]){
					r[i][j] = r[i-1][j-1]+1;
				}else{
					r[i][j] = Math.max(r[i][j-1], r[i-1][j]);
				}
			}
		}
		
		//printArray(r);
		StringBuilder sb = new StringBuilder();
		for(int i = r.length -1; i>0; i--){
			for(int j = r[i].length -1; j>0; j--){
				if(r[i][j]>r[i-1][j] && a[i-1] == b[j-1]){
					sb.append(r[i-1][j-1]).append(" ");
				}
			}
		}
		
		//System.out.println(sb.toString().trim());
		//String str = printPath(r, a, b, r.length-1, r[0].length-1);
		System.out.print(printPath(r, a, b, r.length-1, r[0].length-1).trim());
	}
	
	public static String printPath(int[][] r, int[] a, int[] b, int m , int n){
		if(m ==0 || n ==0){
			return "";
		}else if(a[m-1] == b[n-1]){
			return printPath(r , a, b, m-1, n-1) + a[m-1] + " ";
		}else if(r[m][n-1] > r[m-1][n]){
			return printPath(r, a, b, m, n-1);
		}else{
			return printPath(r, a, b, m-1, n);
		}
	}
	
	public static void printArray(int[][] r){
		for(int[] a : r){
			System.out.println(Arrays.toString(a));
		}
	}

}
