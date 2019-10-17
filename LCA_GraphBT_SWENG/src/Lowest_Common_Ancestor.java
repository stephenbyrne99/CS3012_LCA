import java.util.ArrayList;


/*	
 * 1. Choose a unit testing framework.
 * 2. Create a repository on a git service such as Github. 
 * 3. Define a set of initial unit tests that capture the basic expected behaviour. 
 * 		This will require you to create sample data and also to identify the basic API for your solution.
 * 4. Build your initial solution, testing it against your test code until it is working.
 * 5. Refine the solution, expanding your test cases to deal with awkward parameters and edge cases that 
 * 		push the limits of your solution, enhancing your solution to deal with these.
 */



public class Lowest_Common_Ancestor {
	
	private static ArrayList<Node> path1 = new ArrayList<>(); 
   	private static ArrayList<Node> path2 = new ArrayList<>(); 
	
	/*
	 * 	Method takes in a root of BST, and two values and returns the node that is the LCA
	 */
	public static Node findLCA(Node root, int v1, int v2) {	
		path1.clear(); 
        path2.clear(); 
        return findLCAInternal(root, v1, v2); 
	}
	/*
		LCA Algorithim modified from @geeksforgeeks
	*/
	private static Node findLCAInternal(Node root, int n1, int n2) { 
		  
		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) { 
            System.out.println((path1.size() > 0) ? "N1 Found" : "N1 Not Found"); 
            System.out.println((path2.size() > 0) ? "N2 Found" : "N2 Not Found"); 
            return null; 
        } 
        int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++) { 
            if (!path1.get(i).equals(path2.get(i))) 
                break; 
        } 
        return path1.get(i-1); 
    } 
      
    // Finds the path from root node to given root of the tree, Stores the 
    // path in a vector path[], returns true if path exists otherwise false 
    private static boolean findPath(Node root, int n, ArrayList<Node> path) 
    { 
        if (root == null) { 
            return false; 
        } 
        path.add(root); 
  
        if (root.getData()== n) { 
            return true; 
        } 
  
        if (root.getLeft() != null && findPath(root.getLeft(), n, path)) { 
            return true; 
        } 
  
        if (root.getRight() != null && findPath(root.getRight(), n, path)) { 
            return true; 
        } 
  
        // If not present in subtree rooted with root, remove root from 
        // path[] and return false 
        path.remove(path.size()-1); 
  
        return false; 
    } 
	
}
