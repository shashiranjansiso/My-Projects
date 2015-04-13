package com.shashi.algo;

//HORSPOOL And BOYSMOORE algorithm

public class StringMatchingHorspoolOrBoysMooreAlgorithm {
	public static void main(String[] args) {
		String s = "JIM SAW ME IN A BARBER PARLOUR";
		String p = "SAW";
		patternSearch(s, p);
	}
	
	public static boolean isMatching(String s, String p)
	{
		int m = p.length();
		int table[] = preProcessingString(p);
		int index = m-1;
		int pIndex;
		while(index < s.length())
		{
			int i = index;
			pIndex = m-1;
			while(s.charAt(i) == p.charAt(pIndex))
			{
				i--;
				pIndex--;
				if(pIndex < 0)
					return true;
			}
			index = index + table[s.charAt(index)];
		}
		return false;
	}
	
	public static void patternSearch(String text, String pat)
	{
	    int table[] = new int[256];
	    for(int i = 0; i < 256; i++)
	    {
	        table[i] = pat.length();
	    }
	    
	    for(int i = 0; i < pat.length() -1; i++)
	    {
	        table[pat.charAt(i)] = pat.length()-1-i;
	    }
	    int i = pat.length()-1;
	    while(i < text.length())
	    {
	        int start = i;
	        int j = pat.length() -1;
	        while(pat.charAt(j) == text.charAt(i))
	        {
	            j--;
	            i--;
	            if(j < 0)
	            {
	            	System.out.println(i+1);
	            	break;
	            }
	        }
	        i = start + table[text.charAt(start)];
	    }
	}
	
	public static int[] preProcessingString(String p)
	{
		int m = p.length();
		int table[] = new int[128];
		for(int i = 0; i < 128; i++)
		{
			table[i] = m;
		}
		for(int i = 0; i < p.length() -1; i++)
			table[p.charAt(i)] =m-1-i;
		return table;
	}
}
