package A_journey_to_the_Moon;

import java.util.*;

public class AjourneytotheMoon {
	static List<Node> nodes = new ArrayList<>();
	static Map<Integer, List<Node>> colorMap = new HashMap<>();
	static int totalColors = 0;
	
	public static void main(String[] args){
		readInput();
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		String[] line1 = in.nextLine().trim().split(" ");
		int vertices = Integer.valueOf(line1[0]);
		for(int i = 0; i<vertices; i++){
			nodes.add(new Node(i));
		}
		
		for(int i = 0; i<Integer.valueOf(line1[1]); i++){
			String[] line = in.nextLine().trim().split(" ");
			int v1 = Integer.valueOf(line[0]);
			int v2 = Integer.valueOf(line[1]);
			if(nodes.get(v1).color == 0 && nodes.get(v2).color == 0){
				totalColors = colorMap.keySet().size()+1;
				nodes.get(v1).color = totalColors;
				nodes.get(v2).color = totalColors;
				colorMap.put(totalColors, new ArrayList<Node>());
				colorMap.get(totalColors).add(nodes.get(v1));
				colorMap.get(totalColors).add(nodes.get(v2));
			}else if(nodes.get(v1).color != 0 && nodes.get(v2).color != 0 && nodes.get(v1).color != nodes.get(v2).color){
				int color = nodes.get(v2).color;
				List<Node> n = colorMap.get(color);
				for(Node node : n){
					node.color = nodes.get(v1).color;
					colorMap.get(nodes.get(v1).color).add(node);
				}
				colorMap.remove(color);
			}else if(nodes.get(v1).color != 0 && nodes.get(v2).color == 0){
				nodes.get(v2).color = nodes.get(v1).color;
				colorMap.get(nodes.get(v1).color).add(nodes.get(v2));
			}else if(nodes.get(v1).color == 0 && nodes.get(v2).color != 0){
				nodes.get(v1).color = nodes.get(v2).color;
				colorMap.get(nodes.get(v2).color).add(nodes.get(v1));
			}
		}
		
		for(Node n : nodes){
			if(n.color == 0){
				if(colorMap.get(0) == null){
					colorMap.put(0,  new ArrayList<Node>());
				}
				colorMap.get(0).add(n);
			}
		}
		
		process();
	}
	
	public static void process(){
		long totalEdges = 0;
		for(Integer k : colorMap.keySet()){
			List<Node> node = colorMap.get(k);
			totalEdges = totalEdges + (nodes.size() - node.size())*node.size();
		}
		
		System.out.println(totalEdges/2);
	}
	
	static class Node{
		int id;
		int color;
		public Node(int id){
			this.id = id;
		}
	}
}
