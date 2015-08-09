package symantec;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		int t = 8;
		int[] d = {1, 2, 3, 4, 6};
		System.out.println(triplets(t, d));
	}
	
	static int triplets(int t, int[] d){
		
		int[][] r = new int[d.length][d.length];
		int result = 0;
		for(int i = 0; i<d.length; i++){
			for(int j = i+1; j<d.length; j++){
				r[i][j] = d[i] + d[j]; 
				for(int k = i-1; k>=0; k--){
					//System.out.println(r[k][j] + d[j]);
					if(r[k][j] + d[j] <= t){
						result++;
					}
				}
				//if(i>=1 && r[i-1][i]+d[j] <= t){
				//	result++;
				//}
				
			}
		}
		
//		for(int i = 0; i<d.length; i++){
//			System.out.println(Arrays.toString(r[i]));
//		}
//		
//		for(int i = 0; i<d.length; i++){
//			for(int j = i+1; j<d.length; j++){
//				int temp  = t - r[i][j];
//				for(int k = j+1; k<d.length; k++){
//					if(d[k] <= temp){
//						result++;
//					}
//				}
//			}
//		}
		
		
		/*int result = 0;
		for(int i = 0; i<d.length; i++){
			for(int j = i+1; j<d.length; j++){
				for(int k = j+1; k<d.length; k++){
					if(d[i]<d[j] && d[j]<d[k] && d[i] + d[j] + d[k] <= t){
						result++;
					}
				}
			}
		}*/
		
		return result;
	}
	
	public static void sort(int[] a){
		sort(a, 0, a.length-1);
	}

	public static void sort(int[] a, int p, int r){
		if(p<r){
			int q = (p+r)/2;
			sort(a, p, q);
			sort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	private static void merge(int[] a, int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		
		int[] l1 = new int[n1+1];
		int[] l2 = new int[n2+1];
		l1[n1] = Integer.MAX_VALUE;
		l2[n2] = Integer.MAX_VALUE;
		
		for(int i = 0; i< n1; i++){
			l1[i] = a[i + p];
		}
		
		for(int i = 0; i<n2; i++){
			l2[i] = a[i + q +1];
		}
		
		int m = 0;
		int n = 0;
		
		for(int i = p; i<=r; i++){
			if(l1[m] < l2[n]){
				a[i] = l1[m];
				m++;
			}else{
				a[i] = l2[n];
				n++;
			}
		}
	}
}
