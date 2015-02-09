package whatsapp;


//AUTHOR shashi ranjan



//Question 1
/*public class Node {
	//input array that holds integers
	int nums[];
	Node next;
	//constructor to initialize input array
	public Node(int size, int[] arr) {
		nums =  new int[size];
		nums = arr;
	}
}	*/

//Question2, 3, 4
public class MergeSort {
	/**
	 * Definition for singly-linked list.*/
	  public static class ListNode {
		  	int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	  
	//Qesution 3 and 4 to test merge function against some arbitrary input  
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(7);
		ListNode l3 = new ListNode(7);
		ListNode l4 = new ListNode(10);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		ListNode l5 = new ListNode(1);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(6);
		ListNode l8 = new ListNode(12);
		l5.next = l6;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = null;
		
		ListNode l = mergeList(l1, l5);
		System.out.println("TC1:");
		System.out.println("List 1 is : ");
		while(l1!= null)
		{
			System.out.print(l1.val +" ");
			l1 = l1.next;
		}
		System.out.println();
		System.out.println("List 2 is : ");
		while(l5!= null)
		{
			System.out.print(l5.val +" ");
			l5 = l5.next;
		}
		System.out.println();
		System.out.println("sorted list is ");
		while(l!= null)
		{
			System.out.print(l.val +" ");
			l = l.next;
		}
		System.out.println();
		System.out.println();
		System.out.println("TC2: ");
		System.out.println("List 1 is : null");
		System.out.println("List 2 is : null");
		l = mergeList(l1, l5);
		if(l == null)
			System.out.println("output list is null");
	}
	
	//function that merges two sorted linked lists into a single,
	//sorted linked list
	public static ListNode mergeList(ListNode l1, ListNode l2)
	{
		ListNode l3 = null, curr = null;
		ListNode head = null;
		while(l1 != null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				l3 = new ListNode(l1.val);
				l3.next = null;
				l1 = l1.next;
			}
			else
			{
				l3 = new ListNode(l2.val);
				l3.next = null;
				l2 = l2.next;
			}
			if(head == null)
			{
				head = l3;
			}
			else
			{
				curr.next = l3;
			}
			curr = l3;
		}
		if(l1!= null)
		{
			while(l1 != null)
			{
				l3 = new ListNode(l1.val);
				l3.next = null;
				if(head == null)
				{
					head = l3;
				}
				else
				{
					curr.next = l3;
				}
				curr = l3;
				l1 = l1.next;
			}
		}
		if(l2!= null)
		{
			while(l2 != null)
			{
				l3 = new ListNode(l2.val);
				l3.next = null;
				if(head == null)
				{
					head = l3;
				}
				else
				{
					curr.next = l3;
				}
				curr = l3;
				l2 = l2.next;
			}
		}
		
		return head;
	}
	
}
