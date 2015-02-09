package cracking.codinginterview.graphs;


public class TreeSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(2);
		bst.insert(-4);
		bst.insert(3);
		bst.insert(18);
		bst.insert(21);
		bst.insert(19);
		bst.insert(25);
		//boolean result = checkSum(bst.getRoot(), 69, 0);
		//System.out.println(result);
		inorder(extendLeft(bst.getRoot()));
		//int size = getSize(bst.getRoot());
		//System.out.println("size of tree is " + size);
		//System.out.println("height of tree is " + getHeight(bst.getRoot()));
		//TreeNode root = mirror(bst.getRoot());
		//printPath(bst.getRoot(), "");
		//System.out.println(countLeaf(bst.getRoot()));
		//bst.inorderTraversal(root);
	}

	public static int getSize(TreeNode root)
	{
		int size = 0;
		if(root == null)
			return 0;
		else 
		{
			return 1 + getSize(root.left) + getSize(root.right);
		}
	}
	
	public static int getHeight(TreeNode root)
	{
		if(root == null)
			return 0;
		return Math.max(1+ getHeight(root.left), 1 + getHeight(root.right));
	}
	
	public static void inorder(TreeNode root)
	{
		if(root == null)
			return;
		else
		{
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
	
	public static TreeNode mirror(TreeNode root)
	{
		if(root == null)
			return null;
		TreeNode r = new TreeNode();
		r.data = root.data;
		r.left = mirror(root.right);
		r.right = mirror(root.left);
		return r;
	}
	
	public static void printPath(TreeNode root, String path)
	{
		if(root == null)
		{
			return;
		}
		if(root.left == null && root.right == null)
			System.out.println(path + "=>" + root.data);
		printPath(root.left, path + "=>" + root.data);
		
		printPath(root.right, path + "=>" + root.data);
		
	}
	
	public static int countLeaf(TreeNode root)
	{
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		else 
			return countLeaf(root.left) + countLeaf(root.right);
	}
	
	public static boolean checkSum(TreeNode root, int sum, int currSum)
	{
		if(root == null)
			return false;
		if(root.left == null && root.right == null && sum == (currSum + (Integer)root.data))
			return true;
		currSum = currSum + (Integer)root.data;
		if(checkSum(root.left, sum, currSum) || checkSum(root.right, sum, currSum))
			return true;
		return false;
	}
	
	public static TreeNode extendLeft(TreeNode root)
	{
		if(root == null)
			return null;
		TreeNode node = new TreeNode();
		node.data = root.data;
		node.left = root.left;
		root.left = node;
		node.left = extendLeft(node.left);
		root.right = extendLeft(root.right);
		return root;
	}

}
