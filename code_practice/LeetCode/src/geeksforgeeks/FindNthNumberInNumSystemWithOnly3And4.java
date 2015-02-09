package geeksforgeeks;

public class FindNthNumberInNumSystemWithOnly3And4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = printNumSystem(15);
		System.out.println("Numbers are ...");
		for (int i : nums) {
			System.out.print(i + "   ");
		}
	}

	public static int[] printNumSystem(int n)
	{
		int arr[] = new int[n+1];
		return printNum(n, 0, arr, 0);
	}
	
	public static int[] printNum(int n, int i, int[] arr, int pow)
	{
		if(i > n -1)
			return arr;
		if(i==0)
		{
			arr[0] = 3; arr[1] = 4;
			if(n <= 2)
				return arr;
			printNum(n, 2, arr, 1);
		}
		else
		{
			int k = i;
			int start = i - (int)Math.pow(2, pow); 
			for(int j = start; j<i; j++)
			{
				arr[k] = arr[j]*10 + 3;
				k++;
				arr[k] = arr[j]*10 + 4;
				k++;
				if(k > n-1)
					return arr;
			}
			printNum(n, k, arr, pow + 1);
		}
		return arr;
	}
	
}
