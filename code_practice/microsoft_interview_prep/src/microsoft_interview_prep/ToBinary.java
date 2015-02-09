package microsoft_interview_prep;

public class ToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String binary = binary(9);
		doPrintBinary(10);
		//System.out.println("binary number is " + binary);
	}
	
	public static void doPrintBinary(int n) {
        if (n > 1) {
            doPrintBinary(n >> 1);
        }
        System.out.print(n & 1);
    }
	
	public static String binary(int n)
	{
		String str = new String();
		/*while(n>0)
		{
			if(n%2 == 0)
				str+="1";
			else
				str+="0";
			n/=2;
		}*/
		int total = 0;
		while(n > 0)
	    {
	        total = n % 2;
	        n /= 2;
	        System.out.println(total);;
	    }
		return str;
	}
	
}
