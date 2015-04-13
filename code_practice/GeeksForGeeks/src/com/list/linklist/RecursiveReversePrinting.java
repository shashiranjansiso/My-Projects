package com.list.linklist;

import com.list.linklist.LinkList.Node;

public class RecursiveReversePrinting {

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
		printReverse(l1, l1.head);
	}
	
	public static void printReverse(LinkList l, Node t)
	{
		if(t == null)
			return;
		printReverse(l, t.next);
		System.out.print(t.data + "->");
	}
	
	

}
