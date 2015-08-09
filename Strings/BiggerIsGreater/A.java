package BiggerIsGreater;

import java.util.Arrays;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int cases = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			String str = in.nextLine().trim();
			process(str);
		}
	}
	
	
	public static String process(String str){
		char[] a = str.toLowerCase().toCharArray();
		sort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		return null;
	}
	
	public static char search(char key, char[] a){
		int temp = a.length / 2;
		
		while(temp < a.length && a[temp] != key){
			if(a[temp]>key){
				temp = ((a.length - temp) + temp)/2;
			}else{
				temp = (a.length - temp)/2;
			}
		}
		
		if(temp<a.length-1){
			return a[temp+1];
		}else{
			return a[temp];
		}
	}
	
	public static void sort(char[] a, int p, int r){
		if(p<r){
			int q = (p+r)/2;
			sort(a, p, q);
			sort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static void merge(char[] a, int p, int q, int r){
		int n1 = q - p +1;
		int n2 = r - q;
		
		char[] l1 = new char[n1 + 1];
		char[] l2 = new char[n2 + 1];
		for(int i = 0; i<n1 ; i++){
			l1[i] = a[i + p];
		}
		for(int i = 0; i<n2; i++){
			l2[i] = a[i + q + 1];
		}
		l1[n1] = Character.MAX_VALUE;
		l2[n2] = Character.MAX_VALUE;
		
		int n = 0;
		int m = 0;
		
		for(int i = p; i<=r;i++){
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
