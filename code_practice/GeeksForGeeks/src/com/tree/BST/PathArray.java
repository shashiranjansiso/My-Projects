package com.tree.BST;


public class PathArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(2);
		bst.insert(4);
		bst.insert(3);
		bst.insert(8);
		bst.insert(9);
		//bst.inorderTraversal(bst.getRoot());
		int a[] = new int[10];
		int j = getPathArray(bst.getRoot(), 5, a, 0);
		printArray(a,j);
		}
	
	public static void printArray(int[] a, int len)
	{
		for(int i = 0; i<len; i++)
			System.out.print(a[i] + "  ");
		System.out.println();
	}
	
	public static int getPathArray(TreeNode r, int num, int a[], int i)
	{
		if(r == null)
			return -1;
		else if((Integer)r.data == num)
			return i;
		else if(num > (Integer)r.data)
		{
			int j = getPathArray(r.right, num, a, i +1);
			if(j > 0)
			{
				a[i] = 0;
				return j;
			}
			else
			{
				a[i] = -1;
				return j;
			}
			
		}
		else
		{
			int j = getPathArray(r.left, num, a, i +1);
			if(j > 0)
			{
				a[i] = 1;
			}
			else
			{
				a[i] = -1;
			}	
			return j;
		}
	}

}
