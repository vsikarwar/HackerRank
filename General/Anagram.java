import java.util.Arrays;
import java.util.Scanner;

public class Anagram{
     
     public static void main(String[] args){
          Scanner in = new Scanner(System.in);
          String str1 = in.nextLine().trim();
          String str2 = in.nextLine().trim();
          boolean isAnagram = isAanagram(str1, str2);
          System.out.println(isAnagram);
     }

     public static boolean isAanagram(String str1, String str2){
          char[] c1 = str1.toCharArray();
          char[] c2 = str2.toCharArray();
          if(!(c1.length == c2.length)){
               return false;
          }
          sort(c1);
          sort(c2);
          System.out.println(Arrays.toString(c1));
          System.out.println(Arrays.toString(c2));
          for(int i = 0; i<c1.length; i++){
               if(!(c1[i] == c2[i])){
                    return false;
               }
          }
          return true;
     }

     public static void sort(char[] a){
          sort(a, 0, a.length-1);
     }
     
     private static void sort(char[] a, int p, int r){
          if(p<r){
               int q = (p+r)/2;
               sort(a, p, q);
               sort(a, q+1, r);
               merge(a, p, q, r);
          }
     }

     private static void merge(char[] a, int p, int q, int r){
          int n1 = q - p + 1;
          int n2 = r - q;

          char[] l1 = new char[n1+1];
          char[] l2 = new char[n2+1];
          
          l1[n1] = Character.MAX_VALUE;
          l2[n2] = Character.MAX_VALUE;
          
          for(int i = 0; i<n1; i++){
               l1[i] = a[i + p];
          }

          for(int i = 0; i<n2; i++){
               l2[i] = a[i + q + 1];
          }

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