import java.util.HashSet;


public class RemoveDuplicateFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bananas";
		char a[] = removeDup(s.toCharArray());
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}

	public static char[] removeDup(char[] a)
	{
		HashSet<Character> s = new HashSet<Character>();
		int shift = 0;
		for(int i = 0; i < a.length; i++)
		{
			if(s.contains(a[i]))
				shift++;
			else
			{
				s.add(a[i]);
				a[i-shift] = a[i];
			}
		}
		for(int i = a.length -shift; i < a.length; i++)
		{
			a[i] = ' ';
		}
		return a;
	}
	
}
