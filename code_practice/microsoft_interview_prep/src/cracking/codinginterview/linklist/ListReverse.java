package cracking.codinginterview.linklist;

import cracking.codinginterview.linklist.Problem4.Node;

public class ListReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList l = new LinkList();
		l.insertBeginning(4);
		l.insertBeginning(3);
		l.insertBeginning(2);
		l.insertBeginning(1);
		l.printList();
		reverse(l);
		System.out.println("list after reversing. ....");
		l.printList();
	}

	public static void reverse(LinkList l)
	{
		Node curr = l.head.next;
		Node prev = l.head;
		Node next = curr.next;
		prev.next = null;
		while(next != null)
		{
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		l.head = curr;
	}
	
}
