package com.tree.binarytree;

public class ConstructFromInOrderAndPreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in[] = {15,30,35,40,45,50,60,70,72,75,77,80};
		int pre[] = {50,30,15,40,35,45,70,60,80,75,72,77};
		TreeNode r = construct(in, 0, in.length -1, pre);
		TreeTraversal.inorder(r);
	}
	
	public static int pre_l = 0;
	public static TreeNode construct(int in[], int in_l, int in_h, int pre[])
	{
		if(in_l > in_h)
			return null;
		TreeNode r = new TreeNode();
		r.data = (char) pre[pre_l++];
		int index = bsearch(in, in_l, in_h, r.data);
		r.left = construct(in, in_l, index -1, pre);
		r.right = construct(in, index + 1, in_h, pre);
		return r;
	}
	
	public static int bsearch(int in[], int l, int h, int num)
	{
		int mid = l + (h-l)/2;
		if(l > h)
			return -1;
		if(in[mid] == num)
			return mid;
		else if(in[mid] > num)	//search in lower half
			return bsearch(in, l, mid -1, num);
		else
			return bsearch(in, mid+1, h, num);
	}
}
