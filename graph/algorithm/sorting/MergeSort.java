package algorithm.sorting;

import java.util.Arrays;
import java.util.Collections;

public class MergeSort {
	
	public static void main(String[] args){
		int[] a = {1,4,2,7,2,8,3,7,3,8,5};
		System.out.println(Arrays.toString(a));
		sort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		
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
