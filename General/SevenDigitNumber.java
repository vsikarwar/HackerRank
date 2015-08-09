import java.util.*;

public class SevenDigitNumber {
	public static void main(String[] args){
		System.out.println(process());
	}
	
	public static int process(){
		List<Integer> expected = new ArrayList<>();
		//create set of 3 digits
		Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
		for(int i = 1; i<=9; i++){
			for(int j = 1; j<=9; j++){
				for(int k = 1; k<=9; k++){
					if(i != j && j != k && k!= i){
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(j);
						list.add(k);
						int temp = i*j*k;
						if(map.get(temp) == null){
							map.put(temp, new ArrayList<List<Integer>>());
						}
						map.get(temp).add(list);
						if(map.get(temp).size() >= 3){
							expected.add(temp);
						}
					}
				}
			}
		}
		
		for(int i = 0; i<expected.size() ; i++){
			List<List<Integer>> lst = map.get(expected.get(i));

			for(int k = 0; k<lst.size() ; k++){
				List<Integer> list1 = lst.get(k);
				List<Integer> digit = new ArrayList<>();
				digit.addAll(list1);
				for(int l = 0; l<lst.size(); l++){
					if(k != l){
						List<Integer> list2 = lst.get(l);
						if(list2.get(0) == digit.get(2) && !digit.contains(list2.get(1)) && !digit.contains(list2.get(2))){
							digit.add(list2.get(1));
							digit.add(list2.get(2));
							for(int m = 0; m<lst.size(); m++){
								if(m!= k && k!= l && l!= m){
									List<Integer> list3 = lst.get(m);
									if(list3.get(0) == digit.get(4) && !digit.contains(list3.get(1)) && !digit.contains(list3.get(2))){
										digit.add(list3.get(1));
										digit.add(list3.get(2));
									}
								}
							}
						}
					}
				}
				if(digit.size() == 7){
					//System.out.println(digit.get(3));
					return digit.get(3);
					//verify(digit);
				}
					
			}
			
		}
		return -1;
		
	}
	
	/*public static void verify(List<Integer> digit){
		int val1 = digit.get(0) * digit.get(1) * digit.get(2);
		int val2 = digit.get(2) * digit.get(3) * digit.get(4);
		int val3 = digit.get(4) * digit.get(5) * digit.get(6);
		
		if(val1 != val2 || val2!=val3 || val3!= val1){
			System.out.println(false);
		}
		
		for(int i = 0; i<digit.size(); i++){
			for(int j = 0; j<digit.size() ; j++){
				if(i!=j && digit.get(i) == digit.get(j)){
					System.out.println(false);
				}
			}
		}
	}*/
	
}
