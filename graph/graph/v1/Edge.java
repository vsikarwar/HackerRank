package graph.v1;

public class Edge {
	private Node from;
	private Node to;
	private int cost;
	
	public Edge(Node from, Node to, int cost){
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
	public Edge(Node from, Node to){
		this(from, to, 0);
	}
	
	public Node getFrom() {
		return from;
	}
	public Node getTo() {
		return to;
	}
	public int getCost() {
		return cost;
	}
	
	public Edge getReverseEdge(){
		return new Edge(to, from, cost); 
	}

	@Override
	public String toString() {
		return "Edge [" + from.getName() + ",  " + to.getName() + ", " + cost + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cost;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		Edge other = (Edge) obj;
		if (cost != other.cost)
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}
	
}
