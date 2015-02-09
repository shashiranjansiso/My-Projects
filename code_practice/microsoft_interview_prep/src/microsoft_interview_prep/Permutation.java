package microsoft_interview_prep;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPermutation("", "a");
	}
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	public static void printPermutation(String pre, String str)
	{
		int n = str.length();
		if(n == 0)
			System.out.println(pre);
		else
		{
			for(int i = 0; i< n; i++)
				permutation(pre + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

}
