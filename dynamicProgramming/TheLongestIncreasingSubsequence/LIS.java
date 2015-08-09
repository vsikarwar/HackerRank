package TheLongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LIS {
	
	public static void main(String[] args){
		//int[] a = {15, 27, 14, 38, 26, 55, 46, 65, 85};
		
		//int[] a = {15, 27, 14, 38, 26, 55, 46, 55, 65, 85};
		
		
		Scanner in = new Scanner(System.in);
		int input = Integer.parseInt(in.nextLine().trim());
		int[] a = new int[input];
		for(int i= 0; i<input; i++){
			a[i] = Integer.parseInt(in.nextLine().trim());
		}
		
		System.out.println(lis(a));
		
	}
	
	public static int lis(int[] a){
		int maxLIS = 0;
		List<List<Integer>> lis = new ArrayList<>();
		for(int i = 0; i< a.length; i++){
			int max = 1;
			int maxIndex = -1;
			for(int j = 0; j<i; j++){
				List<Integer> lst = lis.get(j);
				if(a[i] > lst.get(lst.size() - 1)){
					if(lst.size() + 1 > max){
						max = lst.size()+1;
						maxIndex = j;
					}
				}
			}
			
			if(max > maxLIS){
				maxLIS = max;
			}
			
			if(maxIndex != -1){
				List<Integer> newList = new ArrayList<>();
				newList.addAll(lis.get(maxIndex));
				newList.add(a[i]);
				lis.add(newList);
			}else{
				List<Integer> l = new ArrayList<>();
				l.add(a[i]);
				lis.add(l);
			}
			
		}
		
//		int max = 0;
//		for(List<Integer> lst : lis){
//			if(max < lst.size()){
//				max = lst.size();
//			}
//		}
		
		return maxLIS;
	}

}
