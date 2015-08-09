package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trie {
	
	private Node root;
	
	public Trie(){
		root = new Node();
	}
	
	public static void main(String[] args){
		String s = "apple";
		Trie t = new Trie();
		t.insert(s.toCharArray());
		t.insert("ap".toCharArray());
		List<String> lst = t.search("apple".toCharArray());
		System.out.println(t.search("ap".toCharArray()));
		System.out.println(t.search("apl".toCharArray()));
		System.out.println(lst);
		t.print();
		
	}
	
	public List<String> search(char[] ch){
		Node n = root;
		List<String> results = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<ch.length; i++){
			n = n.c[ch[i] - 97];
			if(n == null)
				break;
			sb.append(n.ch);
			if(n.child.isEnd == true){
				results.add(sb.toString());
			}
			if(n.child == null){
				break;
			}
			n = n.child;
		}
		return results;
	}
	
	public void insert(char[] ch){
		Node n = root;
		for(int i = 0; i<ch.length; i++){
			Node node = n.c[ch[i]-97];
			if(node == null){
				node = new Node(ch[i]);
				n.c[ch[i]-97] = node;
				node.child = new Node();
			}
			n = node.child;
		}
		n.isEnd = true;
	}
	
	public void print(){
		Node n = root;
		while(n!=null){
			System.out.println(n);
			n = n.child;
		}
	}
	
	class Node{
		char ch;
		Node[] c = new Node[26];
		Node child;
		boolean isEnd = false;
		
		public Node(){
			
		}
		
		public Node(char ch){
			this.ch = ch;
		}
		@Override
		public String toString() {
			return "Node [isEnd=" + isEnd + "ch=" + ch + ", c=" + Arrays.toString(c) + ", child="
					+ child + "]";
		}

		
	}

	

}
