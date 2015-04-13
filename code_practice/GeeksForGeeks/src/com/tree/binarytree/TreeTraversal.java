package com.tree.binarytree;


	

public class TreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = BinaryTree.newNode(1);
		root.left             =  BinaryTree.newNode(2);
	     root.right           =  BinaryTree.newNode(3);
	     root.left.left     =  BinaryTree.newNode(4);
	     root.left.right   =  BinaryTree.newNode(5);
	     root.right.left =  BinaryTree.newNode(6);
	     root.right.right = BinaryTree.newNode(7);
	     //inorder(root);
	     System.out.println("level order traversal");
	     levelOrderTraversal(root);
	    // levelOrderZigzag(root);
	     System.out.println("reverse leveloder");
	     reverseLevelOrder(root);
	}	
	
	public static void preorder(TreeNode root)
	{
		if(root != null)
		{
			System.out.print(root.data + "  ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void inorder(TreeNode root)
	{
		if(root != null)
		{
			inorder(root.left);
			System.out.print(root.data + "  ");
			inorder(root.right);
		}
	}
	
	public static int getHeight(TreeNode r)
	{
		if(r == null)
			return 0;
		return 1 + Math.max(getHeight(r.left), getHeight(r.right));
	}
	
	public static void levelOrderTraversal(TreeNode r)
	{
		int h = getHeight(r);
		for(int i = 0; i < h; i++)
		{
			printLevel(r, i, 0, true);
			System.out.println();
		}
	}
	
	public static void reverseLevelOrder(TreeNode r)
	{
		int h = getHeight(r);
		for(int i = 0; i<h; i++)
		{
			printLevel(r, i, 0, false);
		}
	}

	public static void levelOrderZigzag(TreeNode r)
	{
		int h = getHeight(r);
		boolean ltor = false;
		for(int i = 0 ; i < h; i++)
		{
			printLevel(r, i, 0, ltor);
			System.out.println();
			ltor = !ltor;
		}
	}
	
	public static void printLevel(TreeNode r, int level, int l, boolean ltor)
	{
		if(r == null)
			return;
		if(level == l)
			System.out.print(r.data + " ");
		if(ltor)
		{
			printLevel(r.left, level, l + 1, ltor);
			printLevel(r.right, level, l + 1, ltor);
		}
		else
		{
			printLevel(r.right, level, l + 1, ltor);
			printLevel(r.left, level, l + 1, ltor);
		}
	}
}
