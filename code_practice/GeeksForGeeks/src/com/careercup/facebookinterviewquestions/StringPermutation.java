package com.careercup.facebookinterviewquestions;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc";
		permutation(a.toCharArray(), 0);
	}

	public static void permutation(char a[], int index)
	{
		if(index >= a.length)
		{
			printArray(a);
			return;
		}
		
		for(int i = index; i < a.length; i++)
		{
			swap(a, i, index);
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
	public static void printArray(char a[])
	{
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]);
		System.out.println();
	}
}
