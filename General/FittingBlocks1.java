import java.util.*;


public class FittingBlocks1 {
	public static void main(String[] args){
		int[] a = {5, 8, 12, 15, 20, 21,15,5,15};
		int b = 20;
		System.out.println(fittingBlocks(a, b));
	}
	
	public static String fittingBlocks(int[] a, int b){
		sort(a, 0, a.length - 1);
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i<a.length; i++){
			if(map.get(a[i]) == null){
				map.put(a[i], 0);
			}
			int val = map.get(a[i]) + 1;
			map.put(a[i], val);
		}
		
		for(int i = 0; i<a.length; i++){
			int temp = Math.abs(b - a[i]);
			if(map.get(temp) != null){
				if(temp > a[i]){
					if(map.get(a[i]) <= map.get(temp)){
						for(int j = 0; j<map.get(a[i]); j++)
							sb.append(a[i] + "+" + temp + ",");
					}else{
						for(int j = 0; j<map.get(temp); j++)
							sb.append(a[i] + "+" + temp + ",");
					}
					
				}
				map.remove(temp);
				map.remove(a[i]);
			}
		}
		return sb.toString().substring(0, sb.length()-1);
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
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int[] l1 = new int[n1+1];
		int[] l2 = new int[n2+1];
		
		for(int i = 0; i<n1; i++){
			l1[i] = a[i+p];
		}
		for(int i = 0; i<n2; i++){
			l2[i] = a[i+q+1];
		}
		
		l1[n1] = Integer.MAX_VALUE;
		l2[n2] = Integer.MAX_VALUE;
		
		int m = 0;
		int n = 0;
		
		for(int i = p; i<=r; i++){
			if(l1[m] < l2[n]){
				a[i] = l1[m];
				m++;
			}else{
				a[i] = l2[n];
				n++;
			}
		}
	}
}
