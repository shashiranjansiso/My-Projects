package com.careercup.facebookinterviewquestions;
/*
 * http://www.careercup.com/page?pid=software-engineer-intern-interview-questions
 * 
 */
public class ThreeSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-3, 10, -2, 4};
		System.out.println(S(a, a.length -1, 0, 0, 0));
		/*int arr[] =  {1, 3, 6, 10, 11, 15};
		System.out.println(find(arr));
*/	}
	
	public static boolean S(int a[], int index, int c, int sum, int k)
	{
		if(c == 3 && sum == k)
			return true;
		if(c>3 || index < 0)
			return false;
		return S(a, index, c+1, sum+a[index], k) ||  S(a, index-1, c, sum, k);
	}

	public static int find(int arr[])
	{
		int res = 1;

		for(int i =0; i < arr.length; i++)
		{
		    if(res < arr[i])
		        return res;
		    res = res + arr[i];
		}
		return -1;
	}
	
}
