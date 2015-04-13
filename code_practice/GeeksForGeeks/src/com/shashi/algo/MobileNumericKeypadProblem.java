package com.shashi.algo;

public class MobileNumericKeypadProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char kp[][] ={	{'1','2','3'},
						{'4','5','6'},
						{'7','8','9'},	
						{'*', '0','#'} };
		System.out.println(count(kp, 20));
	}
	
	static int r[] = {0,0,0,-1,1};
	static int c[] = {0,1,-1,0,0};
	
	public static int count(char kp[][], int n)
	{
		if(n == 1)
			return 10;
		int count = 0;
		for(int i = 0; i<4;i++)
		{
			for(int j =0;j<3;j++)
			{
				if(kp[i][j] != '*' && kp[i][j] != '#')
				{
					//System.out.println("for #" + kp[i][j]);
					count = count + countUtil(kp, i, j, n, kp[i][j] + "");
				}
			}
		}
		return count;
	}
	
	public static int countUtil(char kp[][], int row, int col, int n, String p)
	{
		int count = 0;
		if(n ==1)
		{
			//System.out.println(p);
			return 1;
		}
		else
		{
			for(int i =0; i < 5; i++)
			{
				if(isSafe(kp, row + r[i], col + c[i]))
					count = count + countUtil(kp, row + r[i], col + c[i], n-1, p + "" + kp[row + r[i]][col + c[i]]);
			}
		}
		return count;
	}
	
	public static boolean isSafe(char kp[][], int r, int c)
	{
		//System.out.println("row# " + r + " col# " + c);
		if(r > 3 || c > 2 || r <0 || c < 0)
			return false;
		if(kp[r][c] == '*' || kp[r][c] == '#')
			return false;
		return true;
	}

}
