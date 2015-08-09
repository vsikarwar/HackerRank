package barclays;

import java.util.HashMap;
import java.util.Map;

public class points {
	public static void main(String[] args){
		int[] a = {-3, -2, 1, 0, 8, 7,1 };
		//System.out.println(solution(a, 3));
		
		Map key = new HashMap();
		
		key.put("hi", 1);
		key.put("HI", 1);
		
		System.out.println(key.size());
	}
	
	public static int solution(int[] A, int M){
		int max = 0;
		for(int i = 0; i<A.length; i++){
			int count = 0;
			for(int j = 0; j<i; j++){
				if(Math.abs(A[i] - A[j])%M == 0){
					count++;
				}
			}
			if(max<count){
				max = count;
			}
		}
		return max+1;
	}
}
