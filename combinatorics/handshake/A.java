package handshake;

import java.util.Scanner;

public class A {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			int val = Integer.parseInt(in.nextLine().trim());
			calc(val);
		}
		
		//calc(5);
	}
	/*
	 * if there is one person then handshakes will be 0
	 * if there are two persone then handshakes will be 1
	 * if there are three person then total handshakes will be (handshakes done by 2 person) + (handshake done by 3rd person ie 2,
	 * one with person one and second with person two)
	 * similarly if there are four person then total handshakes will be (handshakes done by 3 person) + (
	 * handshake done by 4th person, ie (4-3= 3) one with first person, second with second person and third with 
	 * third person)
	 * therefore we have r[i] handshake done by i th person = r[i-1] (handshake done by i-1 th person) + (i - 1) 
	 * (handshake done by ith person with remaining i-1 th persons.
	 * */
	public static void calc(int n){
		int[] r = new int[n+1];
		if(n > 0){
			r[0] = 0;
			for(int i = 1; i<=n; i++){
				r[i] = r[i-1] + (i-1);
			}
			System.out.println(r[r.length - 1]);
		}else{
			System.out.println(0);
		}
		
	}
}
