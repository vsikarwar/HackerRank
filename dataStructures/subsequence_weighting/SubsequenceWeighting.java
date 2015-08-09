package subsequence_weighting;

import java.util.Arrays;
import java.util.Scanner;

public class SubsequenceWeighting {
	public static void main(String[] args){
		readInput();
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		int cases = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			int size = Integer.valueOf(in.nextLine().trim());
			int[] values = new int[size];
			int[] weights = new int[size];
			String[] valuesStr = in.nextLine().trim().split(" ");
			String[] weightsStr = in.nextLine().trim().split(" ");
			
			for(int j = 0; j<valuesStr.length; j++){
				values[j] = Integer.valueOf(valuesStr[j]);
			}
			
			for(int j = 0; j<weightsStr.length; j++){
				weights[j] = Integer.valueOf(weightsStr[j]);
			}
			
			process(values, weights);
		}
	}
	
	public static void process(int[] values, int[] weights){
		long[] r = new long[values.length];
		long max = 0;
		r[0] = weights[0];
		for(int i = 1; i<values.length; i++){
			for(int j = i; j>0; j--){
				if(values[i] > values[j] && r[i] < r[j] + weights[i]){
					r[i] = r[j] + weights[i];
				}else{
					r[i] = weights[i];
				}
				if(max < r[i]){
					max = r[i];
				}
			}
		}
		System.out.println(max);
	}
}
