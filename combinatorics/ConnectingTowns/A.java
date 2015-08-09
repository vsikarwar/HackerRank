package ConnectingTowns;

import java.util.Scanner;
import java.math.BigInteger;

public class A {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			int _a_size = Integer.parseInt(in.nextLine().trim());
			int[] _a = new int[_a_size - 1];
			String[] str = in.nextLine().trim().split(" ");
			for(int j = 0; j<_a_size-1; j++){
				_a[j] = Integer.parseInt(str[j]);
			}
			calc(_a);
		}
		
	}
	
	public static void calc(int[] a){
		
		BigInteger r = BigInteger.valueOf(a[0]);
		for(int i = 1; i<a.length; i++){
			r = r.multiply(BigInteger.valueOf(a[i]));
		}
		System.out.println(r.mod(BigInteger.valueOf(1234567)).toString());
	}
	
}
