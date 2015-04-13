package com.careercup.facebookinterviewquestions;

public class LookAndSayPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pattern(2));
	}
	
	public static String pattern(int num)
	{
		String curr = "1";
		String next;
		for(int i = 1 ; i < num; i++)
		{
			next = getNext(curr.toCharArray());
			curr = next;
		}
		return curr;
	}
	
	public static String getNext(char a[])
	{
		int i =1; 
		char next[] = new char[20]; 
		int c = 1;
		int j = 0;
		while(i < a.length)
		{
			if(a[i] == a[i-1])
			{
				c++;i++;
			}
			else if(a[i] != a[i-1])
			{
				next[j++] = (char) c;
				next[j++] = a[i-1];
				c=0;
			}
		}
		next[j++] = Integer.toString(c).toCharArray()[0];
		next[j++] = a[i-1];
		return next.toString();
	}

}
