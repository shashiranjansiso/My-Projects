package com.careercup.facebookinterviewquestions;

public class FindFirstNonRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "geeksforgeeks";
		System.out.println(s.charAt(firstNonRepeating(s.toCharArray())));
	}

	public static int firstNonRepeating(char s[])
	{
		int a[][] = new int[256][2];
		for(int i = 0; i < 256; i++)
		{
			a[i][0] = -1;
			a[i][1] = 0;
		}
		for(int i = 0; i < s.length; i++)
		{
			if(a[s[i]][0] == -1)
			{
				//first time
				a[s[i]][0] = i;
			}
			a[s[i]][1]++;
		}
		int min = 300;
		for(int i = 0; i < 256; i++)
		{
			if(a[i][1] == 1 && a[i][0] < min)
				min = a[i][0];
		}
		return min;
	}
	
}
