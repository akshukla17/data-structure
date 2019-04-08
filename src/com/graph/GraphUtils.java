package com.graph;

import java.util.LinkedList;

public class GraphUtils {
	
	public static void printGraph(AdjacencyList graph) {
		for(int i =0;i<graph.vertex;i++) {
			System.out.println("adjacency list of vertex: "+i);
			for(Integer list: graph.adjArray[i]) {
				System.out.print("=> "+list);
			}
			System.out.println();
		}
	}
	
	public static void addDirectedEdge(AdjacencyList graph, int src, int dest) {
		graph.adjArray[src].add(dest);
	}
	
	public static void addUnDirectedEdge(AdjacencyList graph, int src, int dest) {
		graph.adjArray[src].add(dest);
		graph.adjArray[dest].add(src); 
	}
	
	public static void removeDirectedEdge( AdjacencyList graph, int src, int dest) {
		graph.adjArray[src].remove(src);
	}
	
	public static void removeUnDirectedEdge( AdjacencyList graph, int src, int dest) {
		graph.adjArray[src].remove(src);
		graph.adjArray[dest].remove(src);
	}
	
	//BFS traversal
	public static void bfsTraverse(AdjacencyList graph, int src) {
		if(src>= graph.vertex) {
			System.out.println("Given root vertex "+src+" doesn\'t in graph");
			return;
		}
		boolean []traversed = new boolean[graph.vertex];
		traversed[src]= true;
		System.out.println("root node: "+ src);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(src);

		while(!queue.isEmpty()) {
			int e =queue.pop();
			for(Integer list: graph.adjArray[e]) {
				if(!traversed[list]) {
					System.out.print(list+ ", ");
					queue.add(list);
					traversed[list] = true;
				}
			}
			
		}
	}
	
	//DFS traversal 
	public static void dfsTraverse(AdjacencyList graph, int src) {
			if(src>= graph.vertex) {
				System.out.println("Given root vertex "+src+" doesn\'t in graph");
				return;
			}
			boolean []traversed = new boolean[graph.vertex];
			traversed[src]= true;
			System.out.println("root node: "+ src);
			dfsUtil(graph,src, traversed);
			
	}
	public static void dfsUtil(AdjacencyList graph,int src, boolean traversed[]) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(src);
		while(!queue.isEmpty()) {
			int e =queue.pop();
			
			for(Integer list: graph.adjArray[e]) {
				if(!traversed[list]) {
					System.out.print(list+ ", ");
					queue.add(list);
					traversed[list] = true;
					dfsUtil(graph, list, traversed);
				}
			}
			
		}
	}
	
}
