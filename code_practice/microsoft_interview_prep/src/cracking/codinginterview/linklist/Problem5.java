package cracking.codinginterview.linklist;


public class Problem5 {
	public static void main(String[] args)
	{
		LinkList list1 = new LinkList();
		list1.insertBeginning(4);
		list1.insertBeginning(2);
		list1.insertBeginning(7);
		
		LinkList list2 = new LinkList();
		list2.insertBeginning(6);
		list2.insertBeginning(8);
		list2.insertBeginning(3);
		//list.printList();
		/*list1.printList();*/
		//LinkList l3 = add(list1, list2);
		//l3.printList();
		addList(list1, list2);
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
	
	public static void addList(LinkList l1, LinkList l2)
	{
		LinkList addList = new LinkList();
		PartialAddList list = recurseAdd(l1.head, l2.head, addList);
		if(list.carry != 0)
			addList = addbeg(list.addList, list.carry);
		addList.printList();
	}
	
	public static class PartialAddList
	{
		public LinkList addList;
		public int carry;
	}
	
	public static PartialAddList recurseAdd(Node h1, Node h2, LinkList addList)
	{
		int sum;
		PartialAddList list = new PartialAddList();
		list.addList = addList;
		if(h1.next == null || h2.next == null)
		{
			sum = h1.data + h2.data;
			addList = addbeg(addList, sum %10);
			list.carry = sum/10;
			list.addList = addList;
			return list;
		}
		else
		{
			list = recurseAdd(h1.next, h2.next, list.addList);
			sum = h1.data + h2.data + list.carry;
			addList = addbeg(addList, sum%10);
			list.addList = addList;
			list.carry = sum/10;
			return list;
		}
	}
	
	public static LinkList addbeg(LinkList l, int data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		if(l.head == null)
			l.head = node;
		else{
			node.next = l.head;
			l.head = node;
		}
		return l;
	}
	
	public static LinkList add(LinkList l1, LinkList l2)
	{
		LinkList l;
		if(l1 == null && l2 != null)
			return l2;
		else if(l1 != null && l2 == null)
			return l1;
		else
		{
			l = new LinkList();
			Node curr = null;
			Node h1 = l1.head;
			Node h2 = l2.head;
			int quotient = 0;
			while(h1!= null || h2 != null)
			{
				Node node = new Node();
				int sum;
				if(h1 != null && h2 != null)
				{
					sum = h1.data + h2.data + quotient;
					h1= h1.next;
					h2 = h2.next;
				}
				else if(h2 == null && h1 != null)
				{
					sum = h1.data + quotient;
					h1= h1.next;
				}
				else
				{
					sum = h2.data + quotient;
					h2= h2.next;
				}
				node.data = sum%10;
				quotient = sum/10;
				if(l.head == null)
				{
					l.head = node;
					curr = l.head;
				}
				else
				{
					curr.next = node;
					curr = curr.next;
				}
			}
			if(quotient != 0)
			{
				Node node = new Node();
				node.data = quotient;
				curr.next = node;
			}
		}
		return l;
	}
	
	static class Node
	{
		Node next;
		int data;
	}
}
