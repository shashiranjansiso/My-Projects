package icims;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[] = {2,2,3,4,3,3,2,2,1,1,2,5};
		//int a[] = {2,0,2,-1,2,3,2};
		//System.out.println(solution(a));
		char str[] = {'1','0','1','0','1','0','1','\0'};
		System.out.println(countSubStr(str));
	}
	
	public static int countSubStr(char str[])
	{
	   int m = 0; // Count of 1's in input string
	 
	   // Travers input string and count of 1's in it
	   for (int i=0; str[i] !='\0'; i++)
	   {
	        if (str[i] == '1')
	           m++;
	   }
	 
	   // Return count of possible pairs among m 1's
	   return m*(m-1)/2;
	}
	
	public static int solution(int[] A) {
        // write your code in Java SE 8
		if(A.length == 1)
			return 1;
		if(A.length == 0)
			return 0;
		int prev = -1;
		int next = -1;
		int curr;
		int count = 0;
		for(int i = 0; i < A.length; i++)
		{
			curr = i;
			if(i+1 < A.length)
				next = i+1;
			else
				next = -1;
			
			if(next != -1 && ((A[curr] > A[next] && prev == -1) || (A[curr] < A[next] && prev == -1)))
			{
				//first element
				count++;
			}
			if(next == -1)
			{
				count++;
			}
			else
			{
				if(prev != -1 && curr != -1)
				{
					if((A[curr] > A[next] && A[curr] > A[prev]) || (A[curr] < A[next] && A[curr] < A[prev]))
					{
						count++;
					}
				}
			}
			if(i+ 1 < A.length && A[i] != A[i+1])
				prev = i;
		}
		return count;
    }
	/*
	public static int solution(int[] A) {
        // write your code in Java SE 8
		if(A.length == 1)
			return 1;
		if(A.length == 0)
			return 0;
		int prev = Integer.MIN_VALUE;
		int next = Integer.MIN_VALUE;
		int curr;
		int count = 0;
		for(int i = 0; i < A.length; i++)
		{
			curr = A[i];
			if(i+1 < A.length)
				next = A[i+1];
			else
				next = Integer.MIN_VALUE;
			
			if(next != Integer.MIN_VALUE && ((curr > next && prev == Integer.MIN_VALUE) || (curr < next && prev == Integer.MIN_VALUE)))
			{
				//first element
				System.out.println("value of i is = " + A[i]);
				count++;
			}
			if(next == Integer.MIN_VALUE)
			{
				System.out.println("value of i is = " + A[i]);
				count++;
			}
			else
			{
				if((curr > next && curr > prev) || (curr < next && curr < prev))
				{
					System.out.println("value of i is = " + A[i]);
					count++;
				}
			}
			if(i+ 1 < A.length && A[i] != A[i+1])
				prev = A[i];
		}
		return count;
    }*/

}
