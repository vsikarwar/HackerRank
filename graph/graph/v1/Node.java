package graph.v1;

import java.util.ArrayList;
import java.util.List;

public class Node{
	
	private String name;
	private Object data;
	private List<Edge> incoming;
	private List<Edge> outgoing;
	
	public Node(String name, Object data){
		this.name = name;
		this.data = data;
		incoming = new ArrayList<>();
		outgoing = new ArrayList<>();
	}
	
	public Node(String name){
		this(name, null);
	}
	
	protected void addEdge(Edge edge){
		if(!outgoing.contains(edge) && name.equals(edge.getFrom().getName())){
			outgoing.add(edge);
		}
		if(!incoming.contains(edge) && name.equals(edge.getTo().getName())){
			incoming.add(edge);
		}
	}
	
	protected void removeEdge(Edge edge){
		if(name.equals(edge.getFrom().getName())){
			outgoing.remove(edge);
		}
		if(name.equals(edge.getTo().getName())){
			incoming.remove(edge);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Object getData() {
		return data;
	}
	
	public List<Edge> getOutgoingEdges() {
		List<Edge> tempEdges = new ArrayList<>(outgoing);
		return tempEdges;
	}
	
	public List<Node> getNeighbors(){
		List<Node> tempNodes = new ArrayList<>();
		for(Edge e : outgoing){
			tempNodes.add(e.getTo());
		}
		return tempNodes;
	}
	
	public List<Edge> getIncomingEdges() {
		List<Edge> tempEdges = new ArrayList<>(incoming);
		return tempEdges;
	}

	@Override
	public String toString() {
		return "\nNode [name=" + name + ", data=" + data + ", \nincoming="
				+ incoming + ", \noutgoing=" + outgoing + "]";
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

	
	
}
