package com.tree;
/**
 Print all nodes that are at distance k from a leaf node
		  			1
		          /    \
		        2        3
		      /  \      /  \
		    4     5    6    7
		                 \
		                  8
		 Node of distance 1 from leaves : 2,6,3
		 Node of distance 2 from leaves : 1,3
		 
 * @author Ajay
 *
 */
public class KthNodeFromLeaf {

	public static void main(String[] args) {
		BasicBinaryTree tree = new BasicBinaryTree();
		createTree(tree);
		findKthNodeFromLeaves(tree.root,1);
	}
	
	public static void findKthNodeFromLeaves(Node root, int k){
		if(root == null) System.out.println("Tree is empty");
		
		// use to avoid repeated printing of nodes
		boolean []visited = new boolean[10]; // it should be equal to no of nodes in tree;
		
		//storing the node values in array so that we can get it with indexes
		int []path = new int [10];  // it should be equal to no of nodes in tree;
		int pathLength = 0;
		printNodes(root,k,visited,path,pathLength);
	}
	private static void printNodes(Node node,int k,boolean[]visited,int []path, int pos ){
		if(node == null) return;
		path[pos] = node.data;
		visited[pos] =false;
		pos++;
		if(node.left ==null && node.right ==null && pos -k-1 >=0 && visited[pos-k-1] == false){
			System.out.print(path[pos-k-1]+" "); // getting from indexes
			visited[pos-k-1] = true;
		}else{
			printNodes(node.left, k, visited, path, pos);
			printNodes(node.right, k, visited, path, pos);
		}
	}
	// creating tree
	private static void createTree(BasicBinaryTree tree) {
		tree.root=new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
	}
}
