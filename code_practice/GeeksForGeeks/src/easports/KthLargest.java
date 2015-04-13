package easports;

public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,5,1,6,8,7};
		System.out.println(KthLargestElement(a, 1, 0, a.length -1));
	}
	
	public static int KthLargestElement(int a[], int k, int l, int h)
	{
		if(k <= h - l + 1)
		{
			int pos = divide(a, l, h);
			if(pos -l == k -1)
				return a[pos];
			if(pos -l > k -1)
				return KthLargestElement(a, k, l, pos -1);
			return KthLargestElement(a, k - pos + l -1, pos + 1, h);
		}
		return -1;
	}
	
	public static int divide(int a[],int l, int h)
	{
		int pivot = a[h];
		int j = l;
		for(int i = l; i<h;i++)
		{
			if(a[i]> pivot)
			{
				swap(a,i,j);
				j++;
			}
		}
		swap(a, j,h);
		return j;
	}
	
	public static void swap(int a[], int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
