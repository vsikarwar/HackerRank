package OutOfDateSoftware;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
    public static int processData(ArrayList<String> array) {
    	Set<String> lines = new HashSet<String>();
    	Map<String, Version> map = new HashMap<String, Version>();
    	int count = 0;
    	
    	for(String str : array){
    		if(!lines.contains(str)){
    			lines.add(str);
    			String[] inputArr = str.split(",");
    			Version ver = new Version(inputArr[3].trim());
    			System.out.println(ver);
    			String key = inputArr[1].trim().concat(inputArr[2].trim());
    			//map.put(key, ver);
    			Version oldVer = map.get(key);
    			if(oldVer == null){
    				map.put(key, ver);
    			}else if(oldVer.compareTo(ver) == 1){
    				count++;
    			}else if(oldVer.compareTo(ver) == -1){
    				map.put(key, ver);
    				count++;
    			}
    		}
    	}
    	
    	return count;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (!line.isEmpty()) // Ignore blank lines
                    inputData.add(line);
            }
            int retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            output.println("" + retVal);
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
    
    private static class Version implements Comparable<Version>{
    	private List<Integer> ver = new ArrayList<Integer>();
    	
    	public Version(String val){
    		String[] str = val.split("\\.");
    		for(int i = 0; i<str.length ; i++){
    			ver.add(Integer.valueOf(str[i]));
    		}
    	}
    	
		public List<Integer> getVer() {
			return ver;
		}

		private int compareTo(List<Integer> o) {
			int size = (ver.size() <= o.size()) ?  ver.size() : o.size();
			
			for(int i = 0; i<size; i++){
				if(ver.get(i) > o.get(i)){
					return 1;
				}else if (ver.get(i) < o.get(i)){
					return -1;
				}
			}
			return 0;
		}
		@Override
		public String toString() {
			return "Version [ver=" + ver + "]";
		}


		@Override
		public int compareTo(Version o) {
			return this.compareTo(o.getVer());
		}
    }
    
}
