package BinaryTree;

import java.util.HashMap;

public class BinaryTreeVerticalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Create following Binary Tree
		        1
		      /    \
		    2        3
		   / \      / \
		  4   5    6   7
		
		  */
		TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.left().setLeft(new TreeNode(4));
        root.left().setRight(new TreeNode(5));
        root.right().setLeft(new TreeNode(6));
        root.right().setRight(new TreeNode(7));
        printVerticalSum(root);
	}
	
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;
	
	public static void printVerticalSum(TreeNode r)
	{
		if(r == null)
			return;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		fillMap(map, r, 0);
		int index = 1;
		for(int i = min; i <= max; i++)
			System.out.println("level:" + index++ + "  sum is: " + map.get(i));
	}

	public static void fillMap(HashMap<Integer, Integer> map, TreeNode r, int level)
	{
		if(r == null)
			return;
		int sum = 0;
		if(map.get(level) != null)
		{
			sum = map.get(level);
		}
		sum += r.key();
		map.put(level, sum);
		if(level < min)
			min = level;
		if(level > max)
			max = level;
		fillMap(map, r.right(), level + 1);
		fillMap(map, r.left(), level - 1);
	}
}
