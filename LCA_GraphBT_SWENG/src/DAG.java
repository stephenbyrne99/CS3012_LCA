import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {
	private ArrayList<Integer>[] adj;
	int V;
	
	public DAG(int V) {
		this.V=V;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		
		for (int v = 0; v < V; v++)
		{
			adj[v] = new ArrayList<Integer>();
			
		}
	}
	
	public boolean addEdge(int v, int w) {
		if(validVertex(v) && validVertex(w)) {
			adj[v].add(w);
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
	
	//BFS Algorithim
	public ArrayList<Integer> BFS(int s) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll(); //gets head
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
}
