package com.careercup.facebookinterviewquestions;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "A!#A";
		String s = "a man, a plan, a canal, panama!asdad";
		System.out.println(isPalindrome(s.toCharArray(), 0, s.length() -1));
	}
	
	public static boolean isDigit(char a)
	{
		return Character.isDigit(a);
	}

	public static boolean isLetter(char a)
	{
		return Character.isLetter(a);
	}
	
	public static boolean isPalindrome(char a[], int i, int j)
	{
		if(i>=j)
			return true;
		if(!isDigit(a[i]) && !isLetter(a[i]))
			return isPalindrome(a, i+1, j);
		if(!isDigit(a[j]) && !isLetter(a[j]))
			return isPalindrome(a, i, j-1);
		if(a[i] != a[j])
			return false;
		if(a[i] == a[j])
			return isPalindrome(a, i+1,  j-1);
		else
			return false;
	}
	
}
