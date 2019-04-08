package com.graph;

import java.util.LinkedList;

public class AdjacencyList {
	int vertex;
	LinkedList<Integer> adjArray[];
	
	public AdjacencyList(int v) {
		this.vertex =v;
		adjArray = new LinkedList[v];
	
		for(int i=0;i<vertex;i++) {
			adjArray[i]= new LinkedList<>();
		}
	}
	

	
public static void main(String[] args) {
	AdjacencyList graph = new AdjacencyList(5);
	GraphUtils.addUnDirectedEdge(graph, 0, 1);
	GraphUtils.addUnDirectedEdge(graph,0,4);
	GraphUtils.addUnDirectedEdge(graph,1,4);
	GraphUtils.addUnDirectedEdge(graph,1,3);
	GraphUtils.addUnDirectedEdge(graph,1,2);
	GraphUtils.addUnDirectedEdge(graph,3,4);
	GraphUtils.addUnDirectedEdge(graph,3,2);
	
	/*
	     0  >>>> 1 >>>> 4
	     1>>>> 0 >>> 4 >>> 3 >>>> 2
	     2 >>>> 1 >>>>>3
	     3 >>>> 4 >>>> 1 >>>> 2
	     4 >>>> 0 >>>> 1 >>>> 3
	*/
	
	GraphUtils.printGraph(graph);
	System.out.println("\n*********BFS traversal ************");
	GraphUtils.bfsTraverse(graph, 2);
	
	System.out.println("\n*********DFS traversal ************");
	GraphUtils.dfsTraverse(graph, 2);
	
	System.out.println("\n***********remove edge 0 >> 4 ***************");
	GraphUtils.removeUnDirectedEdge(graph,0,4);
	GraphUtils.printGraph(graph);
}

}
