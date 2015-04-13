package com.purestorage;

import java.util.Stack;


public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(get_calendar_difference("12/31", "01/01"));
		testLockOrder();
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size");
		int len = sc.nextInt();
		System.out.println("Enter the array elements");
		int a[] = new int[len];
		for(int i = 0; i < len; i++)
		{
			a[i] = sc.nextInt();
		}
		//System.out.println();
		test(a);*/
	}	
	
	public static void testLockOrder()
	{
		String s[] = new String[5];
		s[0] = "lock A";
		s[1] = "lock B";
		s[2] = "unlock B";
		s[3] = "unlock A";
		s[4] = "lock A";
		System.out.println(checkLockOrder(s));
	}
	
	public static void test(int a[])
	{
		//boolean result = true;
		for(int i = 0; i < a.length; i++)
		{
			 int index = sorted_search(a, a[i]);
			 //System.out.println("bobs result" + i + " bobs index:"  + index);
			 if(index != i)
			 {
				 //result = false;
				 System.out.println(a.length);
				 printArray(a);
				 System.out.println(a[i]);
				 return;
			 }
		}
		System.out.println("CORRECT");
	}
	
	public static void printArray(int a[])
	{
		for (int i : a) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}
	
	public static int sorted_search(int [] e, int t)
	{
		if(e == null || e.length <= 0 )
			return -1;
		int l = 0, r = e.length -1;
		while(l < r)
		{
			int m = (l + r +1)/2;
			if(e[m] > t)
				r = m - 1;
			else
				l = m+1;
		}
		if(e[r] == t)
			return r;
		return -1;
	}
	
	public static boolean checkLockOrder(String locks[])
	{
		Stack<String> s = new Stack<String>();
		for (String string : locks) {
			String a[] = string.split(" ");
			if(s.isEmpty() && a[0].contains("unlock"))
				return false;
			if(a[0].equalsIgnoreCase("lock"))
				s.push(a[1]);
			if(a[0].equalsIgnoreCase("unlock"))
			{
				String top = s.pop();
				if(!top.equalsIgnoreCase(a[1]))
					return false;
			}
		}
		if(!s.isEmpty())
			return false;
		return true;
	}
	
	public static int get_calendar_difference(String day_a, String day_b) {
		int mm[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		String s[] = day_a.split("/");
		int m1 = Integer.parseInt(s[0]);
		int d1 = Integer.parseInt(s[1]);
		s = day_b.split("/");
		int m2 = Integer.parseInt(s[0]);
		int d2 = Integer.parseInt(s[1]);
		int days = 0;
		if(m1 > m2)
			return 364;
		while(m2 != m1)
		{
			days = days + mm[m1-1];
			m1++;
		}
		days = days + (d2-d1);
		return days;

    }
}

class Date
{
	int dd;
	int mm;
	Date(int dd, int mm)
	{
		this.dd = dd;
		this.mm = mm;
	}
}