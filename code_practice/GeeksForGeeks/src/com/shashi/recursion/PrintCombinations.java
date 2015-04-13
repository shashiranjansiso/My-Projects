package com.shashi.recursion;

public class PrintCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		permute(s.toCharArray(), 0);
		for(int i = 1; i <= s.length(); i++)
		{
			char p[] = new char[i];
			//printCombination(s.toCharArray(), i, p, 0, 0);
		}
	}
	
	public static void printCombination(char a[], int r, char p[], int index1, int index2)
	{
		if(index1 == r)
		{
			System.out.println(p);
			return;
		}
		for(int i = index2; i <a.length; i++)
		{
			p[index1] = a[i];
			printCombination(a, r, p, index1+1, i+1);
		}
	}
	
	public static void permute(char a[], int i)
	{
		//i stands for ith position
		if(i == a.length)
		{
			System.out.println(a);
			return;
		}
		for(int j = i; j<a.length; j++)
		{
			swap(a, i, j);
			permute(a, i+1);
			swap(a, i, j);
		}
	}
	
	public static void swap(char a[], int i, int j)
	{
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	}

}
