package TheMaximumSubArray;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/maxsubarray
public class A {

	public static void main(String[] args){
		//int[] a = {2, -1, 2, 3, 4,-5};
		//int[] a = {-1,-2,2,-1,8,-6};
		
		Scanner in = new Scanner(System.in);
        int res;
        
        int cases = Integer.parseInt(in.nextLine().trim());
        
        for(int i = 0; i<cases; i++){
        	int _a_size = Integer.parseInt(in.nextLine().trim());
        	int[] _a = new int[_a_size];
        	int _a_item;
            String next = in.nextLine().trim();
            String[] next_split = next.split(" ");
            for(int _a_i = 0; _a_i < _a_size; _a_i++) {
                _a_item = Integer.parseInt(next_split[_a_i]);
                _a[_a_i] = _a_item;
            }
    		
    		System.out.println(sumContiguous(_a) + " " + sumNonContiguous(_a));
        }
		
	}
	
	public static int sumNonContiguous(int[] a){
		int sum = 0;
		int max = Integer.MIN_VALUE;
		boolean allNegative = true;
		for(int k = 0; k< a.length; k++){
			if(a[k] >= 0){
				sum = sum + a[k];
			}else{
				if(max < a[k]){
					max = a[k];
				}
			}
			if(a[k] >= 0){
				allNegative = false;
			}
			
		}
		if(allNegative){
			return max;
		}else{
			return sum;
		}
	}
	
	public static int sumContiguous(int[] a){
		int currentSum = 0;
		int bestSum = 0;
		int max = Integer.MIN_VALUE;
		boolean allNegative = true;

		for(int k = 0; k<a.length; k++){
			int val = currentSum + a[k];
			if(val > 0){
				currentSum = val;
			}else{
				currentSum = 0;
			}
			
			if(currentSum > bestSum){
				bestSum = currentSum;
			}
			
			if(max<a[k]){
				max = a[k];
			}
			
			if(a[k] >= 0){
				allNegative = false;
			}
			
		}
		
		if(allNegative){
			return max;
		}else{
			return bestSum;
		}
	}
}
