package google.codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class T9Spelling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, String> m = createMap();
		String filename = "/Users/shashi/Desktop/shashi/course_material/github/My-Projects/code_practice/GeeksForGeeks/input/T9Spelling/C-large-practice.in";
		Input2 ip[] = readInput(filename);
		int i = 0;
		for (Input2 input : ip) {
			System.out.print("Case #" + (i+1) + ": ");
			i++;
			decode(input.text, m);
		}
		//decode("hello world", m);
	}

	public static void decode(String ip, HashMap<Character, String> m)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for(int i = 0; i <ip.length(); i++)
		{
			String d = m.get(ip.charAt(i));
			char f = d.charAt(0);
			char l = 0;
			if(sb.length() > 0)
				l = sb.charAt(sb.length() -1);
			if(f == l)
			{
				sb.append(" ");
			}
			sb.append(d);
		}
		System.out.println(sb.toString());
	}
	
	public static HashMap<Character, String> createMap()
	{
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('a', "2");
		map.put('b', "22");
		map.put('c', "222");
		
		map.put('d', "3");
		map.put('e', "33");
		map.put('f', "333");
		
		map.put('g', "4");
		map.put('h', "44");
		map.put('i', "444");
		
		map.put('j', "5");
		map.put('k', "55");
		map.put('l', "555");
		
		map.put('m', "6");
		map.put('n', "66");
		map.put('o', "666");
		
		map.put('p', "7");
		map.put('q', "77");
		map.put('r', "777");
		map.put('s', "7777");
		
		map.put('t', "8");
		map.put('u', "88");
		map.put('v', "888");
	
		map.put('w', "9");
		map.put('x', "99");
		map.put('y', "999");
		map.put('z', "9999");

		map.put(' ', "0");
		
		return map;
	}
	
	public static Input2[] readInput(String filename)
	{
		BufferedReader br = null;
		Input2 ip[] = null;
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(filename));
 
			sCurrentLine = br.readLine();
			int tcs = Integer.parseInt(sCurrentLine);
			ip = new Input2[tcs];
			for(int i = 0; i < tcs; i++)
			{
				sCurrentLine = br.readLine();
				Input2 input = new Input2(sCurrentLine);
				ip[i] = input;
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return ip;
	}
	
}

class Input2
{
	String text;
	public Input2(String txt) {
		// TODO Auto-generated constructor stub
		this.text = txt;
	}
}
