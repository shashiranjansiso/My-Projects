package cracking.codinginterview.linklist;

import cracking.codinginterview.linklist.Problem4.Node;

public class LinkList
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