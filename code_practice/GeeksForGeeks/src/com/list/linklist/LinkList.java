package com.list.linklist;


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
		Node node = new Node();
		node.data = data;
		node.next = null;
		if(head == null)
		{
			head = node;
			return;
		}
		Node curr = head;
		while(curr.next != null)
			curr = curr.next;
		curr.next = node;
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
	
	public static class Node
	{
		public Node next;
		public int data;
	}
}

