package Equal;

import java.util.*;

public class Equal{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int cases = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			int persons = Integer.valueOf(in.nextLine().trim());
			int[] p = new int[persons];
			String[] pstr = in.nextLine().trim().split(" ");
			for(int j = 0; j<persons; j++){
				p[j] = Integer.valueOf(pstr[j]);
			}
			
			sort(p);
			
			processInput(p);
		}
	}
	
	public static void sort(int[] a){
		sort(a, 0, a.length-1);
	}
	
	public static void sort(int[] a, int p, int r){
		if(p<r){
			int q = (p+r)/2;
			sort(a, p, q);
			sort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static void merge(int[] a, int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		
		int[] l1 = new int[n1+1];
		int[] l2 = new int[n2+1];
		
		for(int i = 0; i<n1; i++){
			l1[i] = a[p+i];
		}
		
		for(int i = 0; i<n2; i++){
			l2[i] = a[q+i+1];
		}
		
		l1[n1] = Integer.MAX_VALUE;
		l2[n2] = Integer.MAX_VALUE;
		
		int m = 0;
		int n = 0;
		
		for(int i = p ; i<=r; i++){
			if(l1[m] < l2[n]){
				a[i] = l1[m];
				m++;
			}else{
				a[i] = l2[n];
				n++;
			}
		}
	}

	
	public static void processInput(int[] p){
		int[] r = new int[p.length];
		int[] s = new int[p.length];
		r[0] = 0;
		s[0] = 0;
		for(int i = 1; i<p.length; i++){
			if(p[i-1] - p[i] == 0){
				r[i] = 0;
			}else{
				int diff = p[i] - p[i-1];
				if(diff == 4){
					for(int j=i;j<p.length; j++) p[j] += 1;
					r[i] += 1;
				}
				diff = p[i] - p[i-1];
				for(int j = i+1; j<p.length; j++)  p[j] += diff;
				
				while(diff > 0){
					if(diff >= 5){
						diff -= 5;
					}else if(diff >= 2){
						diff -= 2;
					}else{
						diff -= 1;
					}
					r[i] += 1;
				}
			}
		}
		
		int ops = 0;
		for(int i = 0; i<r.length; i++) ops += r[i];
		
		System.out.println(ops);
		
	}
	
}
