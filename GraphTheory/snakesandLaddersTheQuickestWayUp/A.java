package snakesandLaddersTheQuickestWayUp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*
3
3,7
32,62 42,68 12,98
95,13 97,25 93,37 79,27 75,19 49,47 67,17
5,8
32,62 44,66 22,58 34,60 2,90
85,7 63,31 87,13 75,11 89,33 57,5 71,15 55,25
4,9
8,52 6,80 26,42 2,72
51,19 39,11 37,29 81,3 59,5 79,23 53,7 43,33 77,21
 * */
public class A {
	
	static Map<Integer, Integer> ladders;
	static Map<Integer, Integer> snakes;

	public static void main(String[] args){
		
		String lstr = "8,52 6,80 26,42 2,72";
		String sstr = "51,19 39,11 37,29 81,3 59,5 79,23 53,7 43,33 77,21";
		readInput();
		//createMap(lstr, sstr);
		//calc();
	}
	
	public static void createMap(String lstr, String sstr){
		ladders = new HashMap<>();
		snakes = new HashMap<>();
		String[] l = lstr.split(" ");
		for(String str : l){
			String[] ltemp = str.split(",");
			ladders.put(Integer.valueOf(ltemp[0]), Integer.valueOf(ltemp[1]));
		}
		
		String[] s = sstr.split(" ");
		for(String str : s){
			String[] stemp = str.split(",");
			snakes.put(Integer.valueOf(stemp[0]), Integer.valueOf(stemp[1]));
		}
	}
	
	public static void readInput(){
		
		Scanner in = new Scanner(System.in);
		int cases = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			String[] strarr = in.nextLine().trim().split(" ");
			String str1 = in.nextLine().trim();
			String str2 = in.nextLine().trim();
			createMap(str1, str2);
			calc();
		}
		
	}
	
	public static void calc(){
		int[] r = new int[100];
		r[0] = 0;

		LinkedList<Integer> queue = new LinkedList<>();
		LinkedList<Integer> seen = new LinkedList<>();
		queue.add(1);
		while(!queue.isEmpty()){
			int move = queue.removeFirst();
			
			for(int i = move+1; i<=move+6 && i<=100; i++){
				if(ladders.get(i)!= null){
					if(!seen.contains(ladders.get(i))){
						queue.add(ladders.get(i));
						seen.add(ladders.get(i));
						r[ladders.get(i) - 1] = r[move - 1] + 1;
					}
				}else if(snakes.get(i)!=null){
					if(!seen.contains(snakes.get(i))){
						queue.add(snakes.get(i));
						seen.add(snakes.get(i));
						r[snakes.get(i) - 1] = r[move - 1] + 1;
					}
				}else{
					if(!seen.contains(i)){
						queue.add(i);
						seen.add(i);
						r[i-1] = r[move-1] + 1;
					}
				}
			}
		}
		
		System.out.println(r[r.length - 1]);
	}
}
