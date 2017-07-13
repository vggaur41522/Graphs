package GenericGraph;

import java.util.LinkedList;

public class Node<T> {
	private int id;
	private T data;
	private LinkedList<Node<T>> adjList = new LinkedList<>();

	Node(int id) {
		this.id = id;
		this.data = data;
	}

	public int getId() {
		return this.id;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T d) {
		this.data = d;
	}

	public void addAdjacentNode(Node<T> adjNode) {
		adjList.add(adjNode);
	}

	public LinkedList<Node<T>> getAdjNodes() {
		return adjList;
	}

	public String toString() {
		if (this.data != null)
			return data.toString();
		else
			return String.valueOf(id);
	}
}