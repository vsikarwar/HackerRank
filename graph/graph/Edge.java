package graph;

public class Edge<T> {
	
	private Node<T> from;
	private Node<T> to;
	private int cost;
	
	public Edge(Node<T> from, Node<T> to, int cost){
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
	public Edge(Node<T> from, Node<T> to){
		this(from, to, 0);
	}
	
	public Node<T> getFrom() {
		return from;
	}
	public void setFrom(Node<T> from) {
		this.from = from;
	}
	public Node<T> getTo() {
		return to;
	}
	public void setTo(Node<T> to) {
		this.to = to;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void reverse(){
		Node<T> temp = to;
		to = from;
		from = temp;
	}
	
	public Edge<T> getReverseEdge(){
		return new Edge<T>(to, from, cost);
	}

	@Override
	public String toString() {
		return "Edge [from=" + from.getName() + ", to=" + to.getName() + ", cost=" + cost + "]";
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
