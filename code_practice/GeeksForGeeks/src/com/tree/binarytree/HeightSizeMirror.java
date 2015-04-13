package com.tree.binarytree;

public class HeightSizeMirror {

	public static void main(String[] args) {
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
	    //System.out.println("Height is : " + getHeight(root1));
	    //System.out.println("Size is : " + getSize(root1));
	    TreeNode t = mirror(root1);
	    TreeTraversal.inorder(t);
	}
	
	public static int getHeight(TreeNode r)
	{
		if(r == null)
			return 0;
		return 1 + Math.max(getHeight(r.left), getHeight(r.right));
	}
	
	public static int getSize(TreeNode r)
	{
		if(r == null)
			return 0;
		return 1 + getSize(r.left) + getSize(r.right);
	}
	
	public static TreeNode mirror(TreeNode r)
	{
		if(r == null)
			return null;
		TreeNode t = new TreeNode();
		t.data = r.data;
		t.left = mirror(r.right);
		t.right = mirror(r.left);
		return t;
	}

}
