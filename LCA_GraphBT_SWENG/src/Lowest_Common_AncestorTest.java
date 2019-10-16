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
	void testLCA(){
		
		DAG test = new DAG(5);
		test.addEdge(2, 1);
		test.addEdge(1, 0);
		test.addEdge(2, 3);
		test.addEdge(3, 4);
		int expectedResult = 2;
		int actualResult = test.LCA(0, 4);
		assertEquals(expectedResult,actualResult);
		
		//test stright line
		
		//test empty with indexes out of bounds
		DAG testEmpty = new DAG(0);
		assertEquals(testEmpty.LCA(1, 2),-1); 
		
	}
	
	
	@Test
	void testBFS() {
		//test straight line
		DAG test = new DAG(5);
		test.addEdge(0, 1);
		test.addEdge(1, 2);
		test.addEdge(2, 3);
		test.addEdge(3, 4);
		
		ArrayList<Integer>expectedResult = new ArrayList<Integer>();
		expectedResult.add(0);
		expectedResult.add(1);
		expectedResult.add(2);
		expectedResult.add(3);
		expectedResult.add(4);
		assertEquals(expectedResult,test.BFS(0));
		
		//test proper graph
		DAG test2 = new DAG(5);
		test2.addEdge(2, 1);
		test2.addEdge(1, 0);
		test2.addEdge(2, 3);
		test2.addEdge(3, 4);
		
		ArrayList<Integer>expectedResult2 = new ArrayList<Integer>();
		expectedResult2.add(2);
		expectedResult2.add(1);
		expectedResult2.add(3);
		expectedResult2.add(0);
		expectedResult2.add(4);
		assertEquals(expectedResult2,test2.BFS(2));
	
	}
	
	
	//error cases
	@Test 
	void testPrintTraversalBFSNull() {
		DAG test = new DAG(3);
		test.addEdge(1, 2);   //Not connected to 0
		ArrayList<Integer>nodes =  test.BFS(0);
		assertEquals(nodes.toString(),"[0]");
	}
	
	
}
