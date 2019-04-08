package com.tree;

public class BasicBinaryTree {
	Node root;
	public BasicBinaryTree(int d) {
		this.root = new Node(d);
	}
	public BasicBinaryTree() {
		this.root=null;
	}
	public static void main(String []args) {
		BasicBinaryTree tree= new BasicBinaryTree();
		// IMG - BasicBinaryTree.jpg
		tree.root= new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.left.right = new Node (5);
		
		tree.root.right.right= new Node(6);
		System.out.println("Inorder traversal");
		BTUtils.inorderTraversal(tree);
		System.out.println("Preorder traversal");
		BTUtils.preorderTraversal(tree);
		System.out.println("Postorder traversal");
		BTUtils.postorderTraversal(tree);
		System.out.println("Breadth first traversal");
		BTUtils.bfsTraversal(tree);
		
	}
}
