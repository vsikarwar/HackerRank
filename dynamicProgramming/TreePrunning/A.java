package TreePrunning;

import java.util.*;

public class A{
	
	static List<Node> nodes = new ArrayList<>();
	static int k = 0;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String[] line1 = in.nextLine().trim().split(" ");
		int vertices = Integer.valueOf(line1[0]);
		k = Integer.valueOf(line1[1]);
		String[] line2 = in.nextLine().trim().split(" ");
		
		for(int i = 0; i<vertices; i++){
			Node n = new Node(i, Integer.valueOf(line2[i]));
			nodes.add(n);
		}
		
		for(int i = 0; i<vertices-1; i++){
			String[] line = in.nextLine().trim().split(" ");
			Node n1 = nodes.get(Integer.valueOf(line[0])-1);
			Node n2 = nodes.get(Integer.valueOf(line[1])-1);
			
			n1.child.add(n2);
			n2.child.add(n1);
		}
		process();
		System.out.println(nodes.get(0).value);
	}
	
	public static void process(){
		createTree();
		for(int i =0; i<k; i++){
			Node m = min();
			if(m != null){
				remove(m);
			}
		}
	}
	
	public static Node min(){
		Node m = nodes.get(1);
		for(int i = 1; i<nodes.size(); i++){
			if(m.value > nodes.get(i).value){
				m = nodes.get(i);
			}
		}
		return m;
	}
	
	public static void remove(Node n){
		Node x = n;
		while(x.parent != null){
			x.parent.value -= n.value;
			x = x.parent;
		}
		
		n.parent.child.remove(n);
		n.parent = null;
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(n);
		while(!queue.isEmpty()){
			Node node = queue.removeFirst();
			List<Node> child = node.child;
			for(int i = 0; i<child.size(); i++){
				queue.add(child.get(i));
			}
			nodes.remove(node);
		}
	}
	
	public static void createTree(){
		LinkedList<Node> queue = new LinkedList<>();
		Node n = nodes.get(0);
		n.color = 1;
		queue.add(n);
		
		while(!queue.isEmpty()){
			Node node = queue.removeFirst();
			
			Node x = node;
			while(x.parent != null){
				x.parent.value += node.value;
				x = x.parent;
			}
			
			List<Node> child = node.child;
			for(Node c : child){
				if(c.color == 0){
					c.parent = node;
					c.color = 1;
					c.child.remove(node);
					queue.add(c);
				}
			}
		}
	}
	
	static class Node{
		int id;
		long value;
		Node parent;
		List<Node> child;
		int color;
		public Node(int id, int data){
			this.id = id;
			this.value = data;
			child = new ArrayList<>();
		}
		@Override
		public String toString() {
			return "Node [id=" + id + ", value=" + value + ", parent=" + parent
					+ ", child=" + child + ", color=" + color + "]";
		}
		
	}
}
