package com.careercup.facebookinterviewquestions;
/*
 * http://www.careercup.com/page?pid=facebook-interview-questions
 * 
 */
public class Questions1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {23,5,4,7,2,11};
		System.out.println(isPossible(a, a.length -1, 0, 1000));
	}
	
	public static boolean isPossible(int a[], int index, int sum, int reqSum)
	{
		if(sum > reqSum)
			return false;
		if(index < 0)
			return false;
		if(sum == reqSum)
			return true;
		return isPossible(a, index -1, sum + a[index], reqSum) || isPossible(a, index-1, 0, reqSum);
	}

}
