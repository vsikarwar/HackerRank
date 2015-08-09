package favourite_sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class FavouriteSequence1 {
	static List<List<Integer>> input = new ArrayList<>();
	
	public static void main(String[] args){
		readInput();
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		int cases = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			int k = Integer.valueOf(in.nextLine().trim());
			String[] str = in.nextLine().trim().split(" ");
			List<Integer> inlst = new ArrayList<>();
			for(String s : str){
				inlst.add(Integer.valueOf(s));
			}
			input.add(inlst);
		}
		
		processInput();
	}
	
	public static void processInput(){
		int small = input.get(0).get(0);
		int index = 0;
		for(int i = 0; i<input.size(); i++){
			if(small > input.get(i).get(0)){
				small = input.get(i).get(0);
				index = i;
			}
		}
		
		List<Integer> output = new ArrayList<>(input.get(index));
		
		for(int i = 0; i<input.size(); i++){
			if(index == i){
				continue;
			}
			List<Integer> l = input.get(i);
			int outputIndex = 0;
			for(int j = 0; j<l.size(); j++){
				boolean isValid = true;
				for(int k = outputIndex; k<output.size(); k++){
					if(l.get(j) == output.get(k)){
						isValid = false;
						break;
					}
					if(l.get(j) < output.get(k)){
						output.add(k, l.get(j));
						outputIndex = k+1;
						isValid = false;
						break;
					}
					
				}
				if(isValid) {
					output.add(l.get(j));
					outputIndex = output.size();
				}
			}
			
		}
		
		String out = "";
		for(Integer oint : output){
			out += oint + " ";
		}
		System.out.println(out.trim());
		
	}
}
