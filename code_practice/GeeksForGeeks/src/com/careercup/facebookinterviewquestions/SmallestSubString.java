package com.careercup.facebookinterviewquestions;

public class SmallestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char set[] = {'a','b', 'c'};
		String str = "this is a test string";
		String str2 = "tist";
		System.out.println(minLen(str, 0, str.length() -1, str2.toCharArray()).path);
	}
	
	
	
	public static Tuple minLen(String str, int i, int j, char set[])
	{
		if(i > j)
			return new Tuple(Integer.MAX_VALUE, null);
		String subStr = str.substring(i, j+1);
		Tuple tp1 = new Tuple();
		tp1.len = Integer.MAX_VALUE;
		if(contains(subStr, set))
		{
			System.out.println(subStr);
			tp1.len = subStr.length();
			tp1.path = subStr;
		}
		Tuple tp2 = minLen(str, i+1, j-1, set);
		Tuple tp3 = minLen(str, i+1, j, set);
		Tuple tp4 = minLen(str, i, j-1, set);
		return minTuple(tp1, tp2, tp3, tp4);
	}
	
	public static Tuple minTuple(Tuple tp1, Tuple tp2, Tuple tp3, Tuple tp4)
	{
		Tuple minT;
		if(tp1.len < tp2.len)
			minT = tp1;
		else
			minT = tp2;
		if(tp3.len < minT.len)
			minT = tp3;
		if(tp4.len < minT.len)
			minT = tp4;
		return minT;
	}
	
	public static boolean contains(String subStr, char set[])
	{
		if(subStr.equals("this"))
			System.out.println(subStr);
		for(int i = 0; i < set.length; i++)
		{
			if(!subStr.contains(set[i] + ""))
				return false;
		}
		return true;
	}

}
class Tuple
{
	public int len;
	public String path;
	public Tuple(int len, String path) {
		// TODO Auto-generated constructor stub
		this.len = len;
		this.path = path;
	}
	public Tuple() {
		// TODO Auto-generated constructor stub
	}
}
