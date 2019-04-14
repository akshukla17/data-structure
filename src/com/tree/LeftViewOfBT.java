package com.tree;
/**
 		Print Left View of a Binary Tree
 		output: 1, 2,4,7
 		right view : 1,3,8,7
 		
                      1
		           /    \
		          2       3
		        /  \      /
		      4     5    8 
		                /
		               7
 
 * @author Ajay
 *
 */
public class LeftViewOfBT {
		static int maxLevel =0; // maintain traversed levels
		static int right=0;
		public static void main(String[] args) {
			BasicBinaryTree tree= new BasicBinaryTree();
			tree.root = BTUtils.createTree(tree.root);
			
			System.out.println("\nprint left view of the tree");
			leftView(tree);
			System.out.println("\nPrint right view of the tree");
			rightView(tree);
		}
		
		
		private static void rightView(BasicBinaryTree tree) {
			if(tree.root ==null) System.out.println("tree is empty");
			printRight(tree.root,1);
			
		}
		private static void printRight(Node node, int level){
			if(node == null) return;
			if(right < level){
				System.out.print( node.data+" ");
				right =level;
			}
			printRight(node.right,level+1);
			printRight(node.left,level+1);
		}

		public static void leftView(BasicBinaryTree tree){
			if(tree.root == null) System.out.println("Tree is empty");
			printLeftView(tree.root,1);
		}
		private static void printLeftView(Node node, int level){
			if(node == null) return;
			if(maxLevel < level){
				System.out.print(node.data +" ");
				maxLevel = level;
			}
			
			printLeftView(node.left,level+1);
			printLeftView(node.right,level+1);
		}
		
}
