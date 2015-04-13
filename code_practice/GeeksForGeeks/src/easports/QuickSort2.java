package easports;

public class QuickSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {7,3,9,2,5};
		sort(a, 0, a.length -1);
		printArray(a);
	}
	
	public static void printArray(int[] a)
	{
		for(int i = 0; i<a.length; i++)
			System.out.print(a[i] + "  ");
		System.out.println();
	}
	
	public static void sort(int[] a, int l, int h)
	{
		if(l < h)
		{
			int p = partition(a, l, h);
			sort(a, l, p -1);
			sort(a, p+1,h);
		}
	}
	
	public static int partition(int a[], int l, int h)
	{
		int pivot = a[h];
		//int i = l; int j = l;
		int j = l;
		for(int i = l; i < h; i++)
		{
			if(a[i] > pivot)
			{
				//
				swap(a, i, j);
				j++;
			}		
		}
		swap(a,j,h);
		return j;
	}
	
	public static void swap(int a[], int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
