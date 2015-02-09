
public class StrMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = /*"AABAACAADAABAAABAA"*/	/*"THIS IS A TEST TEXT"*/	"AAAAAAAAAAAAAAAAAB";
		String pat = /*"AABA"*/ /*"TEST"*/	"AAAAB";
		search(txt, pat);
	}

	public static void search(String str, String match)
	{
		int size1 = str.length(); //18
		int size2 = match.length();	//4
		int start = 0;
		for(int i=0; i<(size1 - size2) + 1; i++)
		{
			if(str.charAt(i) == match.charAt(0))
			{
				start = i;	
				int k = 1;
				for(k = 1; k < size2; k++)
				{
					if(str.charAt(i+k) != match.charAt(k))
						break;
				}
				if(k == size2)
					System.out.println(start + "  ");
			}	
		}
	}
}
