import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {
	private ArrayList<Integer>[] adj;
	private int V;
	private int E;
	
	public DAG(int V) {
		this.V=V;
		this.adj = (ArrayList<Integer>[]) new ArrayList[V];
		
		for (int v = 0; v < V; v++)
		{
			adj[v] = new ArrayList<Integer>();
			
		}
	}
	
	public boolean addEdge(int v, int w) {
		if( v==w) return false;
		//ADD CHECK FOR CYCLE FIRST -> NOT SELF LOOPS(done) AND !PATH W->V?
		
		if(validVertex(v) && validVertex(w)) {
			this.adj[v].add(w);
			this.E++;
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean validVertex(int v) {
		if (v < 0 || v >= V) return false;
		else return true;
	}
	
	public int V(){
		return this.V;
	}

	public int E() {
		return this.E;
	}
	public ArrayList<Integer> adj(int v)
	{ 
		return adj[v]; 
	}
	
	//BFS Algorithm
	public ArrayList<Integer> BFS(int s) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll(); 
			result.add(s);
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

		return result;
	}
	
	//Reverses DAG
	public DAG reverse(){
        DAG rev = new DAG(this.V);
        for (int i = 0; i < this.V; i++){
            for (int j: adj(i)) {
                rev.addEdge(j, i);
            }
        }
        return rev;
    }

	public int LCA(int v, int w) {

		if (!validVertex(w)|| !validVertex(v)) {
			return -1;
		}
		boolean hasCommonAncestor = false;
		validVertex(v);
		validVertex(w);

		DAG reversed = this.reverse();
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();

		ArrayList<Integer> search1 = reversed.BFS(v);
		ArrayList<Integer> search2 = reversed.BFS(w);

		for (int i = 0; i < search1.size(); i++) {
			for (int t = 0; t < search2.size(); t++) {
				if (search1.get(i) == search2.get(t)) {
					commonAncestors.add(search1.get(i));
					hasCommonAncestor = true;
				}
			}
		}

		if (hasCommonAncestor) {
			return commonAncestors.get(0);
		} else {
			return -1;
		}
	}
}
