package com.tree;


public class FindDiameter {
	static Node root;
	public FindDiameter() {
		root =null;
	}
	public FindDiameter(int d) {
		root = new Node(d);
	}
	public static void main(String []args) {
		root = new Node(1);
		
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.left.left = new Node(6);
		root.left.left.right = new Node(7);
		root.left.left.right.left = new Node(9);
		root.left.left.right.left.right = new Node(12);
		
		root.left.right = new Node(5);
		root.left.right.right = new Node(8);
		root.left.right.right.left = new Node(10);
		root.left.right.right.right = new Node(11);
		root.left.right.right.right.left = new Node(12);
		
		root.right = new Node(3);
		
		int diameter = getDia(root);
		System.out.println("Diameter of the graph : "+ diameter);
	}
	public static int getDia(Node root) {
		if(root == null) return 0;
		int heightLeft = findHeight(root.left);
		int heightRight = findHeight(root.right);
		return Math.max(heightLeft + heightRight +1, Math.max(getDia(root.left), getDia(root.right)));
	}
	public static int  findHeight(Node node) {
		if(node == null) return 0;
		return Math.max( findHeight(node.left), findHeight(node.right)) +1;
	}

}
