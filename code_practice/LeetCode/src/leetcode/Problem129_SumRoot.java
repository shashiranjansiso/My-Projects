package leetcode;

public class Problem129_SumRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.left = left;
		root.right = null;
		left.left = null;
		left.right = null;
		right.left = null;
		right.right = null;
		System.out.println(sumNumbers(root));
	}

	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			// TODO Auto-generated constructor stub
			val = x;
		}
	}
	
	static int sum = 0;
	
	public static int sumNumbers(TreeNode root) {
		//int a[] = new int[10];
		calculateSum(root, 0);
		return sum;
    }
	
	public static void calculateSum(TreeNode r, int num)
	{
		if(r == null)
			return;
		num = num*10 + r.val;
		if(r.left == null && r.right == null)
		{	
			sum += num;
		}
		else
		{
			calculateSum(r.left, num);
			calculateSum(r.right, num);
		}
	}
}
