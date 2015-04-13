package com.list.linklist;

import com.list.linklist.LinkList.Node;

public class ReverseWithRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList l1 = new LinkList();	
		l1.insertBeginning(9);  
		l1.insertBeginning(8);	
		l1.insertBeginning(7);	
		l1.insertBeginning(6);	
		l1.insertBeginning(5);	
		//l1.printList();
		Node h = reverse(l1.head, null);
		while(h != null)
		{
			if(h.next == null)
				System.out.print(h.data + "->NULL");
			else
				System.out.print(h.data + "->");
			h = h.next;
		}
	}
	
	public static Node reverse(Node c, Node p)
	{
		if(c == null)
			return p;
		
		Node p1 =  reverse(c.next, c);
		c.next = p;
		return p1;
	}

}
