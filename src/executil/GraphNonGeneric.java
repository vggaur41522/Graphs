package executil;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphNonGeneric {
	private int numOfVert; // Number of vertices
	private LinkedList<Integer>[] adj; // Adjacency list

	public GraphNonGeneric(int num) {
		numOfVert = num;
		adj = new LinkedList[numOfVert];
		for (int i = 0; i < numOfVert; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addNode(int verNode, int data) {
		adj[verNode].add(data);
	}

	/*
	 * DFS using recursion
	 */
	public void dfs(int startNode) {
		boolean[] visited = new boolean[numOfVert];
		// Uncomment following line to print only connected nodes
		// dfsUtil(startNode,visited);
		// Comment below for loop to print a connected nodes only
		for (int i = 0; i < numOfVert; i++) {
			if (visited[i] == false)
				dfsUtil(i, visited);
		}
	}

	public void dfsUtil(int currNode, boolean[] visited) {
		visited[currNode] = true;
		System.out.print(currNode + " ");
		Iterator<Integer> it = adj[currNode].listIterator();
		while (it.hasNext()) {
			int nextNode = it.next();
			if (!visited[nextNode])
				dfsUtil(nextNode, visited);
		}
	}

	/*
	 * BFS using Queue
	 */
	public void bfs(int startNode) {
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[numOfVert];

		visited[startNode] = true;
		queue.offer(startNode);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr + " ");

			for (int i = 0; i < adj[curr].size(); i++) {
				int adjNode = adj[curr].get(i);
				if (!visited[adjNode]) {
					visited[adjNode] = true;
					queue.offer(adjNode);
				}
			}
		}
	}

	// Returns true if the Graph contains a cycle, else false.
	public boolean isCyclic() {
		// Mark all the vertices as not visited and not part of
		// recursion stack
		boolean visited[] = new boolean[numOfVert];

		// Call the recursive helper function to detect cycle in
		// different DFS trees
		for (int u = 0; u < numOfVert; u++)
			if (!visited[u]) // Don't recur for u if already visited
				if (isCyclicUtil(u, visited, -1))
					return true;

		return false;
	}

	// Utility to check of Cycle exist
	boolean isCyclicUtil(int v, boolean visited[], int parent) {
		// Mark the current node as visited
		visited[v] = true;
		Integer i;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();

			// If an adjacent is not visited, then recur for that
			// adjacent
			if (!visited[i]) {
				if (isCyclicUtil(i, visited, v))
					return true;
			}
			// If an adjacent is visited and not parent of current
			// vertex, then there is a cycle.
			else if (i != parent)
				return true;
		}
		return false;
	}

}
