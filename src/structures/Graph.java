/**
 * See bottom of file for sample graphs
 */

package structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

	public class Neighbor {
		public int vnum;
		public Neighbor next;
		public Neighbor(int vnum, Neighbor nbr) {
			this.vnum = vnum;
			next = nbr;
		}
	}

	class Vertex {
		String name;
		Neighbor neighbors;
		Vertex(String name, Neighbor neighbors) {
			this.name = name;
			this.neighbors = neighbors;
		}
	}

	Vertex[] adjLists;
	
	/**
	 * Initialize graph with input from file
	 * 
	 * @param file File that contains graph input
	 * @throws FileNotFoundException If file is not found
	 */
	public Graph(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));
		boolean directed = false;
		if (sc.next().equals("directed")) {
			directed = true;
		}
		
		adjLists = new Vertex[sc.nextInt()];
		
		// read vertices
		for (int v=0; v < adjLists.length; v++) {
			adjLists[v] = new Vertex(sc.next(), null);
		}
		
		// read edges
		while (sc.hasNext()) {
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			adjLists[v1].neighbors = new Neighbor(v2, adjLists[v1].neighbors);
			
			// if undirected graph, need to add edge pointing the opposite way as well
			if (!directed) {
				adjLists[v2].neighbors = new Neighbor(v1, adjLists[v2].neighbors);
			}
		}
	}
	
	public void dfs() {
		boolean[] visited = new boolean[adjLists.length];
		for (int v=0; v < visited.length; v++) {
			visited[v] = false;
		}
		for (int v=0; v < visited.length; v++) {
			if (!visited[v]) {
				System.out.println("Starting at " + adjLists[v].name);
				dfs(v, visited);
			}
		}
	}
	
	// recursive dfs
	private void dfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println("visiting " + adjLists[v].name);
		for (Neighbor e=adjLists[v].neighbors; e != null; e=e.next) {
			if (!visited[e.vnum]) {
				System.out.println(adjLists[v].name + "--" + adjLists[e.vnum].name);
				dfs(e.vnum, visited);
			}
		}
	}
	
	int indexForName(String name) {
		for (int v=0; v < adjLists.length; v++) {
			if (adjLists[v].name.equals(name)) {
				return v;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Graph graph = new Graph(args[0]);
		graph.dfs();
	}
	
}