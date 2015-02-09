package cracking.codinginterview.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(2);
		bst.insert(4);
		bst.insert(3);
		bst.insert(8);
		bst.insert(9);
		int n = 0;
		int k = n%10;
		System.out.println(k);
		bst.insert(0);
		///bfs(bst.getRoot());
		//findKthSmallest(bst.getRoot());
		//bfs(bst.getRoot());
		//getSum(bst.getRoot(), (Integer)bst.getRoot().data);
		//System.out.println(treePathsSumUtil(bst.getRoot(), 0));
//		bfs(bst.getRoot());
		/*List<List<Integer>> bfslist = bfsLists(bst.getRoot());
		int depth = 0;
		for (List<Integer> list : bfslist) {
			System.out.println("at depth " + depth);
			for (Integer integer : list) {
				System.out.println(integer);
			}
			depth++;
		}*/
		//testQueueInJava();
//		bst.inorderTraversal(bst.getRoot());
	}
	
	public static int sum = 0;
	
	public static void getSum(TreeNode r, int num)
	{
		if(r.left != null)
			getSum(r.left, num*10 + (Integer)r.left.data);
		if(r.right != null)
			getSum(r.right, num*10 + (Integer)r.right.data);
		else if(r.left == null && r.right == null)
			sum = sum + num;
	}
	public static int treePathsSumUtil(TreeNode root, int val)
	{
		// Base case
	    if (root == null)  return 0;
	 
	    // Update val
	    val = (val*10 + (Integer)root.data);
	 
	    // if current node is leaf, return the current value of val
	    if (root.left==null && root.right==null)
	       return val;
	 
	    // recur sum of values for left and right subtree
	    return treePathsSumUtil(root.left, val) +
	           treePathsSumUtil(root.right, val);
	}
	
	public static int k = 0;
	public static void findKthSmallest(TreeNode r)
	{
		if( r == null)
			return;
		findKthSmallest(r.left);
		k++;
		System.out.println((Integer)r.data + " k value is : "  + k);
		/*if(k == 0)
		{
			System.out.println((Integer)r.data + " k value is : "  + k);
			return;
		}*/
		findKthSmallest(r.right);
	}
	
	public int smumTree(TreeNode r)
	{
		if(r == null)
			return 0;
		else
			r.data = smumTree(r.left) + smumTree(r.right);
		return (Integer)r.data;
	}
	
	public static void testQueueInJava()
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		Integer i ;
		while((i = q.remove())!=null)
		{
			System.out.println(i);
		}
		
	}
	
	public static void bfs(TreeNode root)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode current = null;
		if(root == null)
			return;
		else
		{
			q.add(root);
			while(q.isEmpty() == false)
			{
				current = q.remove();
				System.out.println((Integer)(current.data));
				if(current.left != null)
				{
					q.add(current.left);
				}
				if(current.right != null)
				{
					q.add(current.right);
				}
			}
		}
	}
	
	public static List<List<Integer>> bfsLists(TreeNode root)
	{
		List<List<Integer>> bfsList = new ArrayList<List<Integer>>();
		int end;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode current = null;
		if(root == null)
			return null;
		else
		{
			List<Integer> list = new ArrayList<Integer>();
			q.add(root);
			end = (Integer) root.data;
			while(q.isEmpty() == false)
			{
				current = q.remove();
				System.out.println((Integer)(current.data));
				list.add((Integer)current.data);
				if(current.left != null)
				{
					q.add(current.left);
				}
				if(current.right != null)
				{
					q.add(current.right);
				}
				if(end == (Integer)current.data)
				{
					if(current.right != null)
						 end = (Integer)current.right.data;
					bfsList.add(list);
					list = new ArrayList<Integer>();
				}
			}
		}
		return bfsList;
	}
	
}
