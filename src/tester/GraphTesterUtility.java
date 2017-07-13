package tester;

import GenericGraph.*;
import executil.*;

public class GraphTesterUtility {

	public void test1() {
		/*------------------- NON GENERIC GRAPH --------------------------------*/
		GraphNonGeneric g1 = new GraphNonGeneric(6);
		// BFS AND DFS in GraphNonGeneric
		addNodeUtil.addNodeNonGeneric_DFSTest(g1);
		g1.dfs(2);
		g1.bfs(2);
	}

	public void test2() {
		// Is Cycle in GraphNonGeneric
		GraphNonGeneric gc = new GraphNonGeneric(4);
		addNodeUtil.addNodeNonGeneric_CycleTest(gc);
		System.out.println(gc.isCyclic());
	}

	public void test3() {
		/*------------------- GENERIC GRAPH --------------------------------*/
		GenericGraphUtil<Integer> test = new GenericGraphUtil<>();
		Graph<Integer> genG1 = addNodeUtil.addNodeGeneric_DFS();
		test.dfsSearch(genG1);
		// test.bfsSearchFromStartNode(genG1,2);
	}

	public void test4() {
		System.out.println("\n------FOR CUSTOM DATA TYPE----\n");
		GenericGraphUtil<DATA_TYPE> gtCustom = new GenericGraphUtil<DATA_TYPE>();
		Graph<DATA_TYPE> g2 = addNodeUtil.addNodeGeneric_ComplexData_DFS();
		gtCustom.dfsSearch(g2);
		System.out.println("\n------FOR CUSTOM BFS----\n");
		gtCustom.bfsSearch(g2);
		System.out.println("\n------FOR TOP CHARTS----\n");
		gtCustom.findTopChart(g2, "A");

		/*----------------- CYCLE CHECK ON GENERIC ---------------------*/
		isCyclicUnDirected<Integer> cycle = new isCyclicUnDirected<Integer>();
		Graph<Integer> graph = addNodeUtil.addNodeGeneric_isCycle();
		boolean isCycle = cycle.hasCycleDFS(graph);
		System.out.println(isCycle);
		// isCycle = cycle.hasCycleUsingDisjointSets(graph);
		// System.out.print(isCycle);
	}

	public static void main(String[] args) {
		GraphTesterUtility gtu = new GraphTesterUtility();
		System.out.println("------------TEST1---------------");
		gtu.test1();
		System.out.println("\n------------TEST2---------------");
		gtu.test2();
		System.out.println("\n------------TEST3---------------");
		gtu.test3();
		System.out.println("\n------------TEST4---------------");
		gtu.test4();
		System.out.println("\n------------END!!---------------");
		
	}

}
