package BinaryTree;

public class TreeNode {
	  
    // data members
    private int key;
    private TreeNode left;
    private TreeNode right;
  
    // Accessor methods
    public int key()        { return key; }
    public TreeNode left()  { return left; }
    public TreeNode right() { return right; }
  
    // Constructor
    public TreeNode(int key) { this.key = key; left = null; right = null; }
  
    // Methods to set left and right subtrees
    public void setLeft(TreeNode left)   { this.left = left; }
    public void setRight(TreeNode right) { this.right = right; }
}