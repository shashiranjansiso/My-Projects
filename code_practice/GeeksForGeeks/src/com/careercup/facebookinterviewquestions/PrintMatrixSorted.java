package com.careercup.facebookinterviewquestions;
/*
 * 
 * http://www.careercup.com/page?pid=facebook-interview-questions
 */
public class PrintMatrixSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m[][] = {{20, 40, 80}, 
					{5, 60, 90}, 
					{45, 50, 55}};
		printSorted(m);
	}

	public static void printSorted(int m[][])
	{
		boolean flag = false;
		int c[] =new int[m[0].length];
		for(int i = 0; i < m[0].length; i++)
			c[i] = 0;
		while(!flag)
		{
			int min = findMin(m, c);
			System.out.print(min + " ");
			flag = checkIfCompleted(m,c);
		}
	}
	
	public static int findMin(int m[][], int c[])
	{
		int min = 2000;
		int minrow = -1;
		for(int i = 0; i < m.length; i++)
		{
			if(c[i] != m[0].length)
			{
				if(m[i][c[i]] < min)
				{
					minrow = i;
					min = m[i][c[i]];
				}
			}
		}
		c[minrow]++;
		return min;
	}
	
	public static boolean checkIfCompleted(int m[][], int c[])
	{
		int count = 0;
		for(int i = 0; i < m.length; i++)
		{
			if(c[i] == m[0].length)
				count++;
		}
		if(count == m.length)
			return true;
		return false;
	}
	
}
