
public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(6));
	}
	
	public static int fib(int n)
	{
		if(n <= 1)
			return n;
		return fib(n-1)+fib(n-2);
	}
	public static int fibDynamic(int n)
	{
	  /* Declare an array to store fibonacci numbers. */
	  int f[] = new int[n+1];
	  int i;
	 
	  /* 0th and 1st number of the series are 0 and 1*/
	  f[0] = 0;
	  f[1] = 1;
	 
	  for (i = 2; i <= n; i++)
	  {
	      /* Add the previous 2 numbers in the series
	         and store it */
	      f[i] = f[i-1] + f[i-2];
	  }
	 
	  return f[n];
	}
}
