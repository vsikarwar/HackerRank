package barclays;

public class Coins {
	public static void main(String[] args){
		int[] a = {1, 1, 0, 1, 0, 0, 1, 1};
		System.out.println(solution(a));
	}
	
	public static int solution(int[] A){
		int adj = 0;
		int newAdj = 0;
		int max = 0;
		
		for(int i = 1; i<A.length; i++){
			if(A[i-1]-A[i] == 0){
				adj++;
			}
		}
		max = adj;
		
		for(int i = 0; i<A.length; i++){
			newAdj = adj;
			if(i-1 > 0 && A[i-1]-A[i] != 0){
				newAdj++;
			}
			
			if(i+1<A.length && A[i]-A[i+1] != 0 ){
				newAdj++;
			}
			if(max < newAdj){
				max = newAdj;
			}
		}
		
		
		return max;
	}
}
