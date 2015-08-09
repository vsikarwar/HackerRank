
public class RemoveDuplicate{
     public static void main(String[] args){
          String input = "hello world!";
          String output = removeDuplicate(input);
          System.out.println(output);
     }

     //O(n^3)
     public static String removeDuplicate(String str){
          char[] c = str.toCharArray();
          for(int i = 0; i<c.length; i++){
               char temp = ' ';
               for(int j = i+1; j<c.length; j++){
                    if(c[i] == c[j]){ //found duplicate
                         for(int k = j+1; k<c.length; k++){
                              c[k-1] = c[k];
                         }
                         c[c.length-1] = ' ';
                    }
               }
          }
          return new String(c);
     }
}