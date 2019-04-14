package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print nodes at k distance from root
 		Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.
	For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
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
public class FindNodesAtKpos {
	public static void main(String[] args) {
		BasicBinaryTree tree= new BasicBinaryTree();
		tree.root =BTUtils.createTree(tree.root);
		findNodeAtKth(tree.root,2);
	}
	
	public static void findNodeAtKth(Node node, int k){
		if(node ==null){
			System.out.println("tree is empty");
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		Node fakeNode =new Node(-100);
		q.add(fakeNode);
		int count =0;
		while(!q.isEmpty()){
			if(q.size() ==1 && q.peek().data == -100){
				break;
			}else{
				Node e = q.poll();
				if(e.data != -100){
					if(k == count){
						System.out.print(e.data+" ");
					}
					if(e.left !=null) q.add(e.left);
					if(e.right !=null) q.add(e.right);
				}else{
					count++;
					q.add(fakeNode);
				}
			}
		}
		if(count == 0 && k!=0) System.out.println(k +"th height is not available in the given tree");
		
	}
}
