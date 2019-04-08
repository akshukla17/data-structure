package com.graph;

import java.util.List;

/**
 * Check cycle existed in the given directed graph or not.   IMG >>  (CheckCycleInDirectedGraph.jpg)
 * @author raghav
 *
 */
public class CheckCycleInDirectedGraph {
	static AdjacencyList graph = new AdjacencyList(4); // accessible in whole class
	
	public static void main(String[] args) {
		
		GraphUtils.addDirectedEdge(graph, 0, 1);
		GraphUtils.addDirectedEdge(graph, 0, 2);
		GraphUtils.addDirectedEdge(graph, 1, 2);
		GraphUtils.addDirectedEdge(graph, 2, 0);
		GraphUtils.addDirectedEdge(graph, 2, 3);
		GraphUtils.addDirectedEdge(graph, 3, 3);
		
		if(checkCyclic()) {
			System.out.println("The given graph constains cycle");
		}else {
			System.out.println("No cycle in the given graph");
		}
	}
	
	public static boolean checkCyclic() {
		boolean []visited = new boolean[graph.vertex];
		boolean []stack = new boolean[graph.vertex];
		for(int i=0;i<graph.vertex;i++)
			{
				if(cyclicUtil(i,visited,stack)) {
					return true;
				}
			}
		return false;
	}
	
	public static boolean cyclicUtil(int src,boolean []visited, boolean []stack) {
		
			if(stack[src]) return true;
			if(visited[src]) return false;
			visited[src]= true;
			stack[src] =true;
			List<Integer> decendents= graph.adjArray[src];
			System.out.println("src : "+ src);
			for(Integer i: decendents) {
				if(cyclicUtil(i,visited,stack)) {
					return true;
				}
			}
			stack[src] =false;
		
		return false;
	}
}
