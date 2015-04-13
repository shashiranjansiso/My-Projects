package com.careercup.facebookinterviewquestions;

public class LongestNonIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABCADEFB";
		System.out.println(LNS(s.toCharArray()));
	}

	public static int LNS(char a[])
	{
		int i = 0; int c = 0; int max = Integer.MIN_VALUE;
		int tab[]= new int[126];
		for(int j = 0; j < 126; j++)
			tab[j] = -1;
		while(i<a.length)
		{
			if(tab[a[i]] == -1)
			{
				tab[a[i]] = i;
				c++;
			}
			else
			{
				if(c > max)
					max = c;
				c = i-1-tab[a[i]];
			}
			i++;
		}
		return max;
	}
	
}
