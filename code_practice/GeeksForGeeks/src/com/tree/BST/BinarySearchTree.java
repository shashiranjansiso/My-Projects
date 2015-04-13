package com.tree.BST;


public class BinarySearchTree {
	
	TreeNode root = null;
	
	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(int data)
	{
		root = insert(root,data);
	}
	
	private TreeNode insert(TreeNode root,int data)
	{
		if(root == null)
		{
			TreeNode node = new TreeNode();
			node.data = data;
			node.left = null;
			node.right = null;
			root = node;
		}
		else
		{
			if(data >= (Integer)(root.data))
				root.right = insert(root.right, data);
			else
				root.left = insert(root.left, data);
		}
		return root;
	}
	
	public boolean delete(int value)
	{
		boolean result;
		if(root == null)
			return false;
		else if((Integer)root.data == value)
		{
			TreeNode node = new TreeNode();
			node.left = root;
			node.right = null;
			result = deleteFromParent(node, value);
		}
		else
		{
			result = deleteFromParent(root, value);
		}
		return result;
	}
	
	private boolean deleteFromParent(TreeNode parent, int value)
	{
		if((parent.left != null) && (Integer)parent.left.data == value)
		{
			//both childs null
			if(parent.left.left == null && parent.left.right == null)
			{
				parent.left = null;
			}
			//only one child right one
			else if(parent.left.left == null && parent.left.right != null)
			{
				parent.left = parent.left.right;
			}
			//only one child left child
			else if(parent.left.left != null && parent.left.right == null)
			{
				parent.left = parent.left.left;
			}
			else
			{
				parent.left.data = findMin(parent.left.right);
				deleteFromParent(parent.left, (Integer)parent.left.data);
			}
			return true;
		}
		else if((parent.right != null) && (Integer)parent.right.data == value)
		{
			//both childs null
			if(parent.right.left == null && parent.right.right == null)
			{
				parent.right = null;
			}
			//only one child right one
			else if(parent.right.left == null && parent.right.right != null)
			{
				parent.right = parent.right.right;
			}
			//only one child left child
			else if(parent.right.left != null && parent.right.right == null)
			{
				parent.right = parent.right.left;
			}
			else
			{
				parent.right.data = findMin(parent.right.right);
				deleteFromParent(parent.right, value);
			}
			return true;
		}
		else
		{
			if(value >= (Integer) parent.data)
			{
				deleteFromParent(parent.right, value);
			}
			else
				deleteFromParent(parent.left, value);
		}
		return false;
	}
	
	public int findMin(TreeNode node)
	{
		while(node.left != null)
			node = node.left;
		return (Integer) node.data;
	}
	
	public void inorderTraversal(TreeNode root)
	{
		if(root == null)
			return;
		else
		{
			inorderTraversal(root.left);
			System.out.println(root.data);
			inorderTraversal(root.right);
		}
	}
	
	public void preTraversal(TreeNode root)
	{
		if(root == null)
			return;
		else
		{
			System.out.println(root.data);
			inorderTraversal(root.left);
			inorderTraversal(root.right);
		}
	}
	
	public TreeNode getRoot()
	{
		return root;
	}
	
	
}
