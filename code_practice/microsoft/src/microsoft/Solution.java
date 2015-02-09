package microsoft;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		int a[] = {4,2,7,5,8,1,3,9,6,11,10};
		int b[] = {4,7,8,5,2,9,11,10,6,3,1};
		TreeNode tn = main.buildTree(a, b);
		//System.out.println(tn.val);
		breadth(tn);
	}
	
	public static void printInorder(TreeNode root)
	{
		if (root == null)
	          return;
		printInorder(root.left);
		printInorder(root.right);
	      System.out.print(root.val + " ");
	      ///printInorder(root.right);
	}
	
	void printNode(int n)
	{
	      System.out.println(n);
	}
	
	public static String doIt(TreeNode t) {
		System.out.print("levelorder:");
		return doIt(t,t);
	}
}
	
public static String doIt(TreeNode  t,BTreeNode<T> node) {
		
		Queue<T> queue = new LinkedList<T>();
		Queue<T> levelorder = new LinkedList<T>();

		if (node != null){
			queue.add(node.element());
		}
		
		if (queue.isEmpty() == false){
			levelorder.add(node.element());
			System.out.print(node.element() + " ");
			
			if (node.hasLeft()){
				return doIt(t,node.getLeft());			
			}
			if (node.hasRight()){
				return doIt(t,node.getRight());
			}
		}	
		return levelorder + "";    
	}
	
	public static void breadth(TreeNode root){
	      if (root == null)
	          return;

	      System.out.print(root.left + " ");
	      System.out.print(root.right + " " );
	      breadth(root.left);
	      breadth(root.right);
	 }
}
