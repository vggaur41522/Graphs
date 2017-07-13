package GenericGraph;

import java.util.*;

public class GenericGraphUtil<T> {

	/*
	 * DFS Search uses recursion. This can be done using STACK instead of
	 * recursion as well
	 */
	public void dfsSearch(Graph<T> graph) {
		Set<Node<T>> visited = new HashSet<>();
		ArrayList<Node<T>> allList = graph.getAllNodes();
		for (Node<T> n : allList) {
			if (visited.contains(n))
				continue;
			else
				dfsSearchUtil(n, visited);
		}
	}

	public void dfsSearchUtil(Node<T> curr, Set<Node<T>> visited) {
		System.out.print(curr + " ");
		visited.add(curr);
		LinkedList<Node<T>> adj = curr.getAdjNodes();
		for (int i = 0; i < adj.size(); i++) {
			Node<T> nextNode = adj.get(i);
			if (!visited.contains(nextNode))
				dfsSearchUtil(nextNode, visited);
		}
	}

	/*
	 * BFS Search uses queue
	 */
	public void bfsSearch(Graph<T> graph) {
		Set<Node<T>> visited = new HashSet<>();
		ArrayList<Node<T>> allList = graph.getAllNodes();
		for (Node<T> n : allList) {
			if (visited.contains(n))
				continue;
			else
				bfsSearchFromStartNode(graph, n, visited);
		}
	}

	public void bfsSearchFromStartNode(Graph<T> graph, Node<T> n, Set<Node<T>> visited) {
		Queue<Node<T>> q = new LinkedList<>();
		q.offer(n);
		visited.add(n);
		while (!q.isEmpty()) {
			Node<T> curr = q.poll();
			System.out.print(curr + " ");

			graph.getQueue().add(curr.getData()); // Please ignore this code..
													// This is for
			// one of the question. Not a part of regular BFS

			for (Node<T> newNode : curr.getAdjNodes()) {
				if (!visited.contains(newNode)) {
					visited.add(newNode);
					q.offer(newNode);
				}
			}
		}
	}

	public void findTopChart(Graph<T> graph, String albm) {
		PriorityQueue<T> p1 = graph.getQueue();
		while (p1.size() > 0) {
			if (((DATA_TYPE) p1.element()).type.equals(albm))
				System.out.println(p1.poll());
			else
				p1.poll();
		}
	}
}