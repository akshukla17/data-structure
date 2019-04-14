package com.tree;

public class ConstructBT {
	static int preIndex =0;
	public static void main(String[] args) {
		int [] inorder = {6,4,2,1,5,3};
		int []preorder = {1,2,4,6,3,5};
		Node root =buildTree(inorder, preorder, 0, inorder.length-1);
		FindMaxHeight tree = new FindMaxHeight();
		tree.root = root;
		FindMaxHeight.inorderTraversal(tree);
		
	}
	public static Node buildTree(int []inorder, int []preorder, int inStart,int inEnd){
		
		if(inStart > inEnd) return null;
		Node node =new Node(preorder[preIndex++]);
		
		if(inStart == inEnd) return node; // having only one element in list
		int inIndex = findIndex(inorder, inStart, inEnd, node.data);
		
		node.left = buildTree(inorder,preorder, inStart,inIndex-1);
		node.right = buildTree(inorder,preorder, inIndex+1,inEnd);
		return node;
	}
	public static int findIndex(int []in, int start, int end, int val){
		int i=start;
		for(;i<=end;i++){
			if(in[i] == val){
				return i;
			}
		}
		return i;
	}

}
