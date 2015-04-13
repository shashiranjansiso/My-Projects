package com.shashi.algo;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc";
		//char b[] = new char[a.length()];
		//perm(a.toCharArray(), b, 0);
		permutation(a.toCharArray(), 0);
	}
	static int count = 1;
	public static void perm(char a[], char b[], int pos)
	{
		if(pos == a.length)
		{
			System.out.print("#" + count++ + "   ");
			System.out.println(b);
			return;
		}
		for(int i =0; i <a.length; i++)
		{
			if(!isContains(b, a[i]))
			{
				b[pos] = a[i];
				perm(a, b, pos+1);
			}
			b[pos] = ' ';
		}
	}
	
	public static boolean isContains(char b[], char a)
	{
		for(int i =0; i < b.length; i++)
		{
			if(b[i] == a)
				return true;
		}
		return false;
	}
	
	public static void permutation(char a[], int index)
	{
		if(index == a.length)
		{
			System.out.println(a);
			return;
		}
		for(int i = index; i < a.length; i++)
		{
			swap(a, index, i);
			permutation(a, index + 1);
			swap(a, index, i);
		}
	}
	
	public static void swap(char a[], int i, int j)
	{
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
