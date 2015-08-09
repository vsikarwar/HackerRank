package alternating_characters;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args){
		
		List<Integer> lst = new ArrayList<Integer>();
		
		for(Integer i : lst){
			System.out.println("inside for");
		}
		System.out.println("outside for");
		
//		Scanner in = new Scanner(System.in);
//		int testCase = Integer.valueOf(in.nextLine());
//		
//		for(int i = 0; i<testCase; i++){
//			String str = in.nextLine();
//			int res = calc(str);
//			System.out.println(res);
//		}
	}
	
	public static int calc(String str){
		int count = 0;
		char[] c = str.toCharArray();
		if(c.length == 1){
			return count;
		}
		
		for(int i = 1; i<c.length; i++){
			if(c[i-1] == c[i]){
				count++;
			}
		}
		
		return count;
	}

}
