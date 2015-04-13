package com.careercup.facebookinterviewquestions;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "dinitrophenylhydrazine";
		String b = "benzalphenylhydrazone";
		//String a = "ab";;
		//String b = "cd";
		//System.out.println(ED(a.toCharArray(), b.toCharArray(), a.length() -1, b.length() -1));
		System.out.println(EDMemoizatoin(a.toCharArray(), b.toCharArray()));
		System.out.println(edMemoization(a.toCharArray(), b.toCharArray()));
		//System.out.println(ed(a.toCharArray(), b.toCharArray(), a.length() -1, b.length() -1));
	}

	public static int ED(char a[], char b[], int i, int j)
	{
		if(i <0)
			return j+1;
		if(j < 0)
			return i+1;
		if(a[i] == b[j])
			return ED(a, b, i-1, j-1);
		else
			return 1 + Math.min(ED(a, b, i-1, j-1), Math.min(ED(a, b, i-1, j), ED(a, b, i, j-1)));
	}
	
	public static int EDMemoizatoin(char a[], char b[])
	{
		int m[][] = new int[a.length + 1][b.length +1];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < a.length +1; i++)
		{
			for(int j = 0; j < b.length + 1; j++)
			{
				if(i ==0)
					m[i][j] = j;
				else if(j ==0)
					m[i][j] = i;
				else
					m[i][j] = Math.min(m[i-1][j-1] + diff(a[i-1],b[j-1]), Math.min(m[i-1][j] + 1, m[i][j-1] + 1));
				if(m[i][j] < min)
					min = m[i][j];
			}
		}
		/*for(int i = 0; i < a.length +1; i++)
		{
			for(int j = 0; j < b.length + 1; j++)
			{
				System.out.print(m[i][j]);
			}
			System.out.println();
		}*/
		return m[a.length][b.length];
	}
	
	public static int diff(char a, char b)
	{
		if(a == b)
			return 0;
		return 1;
	}
	
	public static int ed(char a[], char b[], int i , int j)
	{
		if(i < 0 && j < 0)
			return 0;
		if(i < 0)
			return j+1;
		if(j < 0)
			return i+1;
		if(a[i] == b[j])
			return ed(a, b, i-1, j-1);
		else
			return 1+Math.min(ed(a, b, i-1, j-1), Math.min(ed(a, b, i-1, j), ed(a, b, i, j-1)));
	}
	
	public static int edMemoization(char a[], char b[])
	{
		int ed[][] = new int[a.length + 1][b.length + 1];
		for(int i = 0; i < a.length + 1; i++)
			ed[i][0] = i;
		for(int j = 0; j < b.length + 1; j++)
			ed[0][j] = j;
		for(int i = 1; i < a.length + 1; i++)
		{
			for(int j = 1; j < b.length + 1; j++)
			{
				if(a[i-1] == b[j-1])
					ed[i][j] = ed[i-1][j-1];
				else
					ed[i][j] = 1+ Math.min(ed[i-1][j-1], Math.min(ed[i-1][j], ed[i][j-1]));
			}
		}
		/*for(int i = 0; i < a.length + 1; i++)
		{
			for(int j = 0; j < b.length + 1; j++)
			{
				System.out.print(ed[i][j] + " ");
			}
			System.out.println();
		}*/
		return ed[a.length][b.length];
	}
}
