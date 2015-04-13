package easports;

public class QuickSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,5,1,6,8,7};
		//int a[] = {12,3,5,7,4,19,26};
		quickSort(a, 0, a.length -1);
		printArray(a);
	}
	
	public static void printArray(int[] a)
	{
		for(int i = 0; i<a.length; i++)
			System.out.print(a[i] + "  ");
		System.out.println();
	}

	public static void quickSort(int a[], int l, int h)
	{
		if(l>h)
			return;
		int mid = l + (h -l)/2;
		int pivot = a[mid];
		int i = l;
		int j = h;
		while(i<j)
		{
			while(a[i] < pivot)
				i++;
			while(a[j] > pivot)
				j--;
			if(i < j)
			{
				swap(a, i, j);
				i++;j--;
			}
		}
		if(a[j] > a[mid])
			swap(a, j,mid);
		quickSort(a, j+1, h);
		quickSort(a, l, j -1);
	}
	
	public static void swap(int a[], int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
