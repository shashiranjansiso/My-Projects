package cracking.codinginterview.linklist;


public class Problem7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList list1 = new LinkList();
		list1.insertBeginning('a');
		list1.insertBeginning('b');
		list1.insertBeginning('c');
		list1.insertBeginning('c');
		list1.insertBeginning('b');
		list1.insertBeginning('a');
	}
	
	public static boolean isPalindrome(LinkList l)
	{
		return false;
	}

	public static class LinkList
	{
		public Node head;
		public LinkList()
		{
			
		}
		public void insertBeginning(char data)
		{
			Node node = new Node();
			node.data = data;
			node.next = null;
			if(head == null)
				head = node;
			else
			{
				node.next = head;
				head = node;
			}
		}
		
		public void printList()
		{
			Node temp = head;
			while(temp != null)
			{
				if(temp.next == null)
					System.out.print(temp.data + "->NULL");
				else
					System.out.print(temp.data + "->");
				temp = temp.next;
			}
		}
	}
	static class Node
	{
		Node next;
		char data;
	}
}
