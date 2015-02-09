package BinaryTree;

public class MaxSumPath {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Create following Binary Tree
		        1
		      /    \
		    2        3
		   / \      / \
		  4   5    9   7
		
		  */
		TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.left().setLeft(new TreeNode(4));
        root.left().setRight(new TreeNode(5));
        root.right().setLeft(new TreeNode(9));
        root.right().setRight(new TreeNode(7));
        printMaxSumPath(root);
	}
	
	public static int maxSum = Integer.MIN_VALUE;
	
	public static void printMaxSumPath(TreeNode r)
	{
		calculateMaxSum(r, 0);
		System.out.println(maxSum);
	}
	
	public static void calculateMaxSum(TreeNode r, int sum)
	{
		if(r == null){
			//System.out.println("sums are " + sum);
			if(sum > maxSum)
				maxSum = sum;
			return;
		}
		calculateMaxSum(r.left(), sum + r.key());
		calculateMaxSum(r.right(), sum + r.key());
	}

}
