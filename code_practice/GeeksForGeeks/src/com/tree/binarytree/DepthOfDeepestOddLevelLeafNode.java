package com.tree.binarytree;

public class DepthOfDeepestOddLevelLeafNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = BinaryTree.newNode(1);
		root1.left = BinaryTree.newNode(2);
	    root1.right = BinaryTree.newNode(3);
	    
	    root1.left.left  = BinaryTree.newNode(4);
	    root1.left.right = null;
	    
	    
	    root1.right.left = BinaryTree.newNode(5);
	    root1.right.left.right = BinaryTree.newNode(7);
	    root1.right.left.left = null;
	    root1.right.left.right.left = BinaryTree.newNode(9);
	    root1.right.left.right.right = null;
	    
	    root1.right.right = BinaryTree.newNode(6);
	    root1.right.right.left =null;
	    root1.right.right.right =null;
	    
	    System.out.println(isAllLeafSameLevel(root1));
	}
	
	public static int max = Integer.MIN_VALUE;

	public static void traverse(TreeNode r, int h)
	{
		if(r == null)
			return;
		if(h%2 != 0 && r.right == null && r.left == null && h > max)
			max = h;
		traverse(r.right, h+1);
		traverse(r.left, h+1);
	}
	
	public static int height(TreeNode r, int h)
	{
		if(r == null)
			return h;
		return Math.max(height(r.left, h +1), height(r.right, h+1));
	}
	
	public static boolean isAllLeafSameLevel(TreeNode r)
	{
		int h = height(r, 0);
		for(int i = 0; i < h; i++)
		{
			if(!levelHasAllLeafOrAllNonLeaf(r, i, 0))
				return false;
		}
		return true;
	}
	
	public static boolean levelHasAllLeafOrAllNonLeaf(TreeNode r, int h, int c)
	{
		if(r == null)
			return true;
		if(h == c)
		{
			if(r.left == null && r.right == null) 		//leaf
				return true;
			else
				return false;
		}
		boolean l = levelHasAllLeafOrAllNonLeaf(r.left, h, c+1);
		boolean r1 = levelHasAllLeafOrAllNonLeaf(r.right, h, c+1);
		if((l && !r1) || (!l && r1))
			return false;
		return true;
	}
}
