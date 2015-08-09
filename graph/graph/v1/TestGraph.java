package graph.v1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TestGraph {
	public static void main(String[] args){
		Graph g = new Graph("MyGraph");
		g.addNode("A");
		g.addNode("B");
		g.addNode("C");
		g.addEdge("A", "B");
		g.addEdge("A", "C");
		g.addEdge("B", "C");
		System.out.println(g);
	}
	
	
	
}
