package TheLongestIncreasingSubsequence;

public class LIS1 {
	
	public static void main(String[] args){
		int[] a = {15, 27, 14, 38, 26, 55, 46, 65, 85};
		//int[] a = {2,7,4,3,8};
		lis(a);
	}
	
	public static void lis(int[] a){
		int[] r = new int[a.length];
		for(int i = 0; i<a.length ; i++){
			r[i] = 1;
		}
		int max = 0;
		for(int i = 1; i<a.length; i++){
			for(int j = 0; j<i ; j++){
				if(a[i]>a[j] && r[j]+1 > r[i]){
					r[i] = r[j] + 1;
					if(r[i] > max){
						max = r[i];
					}
				}
			}
		}
		System.out.println(max);
	}

}
