package com.graph;

import java.util.LinkedList;
import java.util.Stack;

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
	public void addEdge(AdjacencyList graph, int src, int dest) {
		graph.adjArray[src].add(dest);
		graph.adjArray[dest].add(src); // for undirected graph
	}
	public void dfsTraverse(AdjacencyList graph, int src) {
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
	public void bfsTraverse(AdjacencyList graph, int src) {
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
public static void main(String[] args) {
	AdjacencyList graph = new AdjacencyList(5);
	graph.addEdge(graph,0,1);
	graph.addEdge(graph,0,4);
	graph.addEdge(graph,1,4);
	graph.addEdge(graph,1,3);
	graph.addEdge(graph,1,2);
	graph.addEdge(graph,3,4);
	graph.addEdge(graph,3,2);
	
	printGraph(graph);
	System.out.println("\n*********BFS traversal ************");
	graph.bfsTraverse(graph, 2);
	
	System.out.println("\n*********DFS traversal ************");
	graph.dfsTraverse(graph, 2);
}
public static void printGraph(AdjacencyList graph) {
	for(int i =0;i<graph.vertex;i++) {
		System.out.println("adjacency list of vertex: "+i);
		for(Integer list: graph.adjArray[i]) {
			System.out.print("=> "+list);
		}
		System.out.println();
	}
}
}
