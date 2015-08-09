package splayTree;

public class SplayTree {
	
	public SplayTree(){
		
	}
	
	
	
	
	private class Node{
		String key;
		String value;
		Node left;
		Node right;
		
		public Node(String key, String value){
			this.key = key;
			this.value = value;
		}
	}

}
