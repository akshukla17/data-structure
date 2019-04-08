package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTUtils {
	
	//==================Inorder DFS traversal starts===================================
	public static void inorderTraversal(BasicBinaryTree tree) {
		if(tree.root == null) System.out.println("Tree is empty");
		else {
			inorderUtil(tree.root);
		}
		System.out.println();
	}
	private static void inorderUtil(Node root) {
		if(root.left !=null) inorderUtil(root.left);
	
		System.out.print( root.data+ " ");
	
		if(root.right !=null) inorderUtil(root.right);
	}
	
	// *******TODO***********Inorder without recursion****
		public static void inorderWithoutRec(BasicBinaryTree tree) {
			if(tree.root == null) System.out.println("Tree is empty");
			Node cur = tree.root;
			Stack<Node> stack = new Stack<Node>();
		}
	
	//==================Inorder DFS traversal ends=================================
	
	//==================Preorder DFS traversal starts===================================
	public static void preorderTraversal(BasicBinaryTree tree) {
		
		if(tree.root == null) System.out.println("Tree is empty");
		else {
			preorderUtil(tree.root);
		}
		System.out.println();
	}
	private static void preorderUtil(Node root) {
		
		System.out.print(root.data+" ");
		
		if(root.left !=null) preorderUtil(root.left);
		
		if(root.right !=null) preorderUtil(root.right);
	}
	//==================Preorder DFS traversal ends=================================
	
	//==================Postorder DFS traversal starts===================================

	public static void postorderTraversal(BasicBinaryTree tree) {
		if(tree.root == null) System.out.println("Tree is empty");
		else {
			postorderUtil(tree.root);
		}
		System.out.println();
	}
	private static void postorderUtil(Node root) {
		if(root.left !=null) postorderUtil(root.left);
		
		if(root.right!=null) postorderUtil(root.right);
		
		System.out.print(root.data+" ");
	}
	
	//==================Postorder DFS traversal ends=================================
	
	//=================BFS traversal================================
	public static void bfsTraversal(BasicBinaryTree tree) {
		if(tree.root == null) System.out.println("Tree is empty");
		Queue<Node> queue = new LinkedList<>();
		queue.add(tree.root);
		while(!queue.isEmpty()) {
			Node e = queue.poll();
			System.out.print(e.data+" ");
			if(e.left !=null) queue.add(e.left);
			if(e.right!=null) queue.add(e.right);
			
		}
		System.out.println();
	}
	// ==================BFS traversal ends===================================
}












