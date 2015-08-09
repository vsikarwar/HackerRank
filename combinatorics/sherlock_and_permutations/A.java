package sherlock_and_permutations;

import java.math.BigInteger;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args){
		
		int n = 500; // number of 0's
		int m = 900; //number of 1's
		
		BigInteger calc  = calc(n,m);
		System.out.println(calc.toString());
		
		BigInteger res = mod(calc(n, m));
		System.out.println(res.toString());
		//readInput();
		
	}
	
	public static BigInteger mod(BigInteger x){
		return x.mod(BigInteger.valueOf(1000000007));
		
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		int cases = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			String[] vals = in.nextLine().trim().split(" ");
			int n = Integer.valueOf(vals[0]);
			int m = Integer.valueOf(vals[1]);
			BigInteger res = mod(calc(n, m));
			System.out.println(res.toString());
		}
	}
	
	public static BigInteger calc(int n, int m){
		if(m <= 0 ){
			return BigInteger.valueOf(0);
		}
		if(m == 1){
			return BigInteger.valueOf(1);
		}
		
		BigInteger num = fact(BigInteger.valueOf(n).add(BigInteger.valueOf(m-1)));
		BigInteger deno = mod(fact(BigInteger.valueOf(n)).multiply(fact(BigInteger.valueOf(m-1))));
		deno = deno(deno);
		return mod(num.multiply(deno));
	}
	
	public static BigInteger deno(BigInteger x){
		int pow = 1000000007 - 2;
		
		return mod(x.pow(pow));
	}
	
	public static BigInteger fact(BigInteger x){
		BigInteger temp = BigInteger.valueOf(1);
		for(BigInteger i = BigInteger.valueOf(1); i.compareTo(x) <= 0;  i = i.add(BigInteger.valueOf(1))){
			temp = mod(temp.multiply(i));
		}
		return mod(temp);
	}
	
}
