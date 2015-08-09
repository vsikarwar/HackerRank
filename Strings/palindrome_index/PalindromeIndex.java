package palindrome_index;

import java.util.Scanner;

public class PalindromeIndex{
    public static void main(String[] args){
         Scanner in = new Scanner(System.in);
         int cases = Integer.valueOf(in.nextLine().trim());
         for(int i = 0; i<cases; i++){
              String str = in.nextLine().trim();
              int a = findPalindromeIndex(str);
              System.out.println(a);
         }
    	
//    	int a = findPalindromeIndex("hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh");
//    	System.out.println(a);
    }

    public static int findPalindromeIndex(String str){
         int start = 0;
         int end = str.length() -1;
         while(start<end){
        	 char tem1 = str.charAt(start);
        	 char tem2 = str.charAt(end);
              if(str.charAt(start) != str.charAt(end)){
                   if(str.charAt(start) == str.charAt(end - 1) && str.charAt(start+1) == str.charAt(end - 2)){
                        return end;
                   }else if(str.charAt(start + 1) == str.charAt(end) && str.charAt(start+2) == str.charAt(end - 1)){
                        return start;
                   }
              }
              end--;
              start++;
         }
         return -1;
    }
}
