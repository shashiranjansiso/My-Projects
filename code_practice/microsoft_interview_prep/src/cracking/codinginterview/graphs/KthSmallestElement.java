package cracking.codinginterview.graphs;

public class KthSmallestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(2);
		bst.insert(-4);
		bst.insert(3);
		bst.insert(18);
		bst.insert(21);
		//bst.insert(19);
		//bst.insert(25);
		//reverseinorder(bst.getRoot());
		//inorder(bst.getRoot(), 0);
		//printRange(bst.getRoot(), 0, 10);
		add(bst.getRoot(), 0);
	}
	
	
	
	public static int add(TreeNode root, int max)
	{
		if(root == null)
			return max;
		
		add(root.right,max);
		root.data = (Integer)root.data + max;
		max = (Integer)root.data;
		System.out.print(root.data + "=>");
		add(root.left, (Integer)root.data);
		//root.data = 
		return max;
	}
	
	public static void inorder(TreeNode root)
	{
		int c = 0;
		if(root == null)
		{	//k++;
			return;
		}
		inorder(root.left);
		
		System.out.print(root.data + "   =>  ");
		inorder(root.right);
	}
	//TODO not working use stacks to print not recrursion
	public static void inorder(TreeNode root, int k)
	{
		int c = 0;
		if(root == null)
		{	//k++;
			return;
		}
		inorder(root.left,k++);
		
		System.out.print(root.data + "(k=" + k + ")   =>  ");
		inorder(root.right,k++);
	}
	public static void reverseinorder(TreeNode root)
	{
		if(root == null)
		{	//k++;
			return;
		}
		reverseinorder(root.right);
		
		System.out.print(root.data +" =>  ");
		reverseinorder(root.left);
	}
	
	//TODO
	public static void printRange(TreeNode root, int start, int end)
	{
		if(root == null)
			return;
		int data = (Integer) root.data;
		//if(data > )
		printRange(root.left, start, end);
		
		if(data >= start && data <= end)
			System.out.println(root.data);
		printRange(root.right, start, end);
	}
	
	

}
