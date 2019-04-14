package com.tree;

/**
 	Print Ancestors of a given node in Binary Tree
 		    	     1
		          /    \
		        2        3
		      /  \      /  \
		    4     5    6    7
		                 \
		                  8
    
    the given tree is following Binary Tree and key is 8, then your function should print6, 3 and 1.

 * @author Ajay
 *
 */
public class PrintAncestors {
	
	public static void main(String[] args) {
		BasicBinaryTree tree = new BasicBinaryTree();
		createTree(tree);
		ancestorsWrapper(tree.root, 8);
	}
	public static void ancestorsWrapper(Node root, int k){
		if(root == null) System.out.println("tree is empty");
		printAncestors(root, k);
	}
	private static boolean printAncestors(Node node, int k){
		
		if(node == null) return false;
		if(node.data == k ){
			return true;
		}
		
		if(printAncestors(node.left, k) || printAncestors(node.right, k)){
			System.out.print(node.data+" ");
			return true;
		}
		return false;
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
