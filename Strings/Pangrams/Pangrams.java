package Pangrams;

import java.util.Scanner;

public class Pangrams {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine().trim();
		boolean isPangrams = isPangram(input);
		System.out.println(isPangrams ? "pangram" : "not pangram");
	}
	
	public static boolean isPangram(String input){
		char[] c = input.toCharArray();
		boolean[] a = new boolean[26];
		for(int i = 0; i<c.length; i++){
			if((int)c[i]>=65 && (int)c[i]<=90){
				a[(int)c[i]-65] = true;
			}else if((int)c[i]>=97 && (int)c[i]<=122){
				a[(int)c[i] - 97] = true;
			}
		}
		for(int i = 0; i<a.length; i++){
			if(a[i] == false){
				return false;
			}
		}
		return true;
	}
}
