import java.util.Stack;

public class ReverseWodsOfString {
	public static void main(String[] args){
		String input = "I am a human being";
		System.out.println(reverseWordsOfSentence(input));
	}
	
	public static String reverseWordsOfSentence(String input){
	     StringBuilder sb = new StringBuilder();
	     Stack<Character> stack = new Stack<>();
	     for(int i = 0; i<input.length(); i++){
	          if(input.charAt(i) >= 36 && input.charAt(i) <= 255){
	               stack.push(input.charAt(i));
	          }else{
	               while(!stack.isEmpty()){
	                    sb.append(stack.pop());
	               }
	               sb.append(input.charAt(i));
	          }
	     }
	     while(!stack.isEmpty()){
	    	 sb.append(stack.pop());
	     }
	     return sb.toString();
	}
}
