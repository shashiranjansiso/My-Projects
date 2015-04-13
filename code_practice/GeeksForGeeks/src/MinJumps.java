
public class MinJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(MJ(arr, 0));
	}

	public static int MJ(int a[], int i)
	{
		if(i == a.length -1)
			return 1;
		if(i >= a.length)
			return 0;
		if(a[i] == 0)
			return 0;
		int min = a.length;
		for(int j = 1; j <=a[i]; j++)
		{
			int count = MJ(a, i+j) + 1;
			if(count < min)
				min = count;
		}
		return min;
	}
	
}
