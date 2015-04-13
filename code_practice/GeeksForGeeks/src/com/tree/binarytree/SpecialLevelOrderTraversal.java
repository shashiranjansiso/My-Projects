package com.tree.binarytree;

public class SpecialLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = BinaryTree.newNode(1);
		root1.left = BinaryTree.newNode(2);
	    root1.right = BinaryTree.newNode(3);
	    
	    root1.left.left  = BinaryTree.newNode(4);
	    root1.left.right = BinaryTree.newNode(5); 
	    root1.right.left = BinaryTree.newNode(6);
	    root1.right.right = BinaryTree.newNode(7);
	    
	    root1.left.left.left = BinaryTree.newNode(8);
	    root1.left.left.right = BinaryTree.newNode(9);
	    root1.left.right.left = BinaryTree.newNode(10);
	    root1.left.right.right = BinaryTree.newNode(11);
	    
	    root1.right.left.left = BinaryTree.newNode(12);
	    root1.right.left.right = BinaryTree.newNode(13);
	    root1.right.right.left = BinaryTree.newNode(14);
	    root1.right.right.right = BinaryTree.newNode(15);
	    traverse(root1);
	}

	public static int height(TreeNode r, int h)
	{
		if(r == null)
			return h;
		return Math.max(height(r.left, h +1), height(r.right, h + 1));
	}
	
	public static void traverse(TreeNode r)
	{
		int h = height(r,0);
		for(int i = 0; i < h; i++)
		{
			clearArray(a);
			levelOrder(r, 0, i);
			printSpecialArray();
			System.out.println();
		}
	}
	
	public static void printSpecialArray()
	{
		if(index == 1)
			System.out.print(a[index-1]);
		for(int i = 0; i < index/2; i++)
		{
			System.out.print(a[i] + ",");
			if(index%2 != 0 && i == index/2)
			{
				//odd length array and mid
				
			}
			else
				System.out.print(a[index -1 -i] + ",");
		}
	}
	
	public static void clearArray(int a[])
	{
		for(int i = 0; i < a.length; i++)
		{
			a[i] = 0;
		}
		index = 0;
	}
	
	public static int a[] = new int[20];
	public static int index = 0;
	public static void levelOrder(TreeNode r, int c, int h)
	{
		if(c == h)
		{
			a[index++] = r.data;
			return ;
		}
		levelOrder(r.left, c + 1, h);
		levelOrder(r.right, c + 1, h);
	}
	
}
