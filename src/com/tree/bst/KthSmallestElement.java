package com.tree.bst;
/**
    Find k-th smallest element in BST
    k =3 >> output =10
    
    			  20
    		    /    \ 	
               8       22
              /  \ 
            4     12
                 /  \
                10   14
 
 * @author Ajay
 *
 */

//TODO

public class KthSmallestElement {
	static int count =0;
	public static void main(String[] args) {
		BinarySearchTree tree= new BinarySearchTree();
		tree.root = new Node(20);
		tree.root.left = new Node (8);
		tree.root.right = new Node(20);
		tree.root.left.left = new Node (4);
		tree.root.left.right = new Node (12);
		tree.root.left.right.left = new Node (10);
		tree.root.left.right.right = new Node (14);
		System.out.println("inorder traversal");
		BSTUtils.inorderTraversal(tree); // will print sorted data
		inorder(tree.root, 3);
		
	}
	private static void inorder(Node node, int k){
		if(node == null) System.out.println("tree is empty");
		
		findKth(node,k,count);
	}
	private static void findKth(Node node, int k, int count){
		if(node ==null) return;
		
		findKth(node.left,k,count);
		count++;
		if(k== count) {
			System.out.println(node.data);
			return;
		}
		findKth(node.right,k,count);
	}

}
