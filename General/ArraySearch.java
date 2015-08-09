import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArraySearch {
	
	public static void main(String[] args){
		
		int[] input = {1,2,3,5,1};
		//int[] i = search(input);
		//System.out.println(Arrays.toString(search(input)));
		
		//System.out.println(validate("3num"));
		//System.out.println(convert(727));
		System.out.println(minimumDenominations(100));
		
		//System.out.println(Arrays.toString(sortArray(input)));
		
	}
	
	public static int[] sortArray(int[] arr){
		
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(1, "one");
		map1.put(2, "two");
		map1.put(3, "three");
		map1.put(4, "four");
		map1.put(5, "five");
		map1.put(6, "six");
		map1.put(7, "seven");
		map1.put(8, "eight");
		map1.put(9, "nine");
		map1.put(0, "zero");
		
		List<String> lst = new ArrayList<String>();
		for(int i = 0; i<arr.length; i++){
			lst.add(map1.get(arr[i]));
		}
		Collections.sort(lst);
		
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put( "one", 1);
		map2.put( "two", 2);
		map2.put( "three", 3);
		map2.put( "four", 4);
		map2.put( "five", 5);
		map2.put( "six", 6);
		map2.put( "seven", 7);
		map2.put( "eight", 8);
		map2.put( "nine", 9);
		map2.put("zero", 0);
		
		int[] result = new int[arr.length];
		for(int i = 0; i<result.length ; i++){
			result[i] = map2.get(lst.get(i));
		}
		
		return result;
		
	}
	
	public static int minimumDenominations(int totalAmount){
		int[] given = {1, 2, 5, 10, 20};
		
		int count = 0;
		while(totalAmount >= given[4]){
			totalAmount = totalAmount - given[4];
			count++;
		}
		
		while(totalAmount >= given[3]){
			totalAmount = totalAmount - given[3];
			count++;
		}
		
		while(totalAmount >= given[2]){
			totalAmount = totalAmount - given[2];
			count++;
		}
		
		while(totalAmount >= given[1]){
			totalAmount = totalAmount - given[1];
			count++;
		}
		
		while(totalAmount >= given[0]){
			totalAmount = totalAmount - given[0];
			count++;
		}
		
		return count;
	}
	
	
	
	
	public static int convert(int num){
		
		List<Integer> result = new ArrayList<Integer>();
		
		int n = num;
		int d = 5;
		int q = 0;
		
		while(n >= 5){
			q = n % d;
			n = n / d;
			result.add(q);
		}
		result.add(n%d);
		
		StringBuilder sb = new StringBuilder();
		for(int i = result.size() - 1; i>=0; i--){
			sb.append(result.get(i));
		}
		
		return Integer.valueOf(sb.toString());
	}
	
	public static boolean validate(String identifier){
		
		boolean result = false;
		if(identifier.length() > 0 && identifier.length() <= 10){
			Character c = identifier.charAt(0);
			String s = String.valueOf(c);
			
			if(s.matches("$|_|[a-z]|[A-Z]")){
				for(int i = 1; i<identifier.length(); i++){
					c = identifier.charAt(i);
					s = String.valueOf(c);
					if(s.matches("$|_|[a-z]|[A-Z]|[0-9]")){
						result = true;
					}else{
						return false;
					}
				}
			}
		}
			
		return result;
	}
	
	public static int[] search(int[] input){
		
		List<Integer> lst = new ArrayList<Integer>();
		
		for(int i = 0; i<input.length; i++){
			lst.add(input[i]);
		}
		
		Collections.sort(lst);
		
		int[] result = new int[2];
		result[0] = lst.get(0);
		result[1] = lst.get(1);
		
		return result;
	}
}
