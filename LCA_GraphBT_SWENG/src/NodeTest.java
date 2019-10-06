import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


/*
 * 	
 * 
 */
class NodeTest {

	@Test
	void testRunning() {
		assert(true);
	}
	
	//Method tests
	@Test 
	void testGetNodesWhenNoNodesExist(){
		Node one = new Node(1);
		assertEquals(one.getNextNodes(), new ArrayList<Node>());
	}
	
	@Test
	void testGetNextNodesGetNodeAtIndex() {
		Node one = new Node(1);
		Node two = new Node(2);
		one.getNextNodes().add(two);
		assertEquals(one.getNextNodesGetNodeAtIndex(0),two);
	}
	
	@Test
	void testGetNextNodesGetNodeAtIndexOutOfBounds() {
		Node one = new Node(1);
		Node two = new Node(2);
		one.getNextNodes().add(two);
		assertEquals(one.getNextNodesGetNodeAtIndex(1),null);
	}
	
	
	

	
}
