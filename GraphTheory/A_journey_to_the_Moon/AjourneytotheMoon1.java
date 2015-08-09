package A_journey_to_the_Moon;

import java.math.BigInteger;
import java.util.*;


/*
 * Read all the input and assign each vertix a color. 
 * and at the end you will have some sets of vertices. Each set will contain vertices of same color.
 * there may be some other vertices which do not have any color.
 * We will consider them as a independent set. A set of single vertices.
 * ie if there are n vertices have color 0 or no color then we will have n sets each set will contain single no color vertex.
 * once we have the sets then we can calculate the edges ie pair of vertices.
 * There should no edge present between vertices of same color. Like bipartite graph
 * We can calculate the result set by set
 * for first set. cal number of vertices in other sets ie total vertices - vertices present in current set.
 * ie each vertex in current set should have an each to all other remaining vertex. 
 * if N is the total number of verties and n is the number of vertices present in current set
 * then total edges from singe vertex is N-n
 * total edges from current set is (N-n)*n
 * we can cal this for all the sets and then add up the resutl.
 * There we are counting each edge twice once from A set to Set B and again set B to set A
 * there fore divide the result by 2 at the end. 
 * */
public class AjourneytotheMoon1 {
	static List<Integer> nodes = new ArrayList<>();
	static Map<Integer, List<Integer>> map = new HashMap<>();
	
	public static void main(String[] args){
		readInput();
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		String[] line1 = in.nextLine().trim().split(" ");
		long vertices = Long.valueOf(line1[0]);
		long edges = Long.valueOf(line1[1]);
		int totalColors = 0;
		
		for(int i = 0; i<vertices; i++){
			nodes.add(0);
		}
		
		for(int i = 0; i<edges; i++){
			String[] line = in.nextLine().trim().split(" ");
			int v1 = Integer.valueOf(line[0]);
			int v2 = Integer.valueOf(line[1]);
			
			//first time
			if(nodes.get(v1) == 0 && nodes.get(v2) == 0){
				totalColors = totalColors + 1;
				map.put(totalColors, new ArrayList<Integer>());
				map.get(totalColors).add(v1);
				map.get(totalColors).add(v2);
				nodes.set(v1, totalColors);
				nodes.set(v2, totalColors);
			}else if(nodes.get(v1) != 0 && nodes.get(v2) != 0 && !nodes.get(v1).equals(nodes.get(v2))){
				int color = nodes.get(v2);
				int color2 = nodes.get(v1);
				List<Integer> v2Nodes = new ArrayList<>(map.get(color));
				//System.out.println("v1 : " + v1 + " v2 " + v2);
				for(Integer n : v2Nodes){
					map.get(nodes.get(v1)).add(n);
					nodes.set(n, nodes.get(v1));
				}
				map.remove(color);
			}else if(nodes.get(v1) != 0 && nodes.get(v2) == 0){
				nodes.set(v2, nodes.get(v1));
				map.get(nodes.get(v1)).add(v2);
			}else if(nodes.get(v2)!=0 && nodes.get(v1) == 0){
				nodes.set(v1, nodes.get(v2));
				map.get(nodes.get(v2)).add(v1);
			}
		}
		process();
	}
	
	public static void process(){
		BigInteger totalEdges = BigInteger.valueOf(0);
		BigInteger totalSize = BigInteger.valueOf(nodes.size());
		for(Integer i : map.keySet()){
			List<Integer> n = map.get(i);
			BigInteger size = BigInteger.valueOf(map.get(i).size());
			totalEdges = totalEdges.add((totalSize.subtract(size)).multiply(size));
		}
		
		for(int i = 0; i<nodes.size(); i++){
			if(nodes.get(i) == 0){
				totalEdges = totalEdges.add((totalSize.subtract(BigInteger.valueOf(1))));
			}
		}
		
		System.out.println((totalEdges.divide(BigInteger.valueOf(2)).toString()));
	}
}
