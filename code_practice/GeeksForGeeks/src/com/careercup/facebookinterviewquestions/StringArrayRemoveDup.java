package com.careercup.facebookinterviewquestions;

import java.util.HashSet;
import java.util.Set;

public class StringArrayRemoveDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = {"dog", "cat", "dog", "fish"};
		String s[] = removeDup(str);
		for (String string : s) {
			System.out.println(string);
		}
	}
	
	public static String[] removeDup(String s[])
	{
		String a[] = new String[s.length];
		Set<String> set = new HashSet<String>();
		int i = -1;
		for(String str:s)
		{
			if(!set.contains(str))
			{
				i++;
				set.add(str);
				a[i] = str;
			}
		}
		return a;
	}

}
