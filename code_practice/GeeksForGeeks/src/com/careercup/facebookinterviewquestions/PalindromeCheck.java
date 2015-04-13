package com.careercup.facebookinterviewquestions;

public class PalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "race car";
		System.out.println(isPalindrome(s.toCharArray(), 0, s.length()-1));
	}

	public static boolean isPalindrome(char a[], int i, int j)
	{
		if(i == j)
			return true;
		if(a[i] == ' ')
			return isPalindrome(a, i+1, j);
		if(a[j] == ' ')
			return isPalindrome(a, i, j-1);
		if(j==i+1 && a[i] == a[j])
			return true;
		if(j==i+1 && a[i] != a[j])
			return false;
		if(a[i] != a[j])
			return false;
		else
			return isPalindrome(a, i+1, j-1);
	}
	
}
