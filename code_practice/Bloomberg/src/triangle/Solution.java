package triangle;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int numTC = in.nextInt();
		int[][] tcnums = new int[numTC][3];
		for(int i = 0; i<numTC; i++)
		{
			tcnums[i][0] = in.nextInt();
			tcnums[i][1] = in.nextInt();
			tcnums[i][2] = in.nextInt();
		}
		
		for(int i = 0; i<numTC; i++)
		{
			int a = tcnums[i][0];
			int b = tcnums[i][1];
			int c = tcnums[i][2];
			if(a+b < c || a+c < b || b+c < a)
			{
				System.out.println("None of these");
			}
			else if(a != b && a != c && c != a)
				System.out.println("None of these");
			else if( a == b && a == c)
				System.out.println("Equilateral");
			else
				System.out.println("Isosceles");		
		}
		
	}
	
	
}
