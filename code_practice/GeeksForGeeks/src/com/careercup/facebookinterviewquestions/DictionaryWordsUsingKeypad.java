package com.careercup.facebookinterviewquestions;

public class DictionaryWordsUsingKeypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "33";
		char op[] = new char[ip.length()];
		P(ip, 0, op);
	}
	public static int ic  =0;

	public static void P(String input, int index, char op[])
	{
		if(index == input.length())
		{
			ic++;
			System.out.print("#" + ic + "  ");
			for(int i =0; i < index; i++)
			{
				System.out.print(op[i]);
			}
			System.out.println();
			return;
		}
		String d = decode(input.charAt(index));
		for(int i = 0; i < d.length(); i++)
		{
			op[index] = d.charAt(i);
			P(input, index+1, op);
		}
	}
	
	public static String decode(char c)
	{
		String str = "";
		switch (c) {
		case '3':
			str = "def";
			break;
		case '2':
			str = "abc";
		default:
			break;
		}
		return str;
	}
	
}
