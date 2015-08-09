package FibonacciModified;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
	static List<BigInteger> mem = new ArrayList<>();
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String[] str = in.nextLine().trim().split(" ");
		
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int n = Integer.parseInt(str[2]);
		
		calc(a, b, n);
	}
	
	public static void calc(int a, int b, int n){
		for(int i = 0; i<n ; i++){
			if(i == 0){
				mem.add(BigInteger.valueOf(a));
			}else if(i == 1){
				mem.add(BigInteger.valueOf(b));
			}else{
				BigInteger n2 = mem.get(i - 2);
				BigInteger n1 = mem.get(i-1);
				mem.add((n1.multiply(n1)).add(n2));
			}
		}
		System.out.println(mem.get(mem.size()-1).toString());
	}
}
