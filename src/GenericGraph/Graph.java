package GenericGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/* Graph with Generic Types */
public class Graph<T> {
	private Map<Integer, Node<T>> allNodes;
	private List<Edge<T>> allEdges;
	private boolean isDirected;
	private int weight; // For weighted graph (Only Edges)
	private PriorityQueue<T> pq;

	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
		allEdges = new ArrayList<Edge<T>>();
		allNodes = new HashMap<>();
		pq = new PriorityQueue<T>(new Comparator<T>() {
			public int compare(T a1, T a2) {
				if (a1 instanceof DATA_TYPE && a2 instanceof DATA_TYPE) {
					return ((DATA_TYPE) a2).rating - ((DATA_TYPE) a1).rating;
				} else
					return (int) a1 - (int) a2;
			}
		});
	}

	public PriorityQueue<T> getQueue() {
		return pq;
	}

	public ArrayList<Node<T>> getAllNodes() {
		return new ArrayList<Node<T>>(allNodes.values());
	}

	public ArrayList<Edge<T>> getAllEdges() {
		return (ArrayList<Edge<T>>) allEdges;
	}

	public Node<T> getSingleNode(int id) {
		return allNodes.get(id);
	}

	public void addEdge(int id1, int id2, int w) {
		Node<T> v1 = null;
		Node<T> v2 = null;
		// Check if directed or not
		if (!allNodes.containsKey(id1)) {
			v1 = new Node<T>(id1);
			allNodes.put(id1, v1);
		} else {
			v1 = allNodes.get(id1);
		}
		if (!allNodes.containsKey(id2)) {
			v2 = new Node<T>(id2);
			allNodes.put(id2, v2);
		} else
			v2 = allNodes.get(id2);
		v1.addAdjacentNode(v2);
		if (!isDirected)
			v2.addAdjacentNode(v1);

		Edge<T> e = new Edge<T>(v1, v2, w);
		allEdges.add(e);
	}
}
