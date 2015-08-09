import java.util.Scanner;

public class StringReverse{
     public static void main(String[] args){
          Scanner in = new Scanner(System.in);
          String str = in.nextLine().trim();
          System.out.println(str);
          String reverseString = reverse(str);
          System.out.println(reverseString);
     }
     
	public static String reverse(String str){
	
	     char[] a = str.toCharArray();
	     char temp = ' ';
	     int start = 0;
	     int end = a.length - 1;
	     
	     while(end > start){
	          temp = a[start];
	          a[start] = a[end];
	          a[end] = temp;
	          start++;
	          end--;
	     }
	     return new String(a);
	}
}