package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class KeypadMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMapping(10);
	}
	
	public static void printMapping(int num)
	{
		List<Character[]> codes = new ArrayList<Character[]>();
		Character a[] = {'a','b','c'};
		codes.add(a);
		Character b[] = {'d','e', 'f'};
		codes.add(b);
		Character c[] = {'g','h','i'};
		codes.add(c);
		char[] d = new char[codes.size()];
		print(codes, 0, d);
	}

	public static void print(List<Character[]> codes, int index, char[] b)
	{
		if(index == codes.size())
		{
			for (char c : b) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		Character[] s = codes.get(index);
		for (Character c : s) {
			b[index] = c;
			print(codes, index + 1, b);
		}
	}
}
