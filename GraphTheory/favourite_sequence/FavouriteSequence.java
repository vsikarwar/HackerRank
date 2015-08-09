package favourite_sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class FavouriteSequence {
	
	static Map<Integer, Node> nodes = new HashMap<>();

	public static void main(String[] args){
		readInput();
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i<n ; i++){
			int k = Integer.valueOf(in.nextLine().trim());
			String[] str = in.nextLine().trim().split(" ");
			
			if(nodes.get(Integer.valueOf(str[0])) == null){
				nodes.put(Integer.valueOf(str[0]), new Node(Integer.valueOf(str[0])));
			}
			
			for(int j = 1; j<k; j++){
				if(nodes.get(Integer.valueOf(str[j])) == null){
					nodes.put(Integer.valueOf(str[j]), new Node(Integer.valueOf(str[j])));
				}
				Edge e = new Edge(Integer.valueOf(str[j-1]), Integer.valueOf(str[j]));
				nodes.get(Integer.valueOf(str[j-1])).edges.add(e);
			}
		}
		
		process();
	}
	
	public static void process(){
		List<Node> nodeList = new ArrayList<>(nodes.values());
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i<nodeList.size() ; i++){
			Stack<Node> stack = new Stack<>();
			Stack<Node> processed = new Stack<>();
			for(int j = i; j<nodeList.size() + i; j++){
				Node n = nodeList.get(j%nodeList.size());
				
				if(n.color == 0){
					n.color = 1;
					stack.push(n);
				}
				
				while(!stack.isEmpty()){
					Node node = stack.peek();
					
					if(node.color == 2){
						stack.pop();
						processed.push(node);
					}
					
					for(Edge e : node.edges){
						Node toNode = nodes.get(e.to);
						if(toNode.color == 0){
							toNode.color = 1;
							stack.push(toNode);
						}
					}
					
					node.color = 2;
				}
				
			}
			List<Integer> r = new ArrayList<>();
			while(!processed.isEmpty()){
				r.add(processed.pop().id);
			}
			result.add(r);
			reset(nodeList);
		}
		String resultStr = "";
		for(Integer integer : sort(result).get(0)){
			resultStr += integer + " ";
		}
		System.out.println(resultStr.trim());
	}
	
	public static List<List<Integer>> sort(List<List<Integer>> result){
		for(int i = 0; i<result.get(0).size(); i++){
			Map<Integer, List<List<Integer>>> map = new HashMap<>();
			int min = Integer.MAX_VALUE;
			for(List<Integer> lst : result){
				if(lst.get(i)<=min){
					min = lst.get(i);
					if(map.get(min) == null){
						map.put(min, new ArrayList<>());
					}
					map.get(min).add(lst);
				}
			}
			result = map.get(min);
		}
		return result;
	}
	
	public static void reset(List<Node> nodeList){
		for(Node n : nodeList){
			n.color = 0;
		}
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
		int color;
		List<Edge> edges;
		
		public Node(int id){
			this.id = id;
			edges = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "Node [id=" + id + ", data=" + data + ", color=" + color
					+ ", edges=" + edges + "]";
		}
		
	}
}
