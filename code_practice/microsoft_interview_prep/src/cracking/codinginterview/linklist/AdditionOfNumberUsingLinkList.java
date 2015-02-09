package cracking.codinginterview.linklist;

import cracking.codinginterview.linklist.Problem4.Node;


public class AdditionOfNumberUsingLinkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList l1 = new LinkList();
		l1.insertBeginning(9);
		l1.insertBeginning(8);
		l1.insertBeginning(9);
		LinkList l2 = new LinkList();
		l2.insertBeginning(2);
		l2.insertBeginning(5);
		//l2.insertBeginning(8);
		LinkList l3 = add(l1, l2);
		l3.printList();
	}
	
	public static LinkList add(LinkList l1, LinkList l2)
	{
		LinkList l3 = new LinkList();
		if(l1 == null && l2 == null)
			return null;
		else if(l1 == null && l2 != null)
			return l2;
		else if(l1 != null && l2 == null)
			return l1;
		else
		{
			Node t1 = l1.head;
			Node t2 = l2.head;
			Node t3 = null;
			int carry = 0;
			while(t1 != null || t2 != null)
			{
				int first = 0, second = 0, sum;
				if(t1 != null)
				{
					first = t1.data;
					t1 = t1.next;
				}
				if(t2 != null)
				{
					second = t2.data;
					t2= t2.next;
				}
				sum = first + second + carry;
				Node t = new Node();
				t.data = sum%10;
				t.next = null;
				carry = sum/10;
				if(l3.head == null)
				{
					l3.head = t;
					t3 = t;
				}
				else
				{
					t3.next = t;
					t3 = t;
				}
			}
			if(carry != 0)
			{
				Node t = new Node();
				t.next = null;
				t.data = carry;
				t3.next = t;
				t3 = t;
			}
		}
		
		return l3;
	}
	
}
