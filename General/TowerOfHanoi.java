import java.util.Stack;


public class TowerOfHanoi {
	public static void main(String[] args){
		Stack<Integer> a = new Stack<>();
		Stack<Integer> b = new Stack<>();
		Stack<Integer> c = new Stack<>();
		int n = 2;
		for(int i = n; i>0; i--){
			a.push(i);
		}
		System.out.println("source : " + a + " destination : " + c);
		moveDisk(n, a, c, b);
		System.out.println("source : " + a + " destination : " + c);
	}
	
	public static void moveDisk(int n, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> buffer){
		if(n > 0){
			moveDisk(n-1, source, buffer, destination);
			System.out.println("source : " + source + " destination : " + destination + " buffer : " + buffer);
			move(source, destination);
			System.out.println("source : " + source + " destination : " + destination + " buffer : " + buffer);
			moveDisk(n-1, buffer, destination, source);
		}
	}
	
	public static void move(Stack<Integer> source, Stack<Integer> destination){
		destination.push(source.pop());
	}
}
