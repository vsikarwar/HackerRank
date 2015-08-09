package graph;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	
	private List<Edge<T>> incomingEdges;
	private List<Edge<T>> outgoingEdges;
	private List<Edge<T>> edges;
	private T data;
	private String name;
	
	public Node(String name){
		this(name, null);
	}
	
	public Node(String name, T data){
		this.data = data;
		this.name = name;
	}
	
	//add Edge
	//add from Edge
	//add to edge
	//find edge
	
	public List<Node<T>> getIncomingNodes(){
		List<Node<T>> fromEdges = new ArrayList<>();
		for(Edge<T> edge : incomingEdges){
			fromEdges.add(edge.getFrom());
		}
		return fromEdges;
	}
	
	public List<Node<T>> getOutgoingNodes(){
		List<Node<T>> toEdges = new ArrayList<>();
		for(Edge<T> edge : outgoingEdges){
			toEdges.add(edge.getFrom());
		}
		return toEdges;
	}
	
	public List<String> getIncomingNodeNames(){
		List<String> fromEdges = new ArrayList<>();
		for(Edge<T> edge : incomingEdges){
			fromEdges.add(edge.getFrom().getName());
		}
		return fromEdges;
	}
	
	public List<String> getOutgoingNodeNames(){
		List<String> toEdges = new ArrayList<>();
		for(Edge<T> edge : outgoingEdges){
			toEdges.add(edge.getFrom().getName());
		}
		return toEdges;
	}
	
	public List<Edge<T>> getIncomingEdges() {
		return incomingEdges;
	}

	public List<Edge<T>> getOutgoingEdges() {
		return outgoingEdges;
	}

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Edge<T>> getEdges() {
		return edges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node {\nincomingEdges=\n" + getIncomingNodeNames() + ", \noutgoingEdges="
				+ getOutgoingNodeNames() + ", \ndata=" + data + ", \nname=" + name + "\n}";
	}
	
}
