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
		
		//opposite direction
		boolean loopAdded2 = test.addEdge(1, 0);
		assertEquals(loopAdded2,true);
	}
	
	@Test
	void testAddInvalidEdge() {
		DAG test = new DAG(3);
		assertEquals(test.addEdge(0, 3),false);
		assertEquals(test.addEdge(0, 4),false);
		assertEquals(test.addEdge(4, 1),false);
		assertEquals(test.addEdge(3, 2),false);
		
		//selfloop test
		boolean loopAdded1 = test.addEdge(1, 1);
		assertEquals(false,loopAdded1);
		
		//test for non self loop cycle?
	}
	

	@Test 
	void getEdge() {
		DAG test = new DAG(3);
		assertEquals(test.E(),0);
		test.addEdge(1, 2);
		assertEquals(test.E(), 1);
	}
	
	@Test
	void getAdj() {
		DAG test = new DAG(3);
		test.addEdge(0, 1);
		test.addEdge(0, 2);
		
		ArrayList<Integer> adj = test.adj(0);
		System.out.print(adj.toString());
		
		ArrayList<Integer> expected = new  ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		assertEquals(adj.toString(),expected.toString());
	}
	
	@Test
	void testGetV() {
		DAG test = new DAG(3);
		assertEquals(test.V(),3);
	}
	
	@Test
	void testReverseDAG() {
	
		DAG test = new DAG(5);
		test.addEdge(0, 1);
		test.addEdge(1, 2);
		test.addEdge(2, 3);
		test.addEdge(3, 4);
		
		DAG revActual = test.reverse();
		
		DAG revExpected = new DAG(5);
		revExpected.addEdge(4, 3);
		revExpected.addEdge(3, 2);
		revExpected.addEdge(2, 1);
		revExpected.addEdge(1, 0);
		
		//System.out.println(revExpected.BFS(4).toString() + "/" + revActual.BFS(4).toString());
		
		assertEquals(revExpected.BFS(4).toString(),revActual.BFS(4).toString());
		
		
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
		//test straight line
		DAG test2 = new DAG(5);
		test2.addEdge(0, 1);
		test2.addEdge(1, 2);
		test2.addEdge(2, 3);
		test2.addEdge(3, 4);
		int expectedResult2 = 1;
		int actualResult2 = test2.LCA(1, 2);
		assertEquals(expectedResult2,actualResult2);

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
	
	
	//other error cases
	@Test 
	void testPrintTraversalBFSNull() {
		DAG test = new DAG(3);
		test.addEdge(1, 2);   //Not connected to 0
		ArrayList<Integer>nodes =  test.BFS(0);
		assertEquals(nodes.toString(),"[0]");
	}
	
	//BST TESTS
	
	Node head1 = generateKnownSampleTree1();
	Node head2 = generateKnownSampleTree2();
	
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
	 * 	Generates SAMPLE TREE 2 - KNOWN
	 * 
	 */
	public Node generateKnownSampleTree2() {
		/*
		 * 			4
		 * 		     \
		 * 		  	  8
		 */
		Node eight = new Node(8,null,null);
		Node four = new Node(4,null,eight);
		return four;
	}
	
	@Test
	void testNullRoot() {
		Node root = null;
		Node result =  Lowest_Common_Ancestor.findLCA(root, 7, 13);
		assertEquals(null,result);
	}
	
	
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
	 * 	Test SAMPLE TREE 2 for Error solutions - 1 : Where root is being asked for with another node
	 * 	
	 */
	@Test
	void testSolveKnownSampleTree2Test1() {

		Node root = head2;
		int expected = 4;
		int result = Lowest_Common_Ancestor.findLCA(root, 4, 8).getData();
		assertEquals(expected,result);
	}

	/*
	 * 	Test SAMPLE TREE 2 for Error solutions - 2 : Where no answer
	 * 	
	 */
	@Test
	void testSolveKnownSampleTree2Test2() {

		Node root = head2;
		assertEquals(null,Lowest_Common_Ancestor.findLCA(root, 15, 8));
	}
	
}
