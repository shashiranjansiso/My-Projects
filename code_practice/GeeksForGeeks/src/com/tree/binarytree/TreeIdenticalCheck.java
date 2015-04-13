package com.tree.binarytree;

public class TreeIdenticalCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = BinaryTree.newNode(1);
		TreeNode root2 = BinaryTree.newNode(1);
	    root1.left = BinaryTree.newNode(2);
	    root1.right = BinaryTree.newNode(3);
	    root1.left.left  = BinaryTree.newNode(4);
	    root1.left.right = BinaryTree.newNode(5); 
	 
	    root2.left = BinaryTree.newNode(2);
	    root2.right = BinaryTree.newNode(3);
	    root2.left.left = BinaryTree.newNode(4);
	    root2.left.right = BinaryTree.newNode(5);
	    System.out.println(isIdentical(root1, root2));
	}
	
	public static boolean isIdentical(TreeNode r1, TreeNode r2)
	{
		if(r1 == null && r2 == null)
			return true;
		if((r1 == null && r2 != null) 
				|| (r1 != null && r2 == null))
				return false;
		if(r1.data != r2.data)
			return false;
		else return isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
	}

}
