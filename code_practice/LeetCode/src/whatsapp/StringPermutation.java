package whatsapp;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*char a[] = {'a','b','c'};
		char b[] = new char[5];
		printPermutation(a, 0, a.length, b, 0);*/
		/*int k = 4,n = 5;
		int[] b = new int[k];
		print(n, 1, k, 0, b);*/
		printArray(2);
	}
	
	public static void printArray(int n)
	{
		int a[] = new int[2*n];
		for(int i = 0 ; i<2*n; i++)
		{
			a[i] = -1;
		}
		if(!fillArray(a, n, n))
		{
			System.out.println("no such array possible");
			return;
		}
		for(int i = 0 ; i<2*n; i++)
		{
			System.out.print(a[i] + "    ");
		}
		System.out.println();
	}
	
	public static boolean isSafe(int a[], int i, int j)
	{
		if(i < 0 || j >= a.length)
			return false;
		if(a[i] != -1 || a[j] != -1)
			return false;
		return true;
	}
	
	public static boolean fillArray(int a[], int n, int m)
	{
		if(m == 0)
			return true;
		for(int i = 0; i<2*n; i++)
		{
			if(isSafe(a, i, i + m + 1))
			{
				a[i] = a[i + m + 1] = m;
				if(fillArray(a, n, m -1))
					return true;
				a[i] = a[i + m + 1] = -1;
			}
		}
		return false;
		
	}
	
	public static void printPermutation(char[] a, int index1, int len, char[] b, int index2)
	{
		if(index2 >= len || index1 >= len)
			return;
		for(int i = index1; i < len; i++)
		{
			b[index2] = a[i];
			for(int j = 0; j<=index2; j++)
				System.out.print(b[j]);
			System.out.println();
			printPermutation(a, i	+1, len, b, index2 + 1);
		}
	}
	
	public static void print(int n, int i1,int k, int i2,int[] b)
	{
		if(k>n)
		{
			System.out.println("k is greater than n");
			return;
		}
		if(i2>=k)
		{
			for(int i = 0; i<k;i++){
				System.out.print(b[i]);
			}
			System.out.println();
			return;
		}
		for(int i = i1; i <= n; i++)
		{
			b[i2] = i;
			print(n, i+1, k, i2+1, b);
		}
		
	}
}
