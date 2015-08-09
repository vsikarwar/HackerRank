package common_child;

import java.util.Scanner;

public class A {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String a = in.nextLine().trim();
		String b = in.nextLine().trim();
		process(a,b);
	}
	
	public static void process(String a, String b){
		int[][] r = new int[a.length()+1][b.length()+1];
		
		for(int i = 0; i<r.length; i++){
			r[i][0] = 0;
		}
		for(int i = 0; i<r[0].length; i++){
			r[0][i] = 0;
		}
		
		for(int i = 1; i<r.length; i++){
			for(int j = 1; j<r[0].length; j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					r[i][j] = r[i-1][j-1] + 1;
				}else{
					r[i][j] = Math.max(r[i][j-1], r[i-1][j]);
				}
			}
		}
		System.out.println(r[r.length-1][r[0].length-1]);
	}
}
