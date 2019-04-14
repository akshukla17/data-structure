package com.tree;
/**
 * Construct Special Binary Tree from given Inorder traversal
	Given Inorder Traversal of a Special Binary Tree in which key of every node is greater 
	than keys in left and right children, construct the Binary Tree and return root.
	
	Input: inorder[] = {1, 5, 10, 40, 30, 
                    15, 28, 20}
	Output: root of following tree
	          40
	        /   \
	       10     30
	      /         \
	     5          28
	    /          /  \
	   1         15    20

 * @author Ajay
 *
 */
public class SpcialBTConstraction {
	public static void main(String[] args) {
		FindMaxHeight tree = new FindMaxHeight();
		int []inorder = {1, 5, 10, 40, 30, 15, 28, 20};
		
		tree.root =buildTree(inorder, 0,inorder.length-1,tree.root);
		System.out.println("inorder traversal");
		FindMaxHeight.inorderTraversal(tree);
		System.out.println("\npreorder travesal");
		FindMaxHeight.preorderTraversal(tree.root);
		
	}
	private static Node buildTree(int [] inorder, int start, int end, Node node){
		int maxIndex = findIndex(inorder, start,end);
		if(maxIndex == -1) return node;
		if(node == null){
			node = new Node (inorder[maxIndex]);
		}
		if(start == end){
			return node;
		}
		node.left = buildTree(inorder,start, maxIndex-1,node.left);
		node.right = buildTree(inorder,maxIndex+1, end,node.right);
		return node;
	}
	private static int findIndex(int []in, int start, int end){
		if(start > end) return -1;
		if(start == end) return start;
		int maxIndex =start;
		for(int i=start+1;i<=end;i++){
				if(in[maxIndex] < in[i]) maxIndex=i;
		}
		return maxIndex;
	}

}
