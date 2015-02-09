package cracking.codinginterview.sorting;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = sortChars(new String("cba"));
		System.out.println(str);
	}
	
	public static String sortChars(String str)
	{
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	public void sort(String[] array)
	{
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		for(String s:array)
		{
			String key = sortChars(s);
			if(!hash.contains(key))
				hash.put(key, new LinkedList<String>());
			LinkedList<String> list = hash.get(key);
			list.push(s);
		}
	}
	
}
