/*
 * 
 * 
 */


public class Node {
	private int data;
	private Node left;
	private Node right;
	
	//const1
	public Node() {
		this.data = 0;
		this.left = null;
		this.right = null;
	}
	
	//const2
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	//const3
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
