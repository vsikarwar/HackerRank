package favourite_sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/*
 * This problem is to create a sequence from some given subsequences
 * try to create a sequence which is lexicographically small than all possible sequence
 * create a graph from the given subsequences.
 * for all the nodes having parent as null put then in a min queue (that will help to maintain lexicographical order)
 * then do till the queue is empty. You will get the desire result.
 * */
public class FavouriteSequence2 {
	
	static LinkedList<Node> heap = new LinkedList<>();
	static Map<Integer, Node> map = new HashMap<>();
	static List<Node> nodes = new ArrayList<>();

	public static void main(String[] args){
		readInput();
	}
	
	public static void readInput(){
		Scanner in = new Scanner(System.in);
		int cases = Integer.valueOf(in.nextLine().trim());
		for(int i = 0; i<cases; i++){
			int k = Integer.valueOf(in.nextLine().trim());
			String[] str = in.nextLine().trim().split(" ");
			
			if(map.get(Integer.valueOf(str[0])) == null){
				Node node = new Node(Integer.valueOf(str[0]));
				map.put(Integer.valueOf(str[0]), node);
			}
			
			for(int j = 1; j<str.length; j++){
				if(map.get(Integer.valueOf(str[j])) == null){
					Node node = new Node(Integer.valueOf(str[j]));
					map.put(Integer.valueOf(str[j]), node);
				}
				Node node = map.get(Integer.valueOf(str[j]));
				node.parents.add(map.get(Integer.valueOf(str[j-1])));
				map.get(Integer.valueOf(str[j-1])).childs.add(node);
			}
		}
		
		for(Node n : map.values()){
			if(n.parents.size() == 0){
				heap.add(n);
			}
		}
		
		//System.out.println(map);
		process();
	}
	
	public static void process(){
		while(!heap.isEmpty()){
			Node node = getMin();
			
			for(Node n: node.childs){
				n.parents.remove(node);
				if(n.parents.size() == 0){
					heap.add(n);
				}
			}
			heap.remove(node);
			
			nodes.add(node);
		}
		
		StringBuilder sb = new StringBuilder();
		for(Node n : nodes){
			sb.append(n.id).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	public static Node getMin(){
		Node min = heap.get(0);
		for(Node n : heap){
			if(min.id > n.id){
				min = n;
			}
		}
		return min;
	}
	
	static class Node{
		int id;
		List<Node> parents;
		List<Node> childs;
		
		public Node(int id){
			this.id = id;
			parents = new ArrayList<>();
			childs = new ArrayList<>();
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[Id = ").append(id).append(" , parents = ");
			for(Node n : parents){
				sb.append(n.id).append( " , ");
			}
			sb.append(" childs = ");
			for(Node n : childs){
				sb.append(n.id).append(" , ");
			}
			sb.append(" ]");
			return sb.toString();
		}
	}
	
}
