package com.shashi;

import java.util.Scanner;

public class FindElementInPivotedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//int a[] = {1,2,3,4,5,6,7};
		//int a[] = {7,6,5,4,3,2,1};
		//int a[] = {7,1,2,3,4,5,6};
		//int a[] = {6,7,1,2,3,4,5};
		//int a[] = {5,6,7,1,2,3,4};
		//int a[] = {4,5,6,7,1,2,3};
		//int a[] = {3,4,5,6,7,1,2};
		int a[] = {2,3,4,5,6,7,1};
		//System.out.println(a[findPivot(a, 0, a.length -1)]);
		int pivot = findPivot(a, 0, a.length -1);
		
		while(true)
		{
			System.out.println("Enter no to search in array");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			if(n == a[pivot])
				System.out.println(pivot);
			else
			{
				if(n < a[pivot] || (pivot == 0 && n > a[a.length -1]) || (n > a[pivot -1]))
					System.out.println("number if not present in array");
				else if(n > a[pivot] && n < a[a.length -1])
					System.out.println(findElement(a, pivot + 1, a.length -1, n));
				else
					System.out.println(findElement(a, 0, pivot -1, n));
			}
		}
				
	}
	
	public static int findElement(int a[], int l, int h, int num)
	{
		if(l >h)
			return -1;
		int mid = l + (h-l)/2;
		if(a[mid] == num)
			return mid;
		if(num > a[mid])
			return findElement(a, mid +1 , h, num);
		else
			return findElement(a, l, mid -1, num);
	}
	
	public static int findPivot(int a[], int l, int h)
	{
		int mid = l + (h-l)/2;
		if(mid == h || mid ==l)
			return mid;
		if(a[mid] < a[mid + 1] &&
				a[mid] < a[mid -1])
			return mid;
		if(a[mid] < a[h] && a[mid] < a[mid + 1])   // right side is sorted find on the left side
			return findPivot(a, l, mid -1);
		else
			return findPivot(a, mid + 1, h);
	}

}
