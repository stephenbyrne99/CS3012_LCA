import java.util.ArrayList;

/*
 * 
 * 
 */


public class Node {
	private int data;
	private int count;
	private String colour;
	private ArrayList<Node>nextNodes;
	
	//const1
	public Node(int data) {
		this.data = data;
		this.count = 0;
		this.colour = "white";
		this.nextNodes = new ArrayList<Node>();
	}
	
	//const2
	public Node(int data, ArrayList<Node>nextNodes) {
		this.data = data;
		this.nextNodes = nextNodes;
		this.count = 0;
		this.colour = "white";
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public ArrayList<Node> getNextNodes() {
		return nextNodes;
	}

	public void setNextNodes(ArrayList<Node> nextNodes) {
		this.nextNodes = nextNodes;
	}

	public int getNextNodseSize() {
		return nextNodes.size();
	}

	
	public Node getNextNodesGetNodeAtIndex(int index) {
		if(index < nextNodes.size()) {
			return nextNodes.get(index);
		}
		return null;
	}
	
}
