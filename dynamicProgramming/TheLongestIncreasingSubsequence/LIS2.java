package TheLongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class LIS2 {
	public static void main(String[] args){
		//int[] a = {15, 27, 14, 38, 26, 55, 46, 65, 85};
		//int[] a = {1,2,3,4,5,6};
		Scanner in = new Scanner(System.in);
		int input = Integer.parseInt(in.nextLine().trim());
		int[] a = new int[input];
		for(int i= 0; i<input; i++){
			a[i] = Integer.parseInt(in.nextLine().trim());
		}
		lis(a);
		
	}
	
	public static void lis(int[] a){
		int[] p = new int[a.length];
		int[] m = new int[a.length + 1];
		
		int l = 0;
		
		for (int i = 0; i< a.length; i++){
			int lo = 1;
			int hi = l;
			while(lo <= hi){
				int mid = (lo + hi)/2;
				if(a[m[mid]] < a[i]){
					lo = mid + 1;
				}else{
					hi = mid - 1;
				}
			}
			
			int newL = lo;
			p[i] = m[newL-1];
			m[newL] = i;
			
			if(newL > l){
				l = newL;
			}
			
		}
		System.out.println(l);
		//System.out.println(Arrays.toString(m));
		//System.out.println(Arrays.toString(p));
		int[] s= new int[a.length];
		int k = m[l];
		for(int i = l-1; i>=0; i--){
			s[i] = a[k];
			k = p[k];
		}
		
		//System.out.println(Arrays.toString(s));
	}
}
