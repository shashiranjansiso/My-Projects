package microsoft_interview_prep;

public class SwapWithoutTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1, b=5;
		if(b > a)
		{
			b = b-a;
			a = a + b;
			b = a - b; 
		}
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		int numzero = 0;
		System.out.println("fact of 10 " + fact(10));
		/*int n = fact(10);
		while(n%10 == 0)
		{
			numzero++;
			n/=10;
		}*/
		int n = fact(10, numzero);
		System.out.println("numzeros are " + numzero);
	}
	
	public static int fact(int n)
	{
		if(n == 1)
			return 1;
		else 
			return n*fact(n-1);
	}
	
	public static int fact(int n, int numzero)
	{ 
		if(n == 1)
			return 1;

		int fact = n * fact(n - 1, numzero);;
		if(n%10 == 0)
		{
			numzero++;
		}
		/*else if(n%5 == 0 && (fact1%2 == 0 && fact1%10 != 0))
		{
			numzero++;
		}*/
		return fact;
	}
	

}
