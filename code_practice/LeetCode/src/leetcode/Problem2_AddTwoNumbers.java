package leetcode;

public class Problem2_AddTwoNumbers {

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
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(8);
		//ListNode l3 = new ListNode(9);
		l1.next =l2;
		l2.next =null;
		ListNode l4 = new ListNode(0);
		//ListNode l5 = new ListNode(6);
		//ListNode l6 = new ListNode(4);
		l4.next =null;
		//l5.next =l6;
		ListNode l = addTwoNumbers(l1, l4);
		while(l!= null)
		{
			System.out.println(l.val);
			l = l.next;
		}
	}
	
	@SuppressWarnings("unused")
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null,head = null, curr = null;
        int carry =0, sum = 0;
        while(l1!=null || l2!=null)
        {
        	if(l1 == null)
        	{
        		sum= l2.val + carry;
        		l2 = l2.next;
        	}
        	else if(l2==null)
        	{
        		sum = l1.val + carry;
        		l1 = l1.next;
        	}
        	else
        	{
        		sum = l1.val + l2.val + carry;
        		l1 = l1.next; l2 =l2.next;
        	}
        	l3 = new ListNode(sum%10);
        	l3.next = null;
        	if(head == null)
        	{
        		head = l3; curr = l3;
        	}
        	else
        	{
        		curr.next = l3;
        		curr = l3;
        	}
        	carry = sum/10;
        }
        if(carry != 0)
        {
            l3 = new ListNode(carry);
            l3.next = null;
            curr.next = l3;
        }
        
        return head;
    }

}
