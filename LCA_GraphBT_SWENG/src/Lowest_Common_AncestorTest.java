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
	void createDAG() {
		DAG test = new DAG(3);
		assertEquals(test,test);
	}
	
	@Test
	void testAddValidEdge() {
		DAG test = new DAG(3);
		assertEquals(test.addEdge(0, 1),true);
		assertEquals(test.addEdge(0, 2),true);
	}
	
	@Test
	void testAddInvalidEdge() {
		DAG test = new DAG(3);
		assertEquals(test.addEdge(0, 3),false);
		assertEquals(test.addEdge(0, 4),false);
		assertEquals(test.addEdge(4, 1),false);
		assertEquals(test.addEdge(3, 2),false);
	}

	@Test 
	void sampleDAGTestOne() {
		
	}
	
	@Test 
	void testPrintTraversalBFSNormalCase() {
		DAG test = new DAG(3);
		test.addEdge(0, 1);
		test.addEdge(1, 2);
		ArrayList<Integer>nodes =  test.BFS(0);
		assertEquals(nodes.toString(),"[0, 1, 2]");
		
	}
	
	//error cases
	@Test 
	void testPrintTraversalBFSNull() {
		DAG test = new DAG(3);
		test.addEdge(1, 2);   //Not connected to 0
		ArrayList<Integer>nodes =  test.BFS(0);
		assertEquals(nodes.toString(),"[0]");
	}
	
	
//Generate Tree methods
	public Node generateDAG1() {
	
	}
	
	
}
