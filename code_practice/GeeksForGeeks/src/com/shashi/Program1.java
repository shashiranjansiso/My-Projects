package com.shashi;
/*
http://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/

	*/

/*
 * 
 * Rearrange array in alternating positive & negative items with O(1) extra space
 */

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int a[] = {1, 2, -1, -4, -2, 4};
		rearrange(a);
		printArray(a);*/
		int ar1[] = {1, 5, 10, 20, 40, 80};
	    int ar2[] = {6, 7, 20, 80, 100};
	    int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
	    printCommon(ar1,ar2,ar3);
	}
	
	public static void printArray(int a[])
	{
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
	
	public static void printCommon(int a[], int b[], int c[])
	{
		int n1 = a.length;
		int n2 = b.length;
		int n3 = c.length;
		int i = 0, j= 0, k = 0;
		while(i < n1 && j < n2 && k < n3)
		{
			if((a[i] == b[j]) && (a[i] == c[k]))
			{
				System.out.println(a[i]);
				
				i++;
				if(i == n1)
					break;
			}
			int max = Math.max(a[i], Math.max(b[j], c[k]));
			while(i < n1 && a[i] < max)
				i++;
			while(j < n2 && b[j] < max)
				j++;
			while(k < n3 && c[k] < max)
				k++;
		}
	}
	
	public static void rearrange(int[] arr)
	{
		int n = arr.length;
		int pos = 0, neg;
		while(pos < n)
		{
			/*while(pos < n && (arr[pos] > 0) && isEven(pos))*/
			while(pos < n && arr[pos] > 0 && pos %2 == 0)
				pos++;
			neg = pos + 1;
			while(neg < n && arr[neg] > 0 && pos %2 == 1)
			{
				neg++;
			}
			//put arr[neg] at a[pos] and shift number forward
			if(neg < n && pos < n)
			{
				int temp = arr[neg];
				for(int i = neg;i > pos; i--)
					arr[i] = arr[i-1];
				arr[pos] = temp;
			}
			pos++;
		}
	}
	
	public static boolean isEven(int no)
	{
		if(no % 2 == 0)
			return true;
		return false;
	}

}
