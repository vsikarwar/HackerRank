package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
	
	Map<String, Node<T>> nodes = new HashMap<>();
	List<Edge<T>> edges = new ArrayList<>();
	Node<T> rootNode;
	private String graphName;
	
	public Graph(String name){
		this.graphName = name;
		nodes = new HashMap<>();
		edges = new ArrayList<>();
	}
	
	public boolean contains(String name){
		if(nodes.get(name) != null){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean contains(Node<T> node){
		return contains(node.getName());
	}
	
	public int nodeSize(){
		return nodes.size();
	}
	
	public int edgeSize(){
		return edges.size();
	}
	
	public Node<T> getNode(String n){
		return nodes.get(n);
	}
	
	public Set<Node<T>> getAdjList(String name){
		return getAdjList(nodes.get(name));
	}
	
	public Set<Node<T>> getAdjList(Node<T> node){
		Set<Node<T>> set = new HashSet<>();
		for(Edge<T> edge : node.getOutgoingEdges()){
			set.add(edge.getTo());
		}
		for(Edge<T> edge : node.getIncomingEdges()){
			set.add(edge.getFrom());
		}
		return set;
	}
	
	public void addAllNodes(Collection<Node<T>> ns){
		for(Node<T> n : ns){
			addNode(n);
		}
	}
	
	public void addAllNodeNames(Collection<String> names){
		for(String name : names){
			addNode(name);
		}
	}
	
	public void addNode(Node<T> node){
		String name = node.getName();
		if(nodes.get(name) == null){
			nodes.put(name, node);
		}
	}
	
	public void addNode(String name){
		addNode(name, null);
	}
	
	public void addNode(String name, T data){
		if(nodes.get(name) == null){
			Node<T> node = new Node<T>(name, data);
			nodes.put(name, node);
		}
	}
	
	public void addEdge(String from, String to){
		Node<T> fromNode = nodes.get(from);
		if(fromNode == null){
			throw new RuntimeException("Invalid from node");
		}
		Node<T> toNode = nodes.get(to);
		if(toNode == null){
			throw new RuntimeException("Invalid from node");
		}
		
		Edge<T> edge = new Edge<T>(fromNode, toNode);
		if(!edges.contains(edge)){
			edges.add(edge);
			fromNode.getOutgoingEdges().add(edge);
		}
		Edge<T> reverseEdge = edge.getReverseEdge();
		if(!edges.contains(reverseEdge)){
			toNode.getIncomingEdges().add(reverseEdge);
		}
	}
	
	public void removeNode(String name){
		Node<T> node = nodes.get(name);
		if(node == null){
			throw new RuntimeException("no node found");
		}
		//remove outgoing edges
		for(Edge<T> edge : node.getOutgoingEdges()){
			Node<T> toNode = edge.getTo();
			toNode.getIncomingEdges().remove(edge);
		}
		//remove incoming edges
		for(Edge<T> edge : node.getIncomingEdges()){
			Node<T> fromNode = edge.getFrom();
			fromNode.getOutgoingEdges().remove(edge);
		}
	}
	
}
