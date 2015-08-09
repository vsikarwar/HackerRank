package team_formation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class A {
	public static void main(String[] args){
		process();
		//readInput();
	}
	
	public static void process(){
		int[] a = {4, 5, 2, 3, -4, -3, -5};
		//int[] a = {3, 2, 3, 1};
		//int[] a = new int[1];
		//int[] a= {1, -2, -3, -4, 2, 0, -1};
		//int [] a = {-4 };
		//int[] a = {101, 102, 103, 104, 105, 106, 103, 104};
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
		calc1(a);
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		int cases = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i< cases; i++){
			String[] val = in.nextLine().trim().split(" ");
			int _a_size = Integer.valueOf(val[0]);
			int[] a = new int[_a_size];
			for(int j = 0; j<_a_size; j++){
				a[j] = Integer.valueOf(val[j+1]);
			}
			sort(a, 0, a.length - 1);
			if(a.length == 0){
				System.out.println(0);
			}else{
				calc(a);
			}
			
		}
	}
	
	public static void sort(int[] a, int p,int r){
		if(p<r){
			int q = (p+r)/2;
			sort(a, p, q);
			sort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static void merge(int[] a, int p , int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		
		int[] l = new int[n1+1];
		int[] m = new int[n2+1];
		
		for(int i =0; i<n1; i++){
			l[i] = a[p+i];
		}
		
		for(int i = 0; i<n2; i++){
			m[i] = a[i+ q +1];
		}
		
		l[n1] = Integer.MAX_VALUE;
		m[n2] = Integer.MAX_VALUE;
		
		int j = 0;
		int k = 0;
		
		for(int i = p; i<=r; i++){
			if(l[j]<m[k]){
				a[i] = l[j];
				j++;
			}else{
				a[i] = m[k];
				k++;
			}
		}
	}
	
	public static void calc1(int[] a){
		
		List<List<Integer>> teams = new ArrayList<>();
		List<Integer> team = new ArrayList<>();
		int index = 0;
		team.add(a[0]);
		teams.add(team);
		for(int i = 1; i<a.length; i++){
			if(a[i] == a[i-1] + 1){
				index = teams.size() - 1;
				team = teams.get(index);
				team.add(a[i]);
			}else if(a[i] == a[i-1]){
				if(index == 0){
					team = new ArrayList<>();
					team.add(a[i]);
					teams.add(team);
				}else{
					team = teams.get(index-1);
					if(team.get(team.size() - 1) == a[i] - 1){
						team.add(a[i]);
						index = index -1;
					}else{
						team = new ArrayList<>();
						team.add(a[i]);
						teams.add(team);
					}
				}
			}else{
				team = new ArrayList<>();
				team.add(a[i]);
				teams.add(team);
			}
		}
		
		int minSize = Integer.MAX_VALUE;
		for(int i = 0; i<teams.size(); i++){
			if(minSize > teams.get(i).size()){
				minSize = teams.get(i).size();
			}
		}
		
		System.out.println(minSize);
	}
	
	public static void calc(int[] a){
		
		List<Integer> teams = new ArrayList<>();
		List<Integer> size = new ArrayList<>();
		
		teams.add(a[0]);
		size.add(1);
		for(int i = 1; i<a.length; i++){
			int index = -1;
			int minSize = Integer.MAX_VALUE;
			for(int j = 0; j<teams.size(); j++){
				if(teams.get(j)+1 == a[i]){
					if(minSize>=size.get(j)){
						minSize = size.get(j);
						index = j;
					}
				}
			}
			
			if(index == -1){
				teams.add(a[i]);
				size.add(1);
			}else{
				teams.set(index, a[i]);
				size.set(index, size.get(index)+1);
			}
		}
		int ms = Integer.MAX_VALUE;
		
		for(int s : size){
			if(ms >= s){
				ms = s;
			}
		}
		System.out.println(ms);
	}
}
