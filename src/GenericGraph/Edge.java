package GenericGraph;

public class Edge<T> {
	public Node<T> left;
	public Node<T> right;
	public int weight;

	Edge(Node<T> l, Node<T> r, int w) {
		left = l;
		right = r;
		weight = w;
	}
}
