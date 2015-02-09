package cracking.codinginterview.linklist;

import java.util.LinkedList;

import cracking.codinginterview.linklist.Problem5.Node;


public class Problem4 {
	public static void main(String[] args)
	{
		LinkList list = new LinkList();
		list.insertBeginning(3);
		list.insertBeginning(8);
		list.insertBeginning(4);
		list.insertBeginning(2);
		list.insertBeginning(1);
		list.insertBeginning(7);
		//list.printList();
		list = organize(list, 1);
		list.printList();
	}
	
	public static LinkList organize(LinkList list, int value)
	{
		Node temp = list.head.next;
		Node temp1 = list.head;
		while(temp != null)
		{
			if(temp.data < value)
			{
				temp1.next = temp.next;
				temp.next = list.head;
				list.head = temp;
				temp = temp1.next;
			}
			else
			{
				temp1 = temp;
				temp = temp.next;
			}
		}
		return list;
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
	
	static class Node
	{
		Node next;
		int data;
	}
}
