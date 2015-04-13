package com.tree.binarytree;

public class Diameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = BinaryTree.newNode(1);
		root.left             =  BinaryTree.newNode(2);
	    // root.right           =  BinaryTree.newNode(3);
	     root.left.left     =  BinaryTree.newNode(4);
	     root.left.right   =  BinaryTree.newNode(5);
	     //root.left.right.right   =  BinaryTree.newNode(5);
	     //root.right.left =  BinaryTree.newNode(6);
	     //root.right.right = BinaryTree.newNode(7);
	     diam(root);
	     System.out.println(diam);
	}
	
	public static int diam = Integer.MIN_VALUE;
	public static void diam(TreeNode r)
	{
		if(r == null)
			return;
		else
		{
			int d = height(r.right) + height(r.left) + 1;
			if(d > diam)
				diam = d;
			diam(r.right);
			diam(r.left);
		}
	}
	
	public static int height(TreeNode r)
	{
		if(r == null)
			return 0;
		else
			return 1 + Math.max(height(r.right), height(r.left));
	}
	
}
