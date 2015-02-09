package leetcode;

import java.util.HashMap;

public class Problem3_LongestSubStringWoRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("ababcdeabcbb"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0)
			return 0;
		char[] a = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(a[0], 0);
        int start = 0, end = 0, len = 1, diff = 1;
        for(int i = 1; i < a.length; i++)
        {
        	end = i;
        	if(map.get(a[i]) != null)
        	{
        		start = map.get(a[i]) + 1;
        	}
        	map.put(a[i], i);
        	diff = end - start + 1;
        	if(diff > len)
        		len = diff;
        }
        return len;
    }

}
