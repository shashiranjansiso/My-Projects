package vmware;

import java.net.NetPermission;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.list.linklist.LinkList;
import com.list.linklist.LinkList.Node;

public class LinkListDuplicateRemoval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList l1 = new LinkList();	//  representing 987
		l1.insertBeginning(52);
		l1.insertBeginning(43);  // 9 -> N
		l1.insertBeginning(41);	// 8->9->N
		l1.insertBeginning(21);	// 7->8->9->N
		l1.insertBeginning(12);
		l1.insertBeginning(11);
		l1.insertBeginning(11);
		l1.insertBeginning(11);
		l1.insertBeginning(12);
		Node h = removeDuplicates(l1.head);
		printList(h);
	}
	
	public static Node removeDuplicates(Node h)
	{
		Set<Integer> set = new HashSet<Integer>();
		Node next, curr;
		curr = h;
		next = curr.next;
		set.add(curr.data);
		while(next != null)
		{
			while(set.contains(next.data))
			{
				//next is duplicate remove
				curr.next = next.next;
				next = next.next;
				if(next == null)
					return h;
			}
			set.add(next.data);
			curr = next;
			next = next.next;
		}
		return h;
	}
	
	public static void printList(Node l)
	{
		
		while(l!= null)
		{
			System.out.println(l.data);
			l = l.next;
		}
	}

}
