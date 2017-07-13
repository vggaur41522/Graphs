package tester;

import executil.*;
import GenericGraph.*;

public class addNodeUtil {

	public static GraphNonGeneric addNodeNonGeneric_DFSTest(GraphNonGeneric g1) {
		g1.addNode(0, 1);
		g1.addNode(0, 2);
		g1.addNode(1, 2);
		g1.addNode(2, 0);
		g1.addNode(2, 3);
		g1.addNode(3, 3);
		g1.addNode(4, 5);
		g1.addNode(5, 5);
		return g1;
	}

	public static GraphNonGeneric addNodeNonGeneric_CycleTest(GraphNonGeneric gc) {
		gc.addNode(0, 1);
		gc.addNode(1, 2);
		gc.addNode(2, 1);
		gc.addNode(0, 3);
		return gc;
	}

	public static Graph<Integer> addNodeGeneric_DFS() {
		Graph<Integer> genG1 = new Graph<>(true);
		genG1.addEdge(0, 1, 0);
		genG1.addEdge(0, 2, 0);
		genG1.addEdge(2, 0, 0);
		genG1.addEdge(1, 2, 0);
		genG1.addEdge(2, 3, 0);
		genG1.addEdge(3, 3, 0);
		return genG1;
	}

	public static Graph<DATA_TYPE> addNodeGeneric_ComplexData_DFS() {
		Graph<DATA_TYPE> g2 = new Graph<>(true);
		// g2.addEdge(new DATA_TYPE("KK",4), new DATA_TYPE("SONU",3), 0);
		g2.addEdge(0, 1, 0);
		g2.addEdge(1, 2, 0);
		g2.addEdge(1, 3, 0);
		g2.addEdge(2, 4, 0);
		g2.addEdge(5, 5, 0);

		g2.getSingleNode(0).setData(new DATA_TYPE("A", 4));
		g2.getSingleNode(1).setData(new DATA_TYPE("B", 5));
		g2.getSingleNode(2).setData(new DATA_TYPE("A", 1));
		g2.getSingleNode(3).setData(new DATA_TYPE("E", 4));
		g2.getSingleNode(4).setData(new DATA_TYPE("A", 3));
		g2.getSingleNode(5).setData(new DATA_TYPE("A", 2));
		return g2;
	}

	public static Graph<Integer> addNodeGeneric_isCycle() {
		Graph<Integer> graph = new Graph<Integer>(false);
		graph.addEdge(0, 1, 0);
		graph.addEdge(1, 2, 0);
		graph.addEdge(0, 3, 0);
		graph.addEdge(3, 4, 0);
		graph.addEdge(4, 5, 0);
		// graph.addEdge(5, 5,0);
		return graph;
	}
}
