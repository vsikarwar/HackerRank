package icecream_parlor;

import java.util.*;

/*
 * problem is to find the pair of indices (i and j) having the given sum T
 * 
 * To solve : 
 * create a hash map having key as number and value as indice.
 * for first key -> substract it from the given number (T-key1) and find the result in the hash map
 * if the result is present then retrun the value ie indices of both the number
 * */
public class A {

	
	public static void main(String[] args){
		readInput();
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		int cases = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			int t = Integer.valueOf(in.nextLine().trim());
			int size = Integer.valueOf(in.nextLine().trim());
			int[] a= new int[size];
			String[] str = in.nextLine().trim().split(" ");
			for(int j = 0; j<str.length; j++){
				a[j] = Integer.valueOf(str[j]);
			}
			solve(a, t);
		}
	}
	
	public static void solve(int[] a, int t){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<a.length; i++){
			if(a[i] < t){
				int d = t-a[i];
				if(map.get(a[i]) != null){
					System.out.println((map.get(a[i])+1) + " " + (i+1));
					break;
				}
				if(map.get(d) == null){
					map.put(d, i);
				}
			}
		}
	}
}
