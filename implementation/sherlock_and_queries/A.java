package sherlock_and_queries;

import java.util.Arrays;

public class A {
	public static void main(String[] args){
		int[] a= {1, 2, 3, 4};
		int[] b = {1, 2, 3};
		int[] c = {13, 29,71};
		process(a, b, c);
	}
	
	public static void process(int[] a, int[] b, int[] c){
		for(int i = 1; i<=b.length; i++){
			for(int j = 1; j<=a.length; j++){
				if(j % b[i-1] == 0){
					a[j-1] = a[j-1] * c[i-1];
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
}
