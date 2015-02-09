package cracking.codinginterview.mathematicsandprobability;

public class Primes {
	
	public static void main(String[] args)
	{
		System.out.println(isPrime(101));
	}
	
	public static boolean isPrime(int n)
	{
		if(n<2)
			return false;
		else
		{
			int sqrt = (int) Math.sqrt(n);
			for(int i = 2; i <=sqrt; i++)
			{
				if(n%i == 0)
					return false;
			}
		}
		return true;
	}
	
	
	
}
