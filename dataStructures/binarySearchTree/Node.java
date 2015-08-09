package binarySearchTree;

public class Node {
	private int id;
	private Node left;
	private Node right;
	private Node parent;
	
	public Node(int id){
		this.id = id;
	}
	
	public Node(int id, Node left, Node right){
		this(id);
		this.left = left;
		this.right = right;
	}
	
	public Node(int id, Node left, Node right, Node parent){
		this(id, left, right);
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", left=" + left.id + ", right=" + right.id
				+ ", parent=" + parent.id + "]";
	}
	
}
