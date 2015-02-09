package cracking.codinginterview.linklist;

import cracking.codinginterview.linklist.Problem4.Node;

public class GeekForGeekQuestion {

	public static void main(String[] args)
	{
		LinkList list = new LinkList();
		list.insertEnd(0);
		list.insertEnd(1);
		list.insertEnd(0);
		list.insertEnd(2);
		list.insertEnd(1);
		list.insertEnd(0);
		list.printList();
		System.out.println();
		sort(list);
		list.printList();
	}
	
	public static void sort(LinkList list)
	{
		Node curr = list.head;
		while(curr != null)
		{
			if(curr.data == 2 && curr.next != null)
			{
				
				list.insertEnd(curr.data);
				Node temp = curr.next;
				list.remove(curr);
				curr = temp;
				System.out.println("found 2 to swap");
				list.printList();
				System.out.println();
			}
			else if(curr.data == 0 && curr != list.head)
			{
				list.insertBeginning(curr.data);
				Node temp = curr.next;
				list.remove(curr);
				curr = temp;
				System.out.println("found 0 to swap");
				list.printList();
				System.out.println();
			}
			else
				curr = curr.next;
		}
	}
	public static class LinkList
	{
		public Node head;
		public LinkList()
		{
			
		}
		
		
		
		public void insertBeginning(int data)
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
		
		public void insertEnd(int data)
		{
			if(head == null)
			{
				head = new Node();
				head.data = data;
				head.next = null;
				return;
			}
			Node curr = head;
			while(curr.next != null)
				curr = curr.next;
			Node temp = new Node();
			temp.data = data;
			temp.next = null;
			curr.next = temp;
		}
		
		public void remove(Node node)
		{
			Node curr = head;
			while(curr.next != node)
				curr = curr.next;
			curr.next = node.next;
			node.next = null;
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
	
}
