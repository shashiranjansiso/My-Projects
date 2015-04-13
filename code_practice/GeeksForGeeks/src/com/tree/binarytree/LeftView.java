package com.tree.binarytree;

public class LeftView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = BinaryTree.newNode(12);
	    root1.left = BinaryTree.newNode(10);
	    root1.right = BinaryTree.newNode(30);
	    root1.right.left  = BinaryTree.newNode(25);
	    root1.right.right = BinaryTree.newNode(40); 
	    printLeftView(root1,0);
	}

	public static int maxLevel = -1;
	
	
	public static void printLeftView(TreeNode r, int l)
	{
		if(r == null)
			return;
		if(l > maxLevel)
		{
			maxLevel = l;
			System.out.println(r.data);
		}
		printLeftView(r.left, l + 1);
		printLeftView(r.right, l + 1);
	}
	
	public static void printRightView(TreeNode r, int l)
	{
		if( r == null)
			return;
		if(l > maxLevel)
		{
			maxLevel = l;
			System.out.println(r.data);
		}
		printRightView(r.right, l+1);
		printRightView(r.left, l + 1);
		
	}
	
}
