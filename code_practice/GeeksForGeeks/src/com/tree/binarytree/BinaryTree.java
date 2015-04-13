package com.tree.binarytree;

public class BinaryTree {
	public TreeNode root;
	
	public static TreeNode newNode(int data)
	{
		TreeNode node = new TreeNode();
		node.data = (char) data;
		node.left = null;
		node.right = null;
		return node;
	}
	
}
