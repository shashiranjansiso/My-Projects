package com.careercup.facebookinterviewquestions;

public class MajorityElementVotersAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		System.out.println(majorityElement(a));
	}

	public static int majorityElement(int a[])
	{
	    int element = a[0];
	    int count = 1;
	    for(int i = 1; i < a.length; i++)
	    {
	        if(element == -1)
	        {
	            count = 1;
	            element = a[i];
	        }
	        else if(a[i] == element)
	            count++;
	        else
	        {
	            count--;
	            if(count == 0)
	            	element = -1;
	        }    
	    }
	    return element;
	}
}
