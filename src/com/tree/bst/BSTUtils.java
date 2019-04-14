package com.tree.bst;


public class BSTUtils {
	
	//==================Inorder DFS traversal starts===================================
		public static void inorderTraversal(BinarySearchTree tree) {
			if(tree.root == null) System.out.println("Tree is empty");
			else {
				inorderUtil(tree.root);
			}
			System.out.println();
		}
		public static void inorderUtil(Node root) {
			if(root.left !=null) inorderUtil(root.left);
		
			System.out.print( root.data+ " ");
		
			if(root.right !=null) inorderUtil(root.right);
		}

		//==================Inorder DFS traversal ends===================================
		//==================Preorder DFS traversal starts===================================
		public static void preorderTraversal(BinarySearchTree tree) {
			
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
}
