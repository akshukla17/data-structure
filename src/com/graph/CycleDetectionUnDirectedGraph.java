package com.graph;

import java.util.Iterator;

public class CycleDetectionUnDirectedGraph {

	static AdjacencyList graph = new AdjacencyList(5);
	public static void main(String []args) {
		GraphUtils.addUnDirectedEdge(graph, 0, 1);
		GraphUtils.addUnDirectedEdge(graph, 0, 2);
		GraphUtils.addUnDirectedEdge(graph, 2, 1);
		GraphUtils.addUnDirectedEdge(graph, 0, 3);
		GraphUtils.addUnDirectedEdge(graph, 3, 4);
		
		if(checkCycle()) {
			System.out.println("Cycle is found ");
		}else {
			System.out.println("No cycle exist");
		}
	}
	
	public static boolean checkCycle() {
		boolean []visited = new boolean[graph.vertex];
		for(int i=0;i<graph.vertex;i++) {
			if(!visited[i])
				if(dfsUtil(i,visited,-1))
					return true;
		}
		return false;
	}
	
	public static boolean dfsUtil(int src,boolean []visited, int parent) {
		
		visited[src] =true;
		Iterator<Integer> itr= graph.adjArray[src].iterator();
		while(itr.hasNext()) {
			int next = itr.next();
			if(!visited[next]) {
				if(dfsUtil(next,visited,src)) {
					return true;
				}
			}else if(next !=parent ) return true;
		}
		return false;
	}
}
