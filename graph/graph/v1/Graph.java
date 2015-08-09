package graph.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
	
	private String name;
	private Node rootNode;
	private Set<Edge> edges;
	Map<String, Node> nodes;
	
	public Graph(String name){
		this.name = name;
		this.edges = new HashSet<>();
		this.nodes = new HashMap<>();
	}
	
	public Graph(){
		this(null);
	}
	
	public boolean contains(String name){
		if(nodes.get(name) == null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean contains(Node node){
		return contains(node.getName());
	}
	
	public int size(){
		return nodes.size();
	}
	
	public int totalEdges(){
		return edges.size();
	}
	
	public void addNode(String name){
		if(!contains(name)){
			nodes.put(name, new Node(name));
		}
	}
	
	public void addNode(Node node){
		if(!contains(node)){
			nodes.put(node.getName(), node);
		}
	}
	
	public void removeNode(String name){
		Node node = nodes.get(name);
		if(node != null){
			for(Edge edge : node.getOutgoingEdges()){
				Node toNode = edge.getTo();
				toNode.removeEdge(edge);
				edges.remove(edge);
			}
			for(Edge edge : node.getIncomingEdges()){
				Node from = edge.getFrom();
				from.removeEdge(edge);
				edges.remove(edge);
			}
			nodes.remove(name);
		}
	}
	
	public void removeNode(Node node){
		removeNode(node.getName());
	}
	
	public Node getNode(String name){
		return nodes.get(name);
	}
	
	public List<Node> getNodes(){
		List<Node> tempNodes = new ArrayList<>();
		for(Node node : nodes.values()){
			tempNodes.add(node);
		}
		return tempNodes;
	}
	
	public Set<String> getNodesName(){
		return (Set<String>) nodes.keySet();
	}
	
	public void addEdge(Node from, Node to, int cost){
		if(!contains(from)){
			addNode(from);
		}
		if(!contains(to)){
			addNode(to);
		}
		if(!contains(from, to, cost)){
			Edge edge = new Edge(from, to, cost);
			edges.add(edge);
			from.addEdge(edge);
			to.addEdge(edge);
		}
	}
	
	public void addEdge(String from, String to, int cost){
		if(!contains(from)) addNode(from);
		if(!contains(to)) addNode(to);
		addEdge(nodes.get(from), nodes.get(to), cost);
	}
	
	public void addEdge(String from, String to){
		addEdge(from, to, 0);
	}
	
	public void addEdge(Node from, Node to){
		addEdge(from, to, 0);
	}
	
	public List<Edge> getEdges(){
		List<Edge> tempEdges = new ArrayList<>(edges);
		return tempEdges;
	}
	
	public Edge getEdge(String from, String to, int cost){
		if(!contains(from) || !contains(to)){
			return null;
		}
		for(Edge e : edges){
			if(e.getFrom().getName().equals(from) && 
					e.getTo().getName().equals(to) &&
					e.getCost() == cost){
				return e;
			}
		}
		return null;
	}
	
	public void removeEdge(Node from, Node to, int cost){
		removeEdge(from.getName(), to.getName(), cost);
	}
	
	public void removeEdge(Edge edge){
		removeEdge(edge.getFrom().getName(), edge.getTo().getName(), edge.getCost());
	}
	
	public void removeEdge(String from, String to, int cost){
		Edge edge = getEdge(from, to, cost);
		if(edge != null){
			nodes.get(from).removeEdge(edge);
			nodes.get(to).removeEdge(edge);
			edges.remove(edge);
		}
	}
	
	public boolean contains(Node from, Node to){
		return contains(from.getName(), to.getName());
	}
	
	public boolean contains(String from, String to){
		if(!contains(from) || !contains(to)){
			return false;
		}
		for(Edge e : edges){
			if((e.getFrom().getName().equals(from) && 
					e.getTo().getName().equals(to))){
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(Edge edge){
		return contains(edge.getFrom(), edge.getTo(), edge.getCost());
	}
	
	public boolean contains(Node from, Node to, int cost){
		return contains(from.getName(), to.getName(), cost);
	}
	
	public boolean contains(String from, String to, int cost){
		if(!contains(from) || !contains(to)){
			return false;
		}
		for(Edge e : edges){
			if((e.getFrom().getName().equals(from) && 
					e.getTo().getName().equals(to)) &&
					e.getCost() == cost){
				return true;
			}
		}
		return false;
	}
	
	public List<Node> getAdjList(Node node){
		List<Node> temp = new ArrayList<>();
		for(Edge e : node.getOutgoingEdges()){
			temp.add(e.getTo());
		}
		return temp;
	}
	
	public int getDegree(Node node){
		return node.getIncomingEdges().size() + node.getOutgoingEdges().size();
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nEdges : \n");
		for(Edge e : edges){
			sb.append(e + "\n");
		}
		sb.append("Nodes : \n");
		for(String name : nodes.keySet()){
			sb.append("\n" + name + " = " + nodes.get(name));
		}
		return "Graph [name=" + name + ", rootNode=" + rootNode + sb.toString() + "]";
	}

	//subgraph
	//nodes with self loop
	//self loop edges
	//number of self loop
	//number of edges between two node
	//add node connected to all other nodes
	
	
}
