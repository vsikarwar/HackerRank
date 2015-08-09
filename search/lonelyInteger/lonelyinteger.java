package lonelyInteger;
import java.util.Scanner;

import algorithm.sorting.MergeSort;

public class lonelyinteger {
	
	static int lonelyinteger(int[] a) {
		MergeSort.sort(a);
		for(int i = 1; i<a.length; i=i+2){
			if(a[i-1]!=a[i]){
				return a[i-1];
			}
		}
		return a[a.length - 1];
    }
	
	
	public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int res;
	        
	        int _a_size = Integer.parseInt(in.nextLine());
	        int[] _a = new int[_a_size];
	        int _a_item;
	        String next = in.nextLine();
	        String[] next_split = next.split(" ");
	        
	        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
	            _a_item = Integer.parseInt(next_split[_a_i]);
	            _a[_a_i] = _a_item;
	        }
	        
	        res = lonelyinteger(_a);
	        System.out.println(res);
	        
	    }
}
