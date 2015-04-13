package com.list.linklist;

import com.list.linklist.LinkList.Node;

public class DeleteNodesWhichHaveGreaterValueonRightSide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList l1 = new LinkList();	
		l1.insertBeginning(3);  
		l1.insertBeginning(2);	
		l1.insertBeginning(6);	
		l1.insertBeginning(5);	
		
		l1.insertBeginning(11);  
		l1.insertBeginning(10);	
		l1.insertBeginning(15);	
		l1.insertBeginning(12);
		l1.printList();
		System.out.println();
		delete(l1, null, l1.head);
		l1.printList();
	}
	
	public static int delete(LinkList l, Node prev, Node curr)
	{
		if(curr == null)
			return -1;
		int val = delete(l, curr, curr.next);
		if(val > curr.data)
		{
			deleteNode(l, prev, curr);
			return val;
		}
		return curr.data;
	}
	
	public static void deleteNode(LinkList l, Node prev, Node curr)
	{
		if(prev == null)
		{
			curr = curr.next;
			l.head = curr;
		}
		else
			prev.next = curr.next;
	}
}
