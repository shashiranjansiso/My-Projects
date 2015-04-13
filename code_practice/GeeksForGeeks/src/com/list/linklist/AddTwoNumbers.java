package com.list.linklist;

import com.list.linklist.LinkList.Node;


public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
		LinkList l1 = new LinkList();	//  representing 987
		l1.insertBeginning(9);  // 9 -> N
		l1.insertBeginning(8);	// 8->9->N
		l1.insertBeginning(7);	// 7->8->9->N
		LinkList l2 = new LinkList(); //representing 53 
		l2.insertBeginning(5);	// 5->N
		l2.insertBeginning(3);	//3->5->N
		//l2.insertBeginning(8);	
		//LinkList l3 = add(l1.head, l2.head);	//       1040 0->4->0->1->N
		//l3.printList();
		//reverse(l1.head);
		testReverseKNode();
	}
	
	public static void testReverseKNode()
	{
		LinkList l1 = new LinkList();	
		l1.insertEnd(1);
		l1.insertEnd(2);
		l1.insertEnd(3);
		l1.insertEnd(4);
		l1.insertEnd(5);
		l1.insertEnd(6);
		l1.insertEnd(7);
		l1.insertEnd(8);
		l1.insertEnd(9);
		reverseK(l1.head, 3);
	}
	
	public static void reverseK(Node h, int k)
	{
		Node head;
		head = reverseRecur(null, h, h.next, k);
		while(head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	public static Node reverseRecur(Node p, Node c, Node n, int k)
	{
		Node head = c;
		boolean found = false;
		int i;
		for(i = 0; i < k ; i++)
		{
			if(n == null)
			{
				found = true;
				break;
			}
			if(i != 0)
			{
				c.next = p;
			}
			else
				c.next = null;
			p=c;
			c=n;
			n = n.next;
		}
		if(found)
		{
			if(i != 0)
				c.next = p;
			return c;
		}
		head.next = reverseRecur(p, c, n, k);
		return p;
	}
	

	public static void reverse(Node h)
	{
		Node head;
		Node p = null;
		Node c = h;
		Node n = h.next;
		while(n != null){
			c.next = p;
			p = c;
			c = n;
			n = n.next;
		}
		c.next = p;
		head = c;
		while(head != null)
		{
			System.out.println( head.data);
			head = head.next;
		}
	}
	
	public static void printList(LinkList l)
	{
		l.printList();
	}
	
	public static LinkList add(Node h1, Node h2)
	{
		LinkList l = new LinkList();
		int carry = 0;
		while(h2 != null && h2 != null)
		{
			int sum = h1.data + h2.data + carry;
			carry = sum/10;
			h1 = h1.next;
			h2 = h2.next;
			l.insertEnd(sum%10);
		}
		while(h1 != null)
		{
			int sum = h1.data + carry;
			carry = sum/10;
			h1 = h1.next;
			l.insertEnd(sum%10);
		}
		while(h2 != null)
		{
			int sum = h2.data + carry;
			carry = sum/10;
			h2 = h2.next;
			l.insertEnd(sum%10);
		}
		if(carry > 0)
			l.insertEnd(carry);
		return l;
	}
	
}
