package TeamOwner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CandidateCode {
	
	
	public static void main(String[] args){
		String input = "acdabebaae";
		//String input = "baaaca";
		System.out.println(constructTree(input));
	}
	
	
	public static String constructTree(String input1)
    {
		
		Map<Character, Node> map = new HashMap<Character, Node>();
		
		for(Character ch : input1.toCharArray()){
			if(map.get(ch) == null){
				map.put(ch, new Node(ch));
			}
			map.get(ch).frequency++;
		}
		
		List<Node> lst = new ArrayList<Node>();
		
		for(Character ch : map.keySet()){
			map.get(ch).frequency = map.get(ch).frequency/input1.length();
			lst.add(map.get(ch));
		}
		
		Collections.sort(lst, new Comp());
		
		if(lst.size() == 1){
			lst.get(0).path = "0";
		}else{
			Node root = new Node();
			root.left = lst.get(lst.size() - 2);
			root.right = lst.get(lst.size() - 1);
			root.frequency = root.left.frequency + root.right.frequency;
			root.left.parent = root;
			root.right.parent = root;
			
			
	        for(int i = lst.size() - 3; i>=0; i--){
	        	Node n = new Node();
	        	
	        	n.left = lst.get(i);
	        	n.right = root;
	        	n.frequency = n.left.frequency + n.right.frequency;
	        	n.left.parent = n;
	        	n.right.parent = n;
	        	root = n;
	        	
	        }
	        
	        dfs(root);
		}
        StringBuilder sb = new StringBuilder();
        for(Character ch : input1.toCharArray()){
        	sb.append(map.get(ch).path);
        }
        return sb.toString();
    }
	
	static void dfs(Node root){
		
		Stack<Node>  stack = new Stack<Node>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			Node n = stack.pop();
			
			if(n.left == null && n.right == null){
				continue;
			}
			if(n.left != null){
				n.left.path = n.path + "0";
				stack.push(n.left);
			}
			
			if(n.right != null){
				n.right.path = n.path + "1";
				stack.push(n.right);
			}
			
			
		}
		
	}
	
	static class Comp implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			
			if(o1.frequency < o2.frequency)
				return 1;
			if(o1.frequency > o2.frequency)
				return -1;
			
			if(o1.frequency == o2.frequency){
				if(o1.ch < o2.ch)
					return -1;
				if(o1.ch > o2.ch)
					return 1;
			}
			return 0;
		}
		
	}
	
	static class Node{
		char ch;
		double frequency;
		Node left;
		Node right;
		Node parent;
		String path = "";
		public Node(){
			
		}
		public Node(char ch){
			this.ch = ch;
		}
		
		@Override
		public String toString() {
			return "Node [ch=" + ch + ",path = " + path + ", frequency=" + frequency + ", left="
					+ left + ", right=" + right + "]";
		}
		
		
	}
}
