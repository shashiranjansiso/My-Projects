package cracking.codinginterview.linklist;

import cracking.codinginterview.linklist.Problem4.Node;

public class RecursivePrintLinkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkList l = new LinkList();
		l.insertBeginning(5);
		l.insertBeginning(4);
		l.insertBeginning(3);
		l.insertBeginning(2);
		l.insertBeginning(1);
		printList(l.head);
	}
	
	public static void printList(Node node)
	{
		if(node == null) return;
		printList(node.next);
		System.out.println(node.data);
	}

}
