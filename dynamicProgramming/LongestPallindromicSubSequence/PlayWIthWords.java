package LongestPallindromicSubSequence;

import java.util.Arrays;
import java.util.Scanner;

public class PlayWIthWords {
	
	public static void main(String[] args){
		//pallindrome("eeegeeksforskeeggeeks");
		
		Scanner in = new Scanner(System.in);
		String input = in.nextLine().trim();
		pallindrome(input);
	}
	
	public static void pallindrome(String input){
		int[][] lp = new int[input.length()][input.length()];
		
		for(int i = 0; i<input.length(); i++){
			lp[i][i] = 1;
		}
		for(int i = 1; i<input.length(); i++){ // denote the length of subsequence
			for(int j = 0; j<input.length() - i; j++){
				int k = j + i; // denote the last char of sequence since length of sequence is i
				if(i == 1 && input.charAt(j) == input.charAt(k)){
					lp[j][k] = 2;
				}else if(input.charAt(j) == input.charAt(k)){
					lp[j][k] = lp[j+1][k-1] + 2;
				}else{
					lp[j][k] = Math.max(lp[j+1][k], lp[j][k-1]);
				}
			}
		}
		int max = 0;
		for(int i = 1; i<input.length(); i++){
			int first = lp[0][i-1];
			int second = lp[i][input.length() - 1];
			if(max < first*second){
				max = first*second;
			}
		}
		System.out.println(max);
	}
	
	public static void printArray(int[][] lp){
		System.out.println("\n");
		for(int i = 0; i<lp.length; i++){
			System.out.println(Arrays.toString(lp[i]));
		}
	}

}
