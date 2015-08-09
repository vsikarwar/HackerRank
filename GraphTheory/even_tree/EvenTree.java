package even_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
 * calculate the no of vertices in each subtree
 * if the number is even then remove that subtree from the tree
 * */
public class EvenTree {
	
	static List<Node> nodes = new ArrayList<>();
	
	public static void main(String[] args){
		readInput();
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		String[] line1 = in.nextLine().trim().split(" ");
		int vertices = Integer.valueOf(line1[0]);
		int edges = Integer.valueOf(line1[1]);
		
		for(int i = 0; i<vertices; i++){
			nodes.add(new Node(i+1));
		}
		
		for(int i = 0; i<edges; i++){
			String[] line = in.nextLine().trim().split(" ");

			Edge e1 = new Edge(Integer.valueOf(line[0]), Integer.valueOf(line[1]));
			nodes.get(e1.from-1).edges.add(e1);
			
			Edge e2 = new Edge(Integer.valueOf(line[1]), Integer.valueOf(line[0]));
			nodes.get(e2.from-1).edges.add(e2);
		}
		processGraph();
	}
	
	public static void processGraph(){
		int evenTree = 0;
		Stack<Node> stack = new Stack<>();
		nodes.get(0).parent = null;
		nodes.get(0).color = 1;
		nodes.get(0).data = 1;
		stack.push(nodes.get(0));
		
		while(!stack.isEmpty()){
			Node node = stack.peek();
			
			if(node.color == 2){
				node = stack.pop();
				node.color = 3;
				for(Edge n : node.edges){
					Node toNode = nodes.get(n.to-1);
					if(toNode.color == 3){
						node.data = node.data + toNode.data;
					}
				}
				if(node.data%2 == 0){
					//found an even tree
					evenTree++;
				}
				continue;
			}
			
			for(int i = 0; i<node.edges.size(); i++){
				Node toNode = nodes.get(node.edges.get(i).to-1);
				if(toNode.color == 0){
					toNode.parent = node;
					toNode.color = 1;
					toNode.data = 1;
					stack.push(toNode);
				}
			}
			
			node.color = 2;
			
		}
		
		//System.out.println(nodes);
		System.out.println(evenTree-1);
	}
	
	
	static class Edge{
		int from;
		int to;
		public Edge(int from, int to){
			this.from = from;
			this.to = to;
		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + "]";
		}
		
		
	}
	
	static class Node{
		int id;
		int data;
		List<Edge> edges;
		int color;
		Node parent;
		
		public Node(int id){
			edges = new ArrayList<>();
			this.id = id;
		}

		@Override
		public String toString() {
			return "Node [id=" + id + ", data=" + data + ", edges=" + edges
					+ ", color=" + color + ", parent=" + parent + "]";
		}
		
	}
}
