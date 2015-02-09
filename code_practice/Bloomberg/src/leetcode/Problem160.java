package leetcode;

public class Problem160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int l1 = 0, l2 = 0, d = 0;
		ListNode tempA = headA;
		ListNode tempB = headB;
		
		while(tempA != null)
		{
			l1++;
			tempA = tempA.next;
		}
		while(tempB != null)
		{
			l2++;
			tempB = tempB.next;
		}
		tempA = headA;
		tempB = headB;
		if(l1>l2)
		{
			d = l1-l2;
			while(d>0)
			{
				tempA=tempA.next;
				d--;
			}
		}
		else
		{
			d = l2-l1;
			while(d>0)
			{
				tempB=tempB.next;
				d--;
			}
		}		
		while(tempA!= null)
		{
			if(tempA.val == tempB.val)
				return tempA;	
			else
			{
				tempA = tempA.next;
				tempB = tempB.next;
			}
		}
		return null;
    }
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	} 
}
