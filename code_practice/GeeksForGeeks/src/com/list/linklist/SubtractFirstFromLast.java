package com.list.linklist;

import java.util.Stack;

import com.list.linklist.LinkList.Node;

public class SubtractFirstFromLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList l = new LinkList();
		//l.insertBeginning(0);
		l.insertBeginning(1);
		l.insertBeginning(2);
		l.insertBeginning(3);
		l.insertBeginning(4);
		l.insertBeginning(5);
		substract(l);
		l.printList();
	}
	public static void substract(LinkList l)
	{
		Stack<Node> stack = new Stack<LinkList.Node>();
		Node slow = l.head, fast = l.head;
		while(fast != null && fast.next != null)
		{
			stack.push(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = slow.next;
		while(slow!= null)
		{
			Node node = stack.pop();
			node.data = node.data - slow.data;
			slow = slow.next;
		}
	}
}
