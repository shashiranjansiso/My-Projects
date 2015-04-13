package com.shashi.algo;

import java.util.HashMap;

public class CountPossibleDecodings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1123";
				
		HashMap<String, String> m = createMap();
		System.out.println("possible decoings   " +  possible_decoding(str.toCharArray(), str.length() -1, "", m));
	}

	public static int possible_decoding(char str[], int n, String path, HashMap<String, String> m)
	{
	    if(n == 0 || n < 0)
	    {
	    	if(n ==0)
	    		path += m.get(str[n] + "");
	    	String rev = "";
	    	for ( int i = path.length() - 1 ; i >= 0 ; i-- )
	    		rev = rev + path.charAt(i);
	    	System.out.println(rev);
	    	return 1;
	    }
	    int count = possible_decoding(str, n-1, path + m.get(str[n] + ""), m);
	    if(str[n] < '7' && str[n-1] < '3')
	    {
	        count += possible_decoding(str, n-2, path + m.get("" + str[n-1]+ "" +str[n]),m);
	    }    
	    return count;
	}
	
	public static HashMap<String, String> createMap()
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "A");
		map.put("2", "B");
		map.put("3", "C");
		map.put("4", "D");
		map.put("5", "E");
		map.put("6", "F");
		map.put("7", "G");
		map.put("8", "H");
		map.put("9", "I");
		map.put("10", "J");
		
		map.put("11", "K");
		map.put("12", "L");
		map.put("13", "M");
		map.put("14", "N");
		map.put("15", "O");
		map.put("16", "P");
		map.put("17", "Q");
		map.put("18", "R");
		map.put("19", "S");
		map.put("20", "T");
		
		map.put("21", "U");
		map.put("22", "V");
		map.put("23", "W");
		map.put("24", "X");
		map.put("25", "Y");
		map.put("26", "Z");
		
		return map;
	}
	
}
