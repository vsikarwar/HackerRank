import java.util.*;

/*
6
2 0
0 2
0 1
2 1
0 3
1 3
2 3
 * */

public class printallpath {
	static Map<Integer, Node> nodes = new HashMap<>();
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int edges = Integer.valueOf( in.nextLine().trim());
		for(int i = 0; i<edges; i++){
			String[] line = in.nextLine().trim().split(" ");
			
			if(nodes.get(Integer.valueOf(line[0])) == null){
				nodes.put(Integer.valueOf(line[0]) , new Node(Integer.valueOf(line[0])));
			}
			
			if(nodes.get(Integer.valueOf(line[1])) == null){
				nodes.put(Integer.valueOf(line[1]) , new Node(Integer.valueOf(line[1])));
			}
			
			nodes.get(Integer.valueOf(line[0])).childs.add(nodes.get(Integer.valueOf(line[1])));
			
		}
		String[] line = in.nextLine().trim().split(" ");
		printAllPaths(nodes.get(Integer.valueOf(line[0])), nodes.get(Integer.valueOf(line[1])));
	}
	
	public static void printAllPaths(Node source, Node destination){
		Stack<Node> stack = new Stack<Node>();
		stack.push(source);
		
		while(!stack.isEmpty()){
			Node n = stack.pop();
			
			if(n.id == destination.id){
				printPath(n);
				continue;
			}
			
			List<Node> childs = n.childs;
			for(int i = 0; i<childs.size(); i++){
				if(!pathContains(n, childs.get(i))){
					childs.get(i).parent = n;
					stack.push(childs.get(i));
				}
			}
		}
	}
	
	public static void printPath(Node n){
		Node x = n;
		System.out.println(" ");
		while(x != null){
			System.out.print(x.id + " <-- ");
			x = x.parent;
		}
	}
	
	public static boolean pathContains(Node n, Node y){
		Node x = n;
		while(x != null){
			if(x.id == y.id){
				return true;
			}
			x = x.parent;
		}
		return false;
	}
	
	static class Node{
		int id;
		List<Node> childs;
		Node parent;
		int color = 0;
		public Node(int id){
			this.id = id;
			childs = new ArrayList<>();
		}
	}
	
}
