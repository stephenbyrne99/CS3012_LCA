import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {

	@Test
	void testRunning() {
		assert(true);
	}
	
	@Test
	void testConstructorNoParameters() {
		Node node1 = new Node();
		assertEquals(0, node1.getData());
		assertEquals(null,node1.getLeft(), "created node not null");
		assertEquals(null,node1.getRight(), "created node not null");
	}

}
