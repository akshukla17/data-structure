package com.graph;

import java.util.LinkedList;

/**
 * Mother vertex are those vertex from which we can traverse entire graph edges.
 * @author Ajay
 *
 */
public class MotherVertex {
	int vertex;
	LinkedList<Integer> adjArray[];
	
	public MotherVertex(int v) {
		this.vertex =v;
		adjArray = new LinkedList[v];
	
		for(int i=0;i<vertex;i++) {
			adjArray[i]= new LinkedList<>();
		}
	}
	
	public static int findMotherVertex(AdjacencyList graph) {
		boolean traversed[] = new boolean[graph.vertex];
		int count=0;
		for(int i=0;i<graph.vertex;i++) {
			traversed= dfsTraverse(graph,i, traversed);
			for(int j=0;j< traversed.length;j++) {
				if(traversed[j]) {
					count++;
				}
			}
			if(count == graph.vertex) {
				return i;
			}else {
				count =0;
				traversed = new boolean[graph.vertex];
			}
		}
		return -1;
	}
	
	public static boolean[]  dfsTraverse(AdjacencyList graph, int src, boolean traversed[]) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		traversed[src]=true;
		while(!queue.isEmpty()) {
			int e =queue.pop();
			for(Integer list : graph.adjArray[e]) {
				if(!traversed[list]) {
					queue.add(list);
//					traversed[list]= true;
					dfsTraverse(graph,list, traversed);
				}
			}
		}
		return traversed;
	}

	public static void main(String[] args) {
		AdjacencyList graph = new AdjacencyList(7);
		
		GraphUtils.addDirectedEdge(graph, 0, 1);
		GraphUtils.addDirectedEdge(graph, 0, 2);
		GraphUtils.addDirectedEdge(graph, 1,3);
		GraphUtils.addDirectedEdge(graph, 4, 1);
		GraphUtils.addDirectedEdge(graph, 5, 2);
		GraphUtils.addDirectedEdge(graph, 5, 6);
		GraphUtils.addDirectedEdge(graph, 6, 0);
		GraphUtils.addDirectedEdge(graph, 6, 4);
		
		/* Directed graph
		 	0 >> 1 >> 2
		 	1 >> 3
		 	2 >>
		 	3 >>
		 	4 >> 1
		 	5 >> 2 >> 6
		 	6 >> 0 >> 4
		 
		 */
		System.out.println("*******Directed graph********");
		GraphUtils.printGraph(graph);
		
		System.out.println("********Mother vertex*********");
		int motherVertex =findMotherVertex(graph);   // complexity: O(V *  (|V| +|E|))
		//using kosharaju algo, it become  O( (|V| +|E|)) only 
		System.out.println(motherVertex);
	}
}
