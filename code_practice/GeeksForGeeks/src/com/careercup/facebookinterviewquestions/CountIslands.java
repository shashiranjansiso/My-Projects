package com.careercup.facebookinterviewquestions;

public class CountIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char mat[][] =  {{'O', 'O', 'O'},
						{'X', 'X', 'O'},
						{'X', 'X', 'O'},
						{'O', 'O', 'X'},
						{'O', 'O', 'X'},
						{'X', 'X', 'O'}
					};
		System.out.println(count(mat, 6, 3));
	}
	
	public static int count(char m[][], int n1, int n2)
	{
		char s[][] = new char[n1+1][n2+1];
		int c = 0;
		for(int i = 0; i < n1 +1; i++)
		{
			for(int j = 0 ; j < n2 + 1; j++)
			{
				if(i ==0 || j == 0)
				{
					s[i][j] = 'O';
				}
				else
				{
					s[i][j] = m[i-1][j-1];
					if(isTopLeft(s, i, j))
					{
						//System.out.println("i is " + i + "  j is " + j);
						c++;
					}
				}
			}
		}
		return c;
	}
	
	public static boolean isTopLeft(char m[][], int i, int j)
	{
		if(m[i-1][j] == 'O' && m[i][j-1] == 'O' && m[i][j] == 'X')
			return true;
		return false;
	}

}
