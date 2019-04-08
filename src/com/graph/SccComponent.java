package com.graph;
/**
 * Get Strongly Connected Component of the given graph using Kosaraju's algo
 * 
 * O( |V| + |E|)
 * @author raghav
 *
 */

public class SccComponent {
	public static void main(String[] args) {
AdjacencyList graph = new AdjacencyList(5);
		
		GraphUtils.addDirectedEdge(graph, 0, 1);
		GraphUtils.addDirectedEdge(graph, 0, 2);
		GraphUtils.addDirectedEdge(graph, 0, 4);
		GraphUtils.addDirectedEdge(graph, 1, 4);
		GraphUtils.addDirectedEdge(graph, 1, 3);
		GraphUtils.addDirectedEdge(graph, 3, 2);
		GraphUtils.addDirectedEdge(graph, 2, 4);
		
		/**
		  0 >> 1 >> 2 >>4
		  1 >> 3 >> 4
		  2 >> 4
		  3 >>2
		  
		 */
	}

}
