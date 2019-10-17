import java.util.ArrayList;

/*
 * 
 * 
 */


public class Node {
	private int data;
	private Node left;
	private Node right;
	
	//const1
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	//const2
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left=left;
		this.right = right;
	}
	

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}
/*
	public int getNextNodseSize() {
		return nextNodes.size();
	}

	
	public Node getNextNodesGetNodeAtIndex(int index) {
		if(index < nextNodes.size()) {
			return nextNodes.get(index);
		}
		return null;
	}
	
*/
	
}
