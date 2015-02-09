package cracking.codinginterview.graphs;


public class DFS {

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
		
		dfs(bst.getRoot());
	}

	public static void dfs(TreeNode root)
	{
		if(root == null)
			return;
		else
		{
			System.out.println(root.data);
			dfs(root.left);
			dfs(root.right);
		}
	}
	
}
