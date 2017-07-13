package GenericGraph;

import java.util.HashSet;
import java.util.Set;

/**
 * Date 10/11/2014
 * 
 * @author Tushar Roy
 *
 *         Given an undirected graph find cycle in this graph.
 *
 *         Solution This can be solved in many ways. Below is the code to solve
 *         it using disjoint sets and DFS.
 *
 *         Runtime and space complexity for both the techniques is O(v) where v
 *         is total number of vertices in the graph.
 */
public class isCyclicUnDirected<T> {

	// public boolean hasCycleUsingDisjointSets(Graph<T> graph){
	// DisjointSet disjointSet = new DisjointSet();
	//
	// for(Node<T> Node : graph.getAllNode()){
	// disjointSet.makeSet(Node.getId());
	// }
	//
	// for(Edge<T> edge : graph.getAllEdges()){
	// long parent1 = disjointSet.findSet(edge.getNode1().getId());
	// long parent2 = disjointSet.findSet(edge.getNode2().getId());
	// if(parent1 == parent2){
	// return true;
	// }
	// disjointSet.union(edge.getNode1().getId(), edge.getNode2().getId());
	// }
	// return false;
	// }

	public boolean hasCycleDFS(Graph<T> graph) {
		Set<Node<T>> visited = new HashSet<Node<T>>();
		for (Node<T> currNode : graph.getAllNodes()) {
			if (visited.contains(currNode)) {
				continue;
			}
			boolean flag = hasCycleDFSUtil(currNode, visited, null);
			if (flag) {
				return true;
			}
		}
		return false;
	}

	public boolean hasCycleDFSUtil(Node<T> n, Set<Node<T>> visited, Node<T> parent) {
		visited.add(n);
		for (Node<T> adj : n.getAdjNodes()) {
			if (adj.equals(parent)) { // THis condition has been added to
										// because
				continue; // it is Un Directed Graph
			}
			if (visited.contains(adj)) {
				return true;
			}
			boolean hasCycle = hasCycleDFSUtil(adj, visited, n);
			if (hasCycle) {
				return true;
			}
		}
		return false;
	}
}