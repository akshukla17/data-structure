package com.tree.bst;

public class BinarySearchTree {
		Node root;
		public BinarySearchTree(){
			this.root =null;
		}
		public BinarySearchTree(int d){
			root = new Node(d);
		}
		public static void main(String[] args) {
			BinarySearchTree bst = new BinarySearchTree();
			int arr[] = {10,40,100,30,20,90,50};
			for(int i=0;i<arr.length;i++){
				bst.root =createBst(bst.root,arr[i]);
			}
			/*
			  			     10
			  			      \
			  			      40
			  			    / 	 \
			  			  30 	  100
			  			 /        /
			  			20       90
			  			         /
			  			        50 
			  			
			 */
			System.out.println("BST inorder >>>>  will always give sorted data");
			BSTUtils.inorderTraversal(bst);
			System.out.println("BST pre order traversal");
			BSTUtils.preorderTraversal(bst);
			System.out.println("Count the number of nodes : "+ countNodes(bst.root));
		}
		public static int countNodes(Node node){
			if(node == null) return 0;
			return (1+ countNodes(node.left) + countNodes(node.right));
		}
		public static Node createBst(Node node, int value){
			if(node == null) {
				node= new Node(value);
				return node;
			}
			if(node.data > value){
				node.left =createBst(node.left,value);
			}else{
				node.right =createBst(node.right,value);
			}
			return node;
		}
}
