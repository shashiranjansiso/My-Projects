package com.shashi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextGreaterNumWithSameSetOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findNextGreater(534976, 6));
	}
	public static int findNextGreater(int n, int digits)
	{
		List<Integer> list = new ArrayList<Integer>();
		boolean found = false;
		int i = 0;
		while(n/10 != 0)
		{
			list.add(n%10);
			n = n/10;
			
			if(i > 0 && list.get(i) < list.get(i-1))
			{
				found = true;
				break;
			}
			i++;
		}
		if(found)
		{
			int f = list.get(0);
			int last= list.get(i);
			n = n*100 + f*10 + last;
			Collections.sort(list);
			for(int j = 0; j<=i; j++)
			{
				if(list.get(j)!= f && list.get(j)!= last)
				{
					n = n*10 + list.get(j);
				}
			}
			return n;
		}
		return -1;
	}

}
