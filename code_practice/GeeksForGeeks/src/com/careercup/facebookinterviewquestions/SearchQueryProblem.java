package com.careercup.facebookinterviewquestions;

import java.util.HashSet;
import java.util.Set;
/*
 * http://www.careercup.com/question?id=5669407776833536
 */
public class SearchQueryProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[] = {"hazem", "ahmed", "moustafa", "fizo"};
		for (String string : s) {
			getCombination(string.toCharArray(), 0, "");
		}
		System.out.println(isFound("ahmed"));
		System.out.println(isFound("m**stafa"));
		System.out.println(isFound("fizoo"));
		System.out.println(isFound("fizd"));
		System.out.println(isFound("*****"));
		System.out.println(isFound("****"));
		System.out.println(isFound("**"));
	}
	
	public static String isFound(String s)
	{
		if(hashset.contains(s))
			return "Yes";
		return "No";
	}
	
	public static Set<String> hashset = new HashSet<String>();
	static int index = 1;
	public static void getCombination(char a[], int i, String path)
	{
		if(i>=a.length)
		{
			//System.out.println("#" + index++ + " " + path);
			hashset.add(path);
			return;
		}
		else
		{
			getCombination(a, i+1, path + a[i]);
			getCombination(a, i+1, path + "*");
		}
	}
}
