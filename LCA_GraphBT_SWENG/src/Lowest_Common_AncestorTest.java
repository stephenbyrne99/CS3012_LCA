import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;



class Lowest_Common_AncestorTest {
	
	
	Node head1 = generateKnownSampleTree1();

	@Test
	void testTestRunning() {
		assert(true);
	}

	
//method tests ************************************************************************************************
/*
 * 	Tried to manually test possible solutions. 
 * 	Left/Right means how deep left or right. LCA separates the two selected nodes.
 * 	EG: Left Left <LCA> Right means down to nodes left and one on right. See visual graph drawn below at sample
 * 	test 1.
 */
	
	/*
	 * 	Test SAMPLE TREE 1 Test 1 
	 * 	Left <LCA> Right 
	 */
	@Test
	void testSolveKnownSampleTree1Test1() {
		
		Node root = head1;
		
		int expected = 4;
		int result = Lowest_Common_Ancestor.findLCA(root, 3, 8).getData();
		assertEquals(expected,result);
	}
	
	/*
	 * 	Test SAMPLE TREE 1 Test 2
	 * 	Left <LCA> Right Right
	 */
	@Test
	void testSolveKnownSampleTree1Test2() {
		
		Node root = head1;
		
		int expected = 4;
		int result = Lowest_Common_Ancestor.findLCA(root, 3, 13).getData();
		assertEquals(expected,result);
	}
	
	/*
	 * 	Test SAMPLE TREE 1 Test 3
	 * 	Right Left Right <LCA> Right Right
	 */
	@Test
	void testSolveKnownSampleTree1Test3() {
		
		Node root = head1;
		
		int expected = 8;
		int result = Lowest_Common_Ancestor.findLCA(root, 7, 13).getData();
		assertEquals(expected,result);
	}
	
	/*
	 * 	Test SAMPLE TREE Error solutions
	 * 	
	 */
	
	
	@Test
	void testSolveRandomTreeList() {
		
	}
	
	
	
//test of class methods ******************************************************************************************
	
	
//class methods **************************************************************************************************
	
	/*
	 * 	Generates SAMPLE TREE 1 - KNOWN
	 * 
	 */
	public Node generateKnownSampleTree1() {
		/*
		 * 			4
		 * 		   / \
		 * 		  3	  8
		 * 			 / \
		 * 			6	13
		 * 			 \
		 * 			  7
		 */
		Node seven = new Node(7);
		Node six = new Node(6,null,seven);
		Node thirteen = new Node(13);
		Node eight = new Node(8,six,thirteen);
		Node three = new Node(3);
		Node four = new Node(4,three,eight);
		return four;
	}
	
	/*
	 * 		Below is code to generate random trees [unfin] - not sure if will use as unsure how to verify 
	 * 		LCA is correct.
	 * 
	 */
	
	//Generates arraylist of random trees, up to the size of the ammount
	public ArrayList<Node> generateRandomTrees(int n){
		ArrayList<Node>trees = new ArrayList<>();
		
		Random gen = new Random();
		for(int i = 0; i < n; i++) {
			int randomSize = gen.nextInt(n);
			Node newTree = generateRandomTree(randomSize);
			trees.add(newTree);
		}
		
		return trees;
	}
	
	/*
	 * 	Generates random BST
	 */
	public Node generateRandomTree(int n) {
		//catch 0
		if(n==0) {
			return null;
		}
		
		int[]arr = new int[n];//marks used Numbers
		Node head = generateRandomNode(n);//generate random node
		
		int nodeCounter = 1;//counts created nodes
		
		while(nodeCounter < n) {
			Node newNode = generateRandomNode(n);
			if(arr[newNode.getData()]==1) {
				//do nothing if already has it and make new one
			}else {
				
				arr[newNode.getData()]=1;//set map to taken
				
				//put left or right in tree - BASIC INSERTION
				
				
				nodeCounter++;
			}
		}
		return head;
	}
	
	public Node generateRandomNode(int range) {
		Random gen = new Random();
		int nodeNumber = gen.nextInt(range);
		Node newNode = new Node(nodeNumber);
		return newNode;
	}
	
}
