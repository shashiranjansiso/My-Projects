package microsoft_interview_prep;

public class BinaryConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(toBinary(10));
		int a[] = {1,2,3,2,3,1,3};
		System.out.println(oddOccurances(a, 7));
	}

	public static String toBinary(int n)
	{
		String str = new String();
		if(n == 0)
			return str;
		
		while(n/2 != 0)
		{
			str = str + (n%2);
			n/=2;
		}
		return str;
	}
	
	public static int oddOccurances(int[] a, int size)
	{
		int i;
	     int res = 0; 
	     for (i=0; i < size; i++)     
	        res = res ^ a[i];
	      
	     return res;
	}
	
}
