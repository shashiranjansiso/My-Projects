package com.geeksforgeeks.array;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		TOH(2, 'A', 'C', 'B');
	}
	
	public static void TOH(int n, char from, char to, char aux)
	{
		if(n==1)
		{
			System.out.println("move " +  n + " from " +  from + " to " +  to );
			return;
		}
		TOH(n-1, from, aux, to);
		System.out.println("move " +  n + " from " +  from + " to " +  to);
		TOH(n-1, aux, to, from);
	}

}
