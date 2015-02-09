package cracking.codinginterview.arraysandstrings;

private class Problem1 {

	private class shashi{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdaefgh";
		boolean flag = /*hasRepeated(str)*/ hasDupChars(str);
		if(flag)
			System.out.println("string has repeated chars");
		else
			System.out.println("no repeated chars");
	}
	
	public static boolean hasDupChars(String str)
	{
		for(int i = 0;i < str.length(); i++)
		{
			for(int j = i + 1; j < str.length(); j++)
			{
				if(str.charAt(i) == str.charAt(j))
					return true;
			}
		}
		return false;
	}
	
	public static boolean hasRepeated(String str)
	{
		Node root = null;
		for(int i = 0; i < str.length(); i++)
		{
			Node node = insert(root, str.charAt(i));
			if(node == null)
				return true; 	//repeated char
			else
			{
				root = node;
				
			}
		}
		return false;
	}
	
	public static Node insert(Node node, char c)
	{	
		if(node == null)
			node = new Node(c);
		else if(node.data == c)
			return null;
		else if(c > node.data)
			node.left = insert(node.left, c);
		else
			node.right = insert(node.right, c);
		return node;
	}
	
	public static class Node
	{
		public Node left;
		public Node right;
		public char data;
		public Node(char c)
		{
			left = null;
			right = null;
			data = c;
		}
	}

}

