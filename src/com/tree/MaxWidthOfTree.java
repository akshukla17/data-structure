package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfTree {
	public static void main(String[] args) {
		FindMaxHeight tree = new FindMaxHeight();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(8);
		tree.root.right.right.left = new Node(6);
		tree.root.right.right.right = new Node(7);
		/*
					  1  
			         / \  
			     	2   3  
			      / \     \  
			     4   5     8  
			              / \  
			              6 7  
      */
		System.out.println("Max width of tree : "+ getMaxWidth(tree.root));
	}
	
	 // /* Function to get the maximum width of a binary tree*/
    private static int getMaxWidth(Node root)
    {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(new Node(-100));
        int max =0;
        int count =0;
        while(!q.isEmpty()){
            if(q.size() == 1 && q.peek().data == -100 ){
            	if(max < count) max = count;
                break;
            }
            Node e = q.poll();
            if(e.data != -100){
                count++;
                if(e.left !=null) q.add(e.left);
                if(e.right !=null) q.add(e.right);
            }else{
                q.add(new Node(-100));
                if(max < count){
                    max =count;
                }
                count =0;
            }
        }
        return max;
    }	

}
