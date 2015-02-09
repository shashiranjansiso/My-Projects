package geeksforgeeks;


public class PermutationOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4};
		int b[] = new int[4];
		printAllPermutation(a, b, 0);
	}
	
	public static void printAllPermutation(int[] a,int[] b, int index)
	{
		if(index == a.length)
		{
			System.out.println("permutation of array");
			for (int i : b) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
		else
		{
			
			for(int i = 0; i < a.length; i++)
			{
				boolean found = false;
				for(int j =0; j<index; j++)
				{
					if(a[i] == b[j])
					{
						found = true;
						
					}
				}
				if(!found)
				{
					b[index] = a[i];
					printAllPermutation(a, b, index + 1);
				}
				//b[index] = a[i];
				
			}
		}
	}
	
	public static void print(int[] a, int start, int[] b, int index, int r)
	{
		if(index == r)
		{
			System.out.println("permutation of array");
			for (int i : b) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
		else
		{
			for(int i = start; i < a.length - r + index+1; i++)
			{
				b[index] = a[i];
				print(a, i + 1, b, index + 1, r);
			}
		}
	}

	
	
}
