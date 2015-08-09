package graph.v1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortUsingDFS {
	
	public static void main(String[] args){
		Graph g = new Graph();
		String graph = "uvyxv;ux;wy;wz;zz";
		String graph2 = "shirt tie jacket;undershorts pants belt jacket;socks shoes;undershorts shoes;pants shoes;shirt belt;watch";
		
		String[] paths = graph2.split(";");
		for(String path : paths){
			String[] node = path.split(" ");
			if(node.length == 1){
				g.addNode(node[0]);
			}else{
				for(int i = 1; i<node.length; i++){
					g.addEdge(node[i-1], node[i]);
				}
			}
		}
		System.out.println(g);
		
		TopologicalSortUsingDFS tg = new TopologicalSortUsingDFS();
		tg.dfs(g, null);
	}
	
	
	public void dfs(Graph g, String source){
		Stack<Node> stack = new Stack<>();
		List<Node> seen = new LinkedList<>();
		List<Node> explored = new LinkedList<>();
		List<Node> order = new ArrayList<>();
		
		if(source!=null){
			Node sourceNode = g.getNode(source);
			stack.add(sourceNode);
		}
		for(Node n : g.getNodes()){
			if(explored.contains(n)) continue;
			stack.add(n);
			while(!stack.isEmpty()){
				Node node = stack.peek();
				if(explored.contains(node)){
					stack.pop();
					continue;
				}
				
				seen.add(node); //Gray Color
				
				List<Node> neighbors = node.getNeighbors();
				List<Node> newNodes = new ArrayList<>();
				
				for(Node neighborNode : neighbors){
					if(!explored.contains(neighborNode)){
						if(seen.contains(neighborNode)){
							System.out.println("Cycle");
							throw new RuntimeException("CYCLE");
						}
						if(!seen.contains(neighborNode)){
							newNodes.add(neighborNode);
						}
					}
				}
				
				if(!newNodes.isEmpty()){
					stack.addAll(newNodes);
				}else{
					explored.add(node);
					order.add(node);
					stack.pop();
				}
			}
		}
		System.out.println("ORDER \n " + order);
		System.out.println("Seen \n " + order);
		System.out.println("REVERSE");
		for(int i = order.size()-1; i>=0; i--){
			System.out.println(order.get(i));
		}
	}

}
