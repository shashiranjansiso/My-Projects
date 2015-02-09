package cracking.codinginterview.sorting;


public class MergeSort {
	//static int[] helper;
	public static void main(String[] args)
	{
		int a[] = {3,2,8,1,4};
		sort(a);
		for (int i : a) {
			System.out.println(i + "  ");
		}
	}
	
	
	public static void sort(int[] a)
	{
		int start = 0;
		int end = a.length - 1;
		int[] helper = new int[a.length];
		mergeSort(a, start, end, helper);
	}
	
	public static void mergeSort(int[] a, int start, int end, int[] helper)
	{
		if(start < end)
		{
			int mid = (start + end)/2;   //2
			mergeSort(a, start, mid, helper);
			mergeSort(a, mid + 1, end, helper);
			sort(a, start, mid, end, helper);
		}
	}
	
	public static void sort(int[] a, int start, int mid, int end,int[] helper)
	{
		for(int i = start; i<= end; i++)
			helper[i] = a[i];
		int left = start;
		int right = mid + 1;
		int current = start;
		while(left <= mid && right <= end)
		{
			if(helper[left] < helper[right])
			{
				a[current] = helper[left];
				current++;
				left++;
			}
			else
			{
				a[current] = helper[right];
				current++;
				right++;
			}
		}
		while(left <= mid)
		{
			a[current] = helper[left];
			left++;
			current++;
		}
	}
}
