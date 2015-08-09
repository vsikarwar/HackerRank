package binarySearchTree;

import java.util.HashMap;
import java.util.Map;

public class BST {
	private Node head = null;
	private int size = 0;
	
	private Map<Integer, Node> nodes = new HashMap<>();
	
	public BST(){
		
	}
	
	public BST(int[] a){
		for(int i : a){
			insert(i);
		}
	}
	
	public Node getTree(){
		return head;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void inorderTreeWalk(Node n){
		if(n != null){
			inorderTreeWalk(n.getLeft());
			System.out.println(n.getId());
			inorderTreeWalk(n.getRight());
		}
	}
	
	public void preorderTreeWalk(Node n){
		if(n!=null){
			preorderTreeWalk(n.getLeft());
			preorderTreeWalk(n.getRight());
			System.out.println(n.getId());
		}
	}
	
	public void postorderTreeWalk(Node n){
		if(n != null){
			System.out.println(n.getId());
			postorderTreeWalk(n.getLeft());
			postorderTreeWalk(n.getRight());
		}
	}
	
	public Node search(Node n, int x){
		while(n != null && n.getId() != x){
			if(x < n.getId()){
				n = n.getLeft();
			}else{
				n = n.getRight();
			}
		}
		return n;
	}
	
	public Node min(Node n){
		while(n.getLeft() != null){
			n = n.getLeft();
		}
		return n;
	}
	
	public Node max(Node n){
		while(n.getRight() != null){
			n = n.getRight();
		}
		return n;
	}
	
	public void createTree(int id){
		Node node = new Node(id);
		nodes.put(id, node);
		head = node;
		size++;
	}
	
	public void insert(int id){
		if(head == null){
			createTree(id);
			return;
		}
		
		Node z = new Node(id);
		Node x = head;
		Node y = null;
		
		while(x != null){
			y = x;
			if(id < x.getId()){
				x = x.getLeft();
			}else{
				x = x.getRight();
			}
		}
		z.setParent(y);
		if(z.getId() < y.getId()){
			y.setLeft(z);
		}else{
			y.setRight(z);
		}
		size++;
	}
	
}
