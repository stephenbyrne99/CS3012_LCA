import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;



class Lowest_Common_AncestorTest {
	
	@Test
	void testTestRunning() {
		assert(true);
	}
	
	@Test
	void testCreateClassInstanceOfLCA() {
		Lowest_Common_Ancestor lca = new Lowest_Common_Ancestor();
		assertEquals(lca,lca);
	}
	
	@Test
	void testNullRoot() {
		Node root = null;
		Node result =  Lowest_Common_Ancestor.findLCA(root, 7, 13);
		assertEquals(null,result);
	}
	
	@Test 
	void sampleDAGTestOne() {
		Node root = generateDAG1();
		Node result = Lowest_Common_Ancestor.findLCA(root, 4, 1); //should be 9
		assertEquals(9,result.getData());
	}
	
	@Test 
	void testPrintTraversalBFSNormalCase() {
		Node root = generateDAG1();
		
	}
	
	//error cases
	@Test 
	void testPrintTraversalBFSNull() {
		
	}
	
	
//Generate Tree methods
	
	//every node points downards for simplicity
	public Node generateDAG1() {
		/*
		 * 			
		 * 		 
		 * 			6	  
		 * 		   / \	 
		 * 		 10	  9	
		 * 		|  \ / \
		 * 	    |	3	1 
		 *      |    \   \
		 *      |     7  /
		 *      |    /  / 
		 *      |   4   |
		 *      |  	    /
		 *       ---8---
		 *           
		 */
		Node six = new Node(6); //root node
		Node ten = new Node(10);
		Node nine = new Node(9);
		Node three = new Node(3);
		Node one = new Node(1);
		Node seven = new Node(7);
		Node four = new Node(4);
		Node eight = new Node(8);
		
		six.getNextNodes().add(ten);
		six.getNextNodes().add(nine);
		ten.getNextNodes().add(three);
		ten.getNextNodes().add(eight);
		nine.getNextNodes().add(one);
		nine.getNextNodes().add(three);
		three.getNextNodes().add(seven);
		seven.getNextNodes().add(four);
		one.getNextNodes().add(eight);
		
		return six;
	}
	
	
}
