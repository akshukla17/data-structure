package com.tree;

public class FindMaxHeight {
	Node root;
	public static void main(String[] args) {
		FindMaxHeight tree = new FindMaxHeight();
		tree.root =new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.left.left.left = new Node(6);
		int height= findMaxHeight(tree);
		System.out.println("Height of binary tree: "+ height);
		System.out.println("inorder traversal");
		inorderTraversal(tree);
	}
	public static void preorderTraversal(Node node){
		if(node == null) return ;
		System.out.print(node.data+ " ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	public static void inorderTraversal(FindMaxHeight tree){
		if(tree.root ==null) System.out.println("Tree is empty");
		inorder(tree.root);
	}
	private static void inorder(Node node){
		if(node ==null) return;
		 inorder(node.left);
		System.out.print(node.data+" ");
		 inorder(node.right);
	}
	
	public static int findMaxHeight(FindMaxHeight tree){
		if(tree.root == null) return 0;
		int height = getHeight(tree.root);
		return height;
	}
	public static int getHeight(Node node){
		if(node == null) return 0;
		return Math.max(getHeight(node.left), getHeight(node.right)) +1;
	}
}
