package vmware;


public class HeightOfTreeUsingPreorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int in[] = {15,30,35,40,45,50,60,70,72,75,77,80};
		//int pre[] = {50,30,15,40,35,45,70,60,80,75,72,77};
		int pre[] = {50,30,-1,40,-1,-1,70,-1,80,75,-1,-1};
		//TreeNode r = construct(pre);
		String str = "1 2 * * 3 4 * * *";
		System.out.println(heightOfTree(str));
		//TreeTraversal.preorder(r);
		//System.out.println(height(r));
	}
	static int heightOfTree(String enc) {
			if(enc.length() == 0)
				return 0;
			char pre[] = enc.toCharArray();
			constructR(pre, 0);
			return maxH;
    }
	static int maxH = Integer.MIN_VALUE;
	public static void constructR(char pre[], int h)
	{
		if(h > maxH)
			maxH = h;
		
		if(pre_l >= pre.length)
			return;
		while(pre_l < pre.length && pre[pre_l] == ' ')
			pre_l++;
		if(pre_l >= pre.length)
			return;
		if(pre[pre_l] == '*')
		{
			///r.right = null;
			//r.left = null;
			pre_l++;
			return;
		}
		while(pre_l < pre.length && pre[pre_l] != ' ')
			pre_l++;
		h++;
		constructR(pre, h);
		constructR(pre, h);
	}
	
	static int pre_l = 0;
	static int heightl = 0;
	static int heightr = 0;
	public TreeNode construct(char pre[])
	{
		if(pre_l >= pre.length)
			return null;
		TreeNode r = new TreeNode();
		r.data = pre[pre_l];
		
		if(pre[pre_l] == -1)
		{
			r.right = null;
			r.left = null;
			pre_l++;
			return r;
		}
		pre_l++;
		r.left = construct(pre);
		heightl++;
		r.right = construct(pre);
		heightr++;
		return r;
	}
 static class  TreeNode {
		public char data;
		public TreeNode left;
		public TreeNode right;
		
	}
	public static int height(TreeNode r)
	{
		if(r == null)
			return 0;
		return 1 + Math.max(height(r.left), height(r.right));
	}
	
}

