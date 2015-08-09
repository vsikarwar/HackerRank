package MinimumDraws;

import java.util.Scanner;

public class A {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int cases = Integer.parseInt(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			int value = Integer.parseInt(in.nextLine().trim());
			calc(value);
		}
	}
	/*
	 * in worst case if we are highly unlucky then on each attempt we will fetch one socks of each pair
	 * and one pair+1 attemp we will get first matching sock (ie second sock on one of the pair)
	 * */
	public static void calc(int pairs){
		System.out.println(pairs + 1);
	}

}
