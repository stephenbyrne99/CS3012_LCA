import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/*
 * 	Probably overkill testing these so thoroughly but doing it to revise j unit tests before writing LCA tests.
 * 
 */
class NodeTest {

	@Test
	void testRunning() {
		assert(true);
	}
	
	//constr1 tests
	@Test
	void testConstructorNoParameters() {
		Node node1 = new Node(0);
		assertEquals(0, node1.getData());
		assertEquals(null,node1.getLeft(), "created node.left not null");
		assertEquals(null,node1.getRight(), "created node.right not null");
	}
	
	//constr2 tests
	
	//constr3 tests
	
	//method tests
	
	

	
}
