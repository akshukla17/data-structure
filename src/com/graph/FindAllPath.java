package com.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * Find all possible path between two given vertices
 * @author raghav
 *
 */

public class FindAllPath {

	public static void main(String[] args) {
		AdjacencyList graph = new AdjacencyList(5);
		
		GraphUtils.addDirectedEdge(graph, 0, 1);
		GraphUtils.addDirectedEdge(graph, 0, 2);
		GraphUtils.addDirectedEdge(graph, 0, 4);
		GraphUtils.addDirectedEdge(graph, 1, 4);
		GraphUtils.addDirectedEdge(graph, 1, 3);
		GraphUtils.addDirectedEdge(graph, 3, 2);
		GraphUtils.addDirectedEdge(graph, 2, 4);
//		GraphUtils.addDirectedEdge(graph, 2, 1);  // failed for cyclic graph 
		/**
		  0 >> 1 >> 2 >>4
		  1 >> 3 >> 4
		  2 >> 4
		  3 >>2
		  
		 */
		System.out.println("Find all possible path from 0 and 4");
		totalNumberOfPath(graph,0,4);
		
		System.out.println("***********Topological sorting ******* ");
		topologicalSort(graph);
	}
	
	public static void topologicalSort(AdjacencyList graph) {
		boolean visited[] = new boolean[graph.vertex];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<graph.vertex;i++) {
			visited[i]= true;
//			stack.push(i);
			Iterator<Integer> itr = graph.adjArray[i].iterator();
			while(itr.hasNext()) {
				int next = itr.next();
				if(!visited[next]) {
					visited[next]=true;
					
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+", ");
		}
	}
	
	public static void totalNumberOfPath(AdjacencyList graph, int src, int dest) {
		boolean []visited = new boolean[graph.vertex];
		
		int count =0;
		count =counter(graph, src, dest, visited,count);
		System.out.println("Count: "+ count);
	}
	public static int counter(AdjacencyList graph, int src, int dest, boolean [] visited, int count) {
		if(src == dest) count++;
		else {
			Iterator<Integer> itr = graph.adjArray[src].listIterator();
			while(itr.hasNext()) {
				int next = itr.next();
				if(!visited[next]) {
					visited[next] = true;
					count = counter(graph,next, dest, visited,count);
				}
			}
		}
		Arrays.fill(visited, false);
		return count;
	}
}
