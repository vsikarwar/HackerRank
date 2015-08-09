package barclays;

public class oscillatingSlice {
	
	public static void main(String[] args){
		int[] a = {5, 0, -2, 6, 3, 4, 4, -3, 5};
		System.out.println(solution(a));
	}
	
	public  static int solution(int[] A){
		
		int start = 0;
		int end = 0;
		int last = 0;
		int max = 0;
		
		for(int i = 1; i<A.length; i++){
			int curr = A[i] - A[i-1];
			if(curr < 0) curr = -1;
			if(curr > 0) curr = 1;
			
			if(curr == 0){
				start = i;
				end = start+1;
			}else if(last != curr){
				end++;
			}else{
				start = i;
				end = start+1;
			}
			last = curr;
			if(max < (end - start)){
				max = end-start;
			}
		}
		return max+1;
	}

}
