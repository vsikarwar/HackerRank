package KnapSack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

//https://www.hackerrank.com/challenges/unbounded-knapsack
public class A {

	public static void main(String[] args){
		//int[] a = {1, 6, 9};
		//int expected = 12;
		int[] a= {3, 4, 4, 4, 8};
		int expected = 9;
		//System.out.println(getResult(a, expected));
		
		
    		
    		System.out.println(getResult(a, expected));
	}

	public static void readInput(){
		Scanner in = new Scanner(System.in);
        int res;
        
        int cases = Integer.parseInt(in.nextLine().trim());
        
        for(int i = 0; i<cases; i++){
        	
        	String values = in.nextLine().trim();
        	String[] value = values.split(" ");
        	int _a_size = Integer.parseInt(value[0]);
        	int expected = Integer.parseInt(value[1]);
        	
        	int[] _a = new int[_a_size];
        	int _a_item;
            String next = in.nextLine().trim();
            String[] next_split = next.split(" ");
            for(int _a_i = 0; _a_i < _a_size; _a_i++) {
                _a_item = Integer.parseInt(next_split[_a_i]);
                _a[_a_i] = _a_item;
            }
            
            System.out.println(getResult(_a, expected));
            
        }
	}
	
	public static int getResult(int[] a, int expected){
		
		Set<Integer> list = new HashSet<>();
		for(int i = 0; i<a.length; i++){
			list.add(a[i]);
		}
		
		for(int i = 1; i<=expected; i++){
			LinkedList<Integer> temp = new LinkedList<>(list);
			while(!temp.isEmpty()){
				int val = temp.removeFirst();
				if(val < expected){
					for(int j = 0; j<a.length; j++){
						if(val + a[j] < expected){
							list.add(val + a[j]);
						}else if(val+a[j] == expected){
							return expected;
						}
					}
				}
			}
		}
		
		//condition if all the elements in the array is greater than expected value then return 0
		//condition if no exact match found then return nearest value.
		int max = 0;
		for(Integer i : list){
			if(max < i && i<=expected){
				max = i;
			}
		}
		
		return max;
	}
	
}
