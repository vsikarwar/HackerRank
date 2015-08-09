package subsequence_weighting;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
	public static void main(String[] args){
		readInput();
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		int cases = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			int size = Integer.valueOf(in.nextLine().trim());
			long[] values = new long[size];
			long[] weights = new long[size];
			String[] valuesStr = in.nextLine().trim().split(" ");
			String[] weightsStr = in.nextLine().trim().split(" ");
			
			for(int j = 0; j<valuesStr.length; j++){
				values[j] = Long.valueOf(valuesStr[j]);
			}
			
			for(int j = 0; j<weightsStr.length; j++){
				weights[j] = Long.valueOf(weightsStr[j]);
			}
			
			process(values, weights);
		}
	}
	
	public static void process(long[] a, long[] b){
		long max = 0;
		long maxId = 0;
		long temp = 0;
		Map<Long, Node> map = new HashMap<>();
		Node parent = new Node(a[0], b[0]);
		for(int i = 1; i<a.length; i++){
			if(map.get(a[i]) == null){
				Node n = new Node(a[i], b[i]);
				insert(parent, n);
				balance(parent, n);
				map.put(a[i], n);
				
				if(maxId < a[i]){
					n.data = max + b[i];
				}
				
				Node pre = getPre(n);
				if(pre != null){
					n.data = pre.data + b[i];
				}
				temp = n.data;
			}else{
				Node n = map.get(a[i]);
				Node pre = getPre(n);
				if(pre != null){
					n.data = max(pre.data + b[i], n.data);
				}else{
					n.data = max(n.data, b[i]);
				}
				temp = n.data;
			}
			if(temp > max){
				max = temp;
				maxId = a[i];
			}
		}
		
		System.out.println(max);
	}
	
	/*public static Node find(Node parent, long key){
		Node temp = parent;
		while(temp != null && temp.id != key){
			if(key < temp.id){
				temp = temp.left;
			}else{
				temp = temp.right;
			}
		}
		return temp;
	}*/
	/*public static long getMax(Node parent, Node node){
		long w = 0;
		while(node != null){
			if(node.data > w){
				w = node.data;
			}
			node = getPre(node);
		}
		return w;
	}*/
	
	public static Node getPre(Node n){
		if(n!= null && n.left != null){
			return getMaximum(n.left); 
		}else{
			Node p = n.parent;
			while(p!= null && p.left!= null && n.id == p.left.id){
				n = p;
				p = p.parent;
			}
			return p;
		}
		
	}

	private static Node getMaximum(Node n) {
		while(n.right != null){
			n = n.right;
		}
		return n;
	}
	
	public static void insert(Node parent, Node n){
		
		Node temp = parent;
		Node curr = null;
		while(temp != null){
			curr = temp;
			if(n.id < temp.id){
				temp = temp.left;
			}else{
				temp = temp.right;
			}
		}
		
		if(n.id < curr.id){
			curr.left = n;
		}else{
			curr.right = n;
		}
		n.parent = curr;
	}
	
	public static void balance(Node p, Node n){
		while(p!=null){
			if(p.left!= null && n.id == p.left.id){
				p.data = max(p.data, n.data);
			}
			p = p.parent;
		}
	}
	
	public static long max(long a, long b){
		if(a > b) return a;
		else return b;
	}
	
	static class Node{
		
		long id;
		long data;
		Node parent;
		Node left;
		Node right;
		Node pre;
		
		public Node(long id, long data){
			this.id = id;
			this.data = data;
		}
	}
}
