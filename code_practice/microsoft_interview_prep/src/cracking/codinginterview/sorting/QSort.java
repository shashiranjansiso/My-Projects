package cracking.codinginterview.sorting;

public class QSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {5, 10, 3, 7, 1, 8,2,4};
		//sort(a);
		int index = partition(a, 0, 7);
		System.out.println("partition index is " + index);
		for (int i : a) {
			System.out.println(i + "  ");
		}
	}
	
	/*public static void sort(int[] a)
	{
		int pIndex = partition(a, start, end)
	}*/
	
	public static int partition(int[] a, int start, int end)
	{
		int pivot = a[(start + end)/2];
		int low = start;
		int high = end;
		while(low <= high)
		{
			while(a[low] < pivot)
				low++;
			while(a[high] > pivot)
				high--;
			if(low <= high)
			{
				swap(a,low, high);
				low++;
				high--;
			}
		}
		return low;
	}
	
	public static void swap(int[] a, int i1, int i2)
	{
		int temp = a[i1];
		a[i1] = a[i2];
		a[i2] = temp;
	}

}
