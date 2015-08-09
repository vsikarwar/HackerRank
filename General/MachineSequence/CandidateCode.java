package MachineSequence;

import java.util.Arrays;

public class CandidateCode {
	private static int f = 0;
	
	public static void main(String[] args){
		String s = "1,5,9,2,3,5,6";
		System.out.println(sequences(s));
	}
	
	public static String sequences(String input1)
    {
		String[] str = input1.split(",");
		
		int[] arr = new int[str.length];
		for(int i = 0; i<str.length ; i++){
			arr[i] = Integer.valueOf(str[i]);
		}
		
		int[] result = cal(arr);
		
        return String.valueOf(result[0]);
    }
	
	public static int[] cal(int[] input){
		int[] result = null;
		if(f == 0){
			f  = 1;
		}
		
		if(input.length == 1){
			f = 2;
			return input;
		}
		
		if(f!=2){
			int[] a = new int[input.length - 1];
			for(int i = 1;i <input.length; i++){
				int c = input[i] - input[i-1];
				a[i-1] = c;
			}
			result =  cal(a);
		}
		return result;
	}
}
