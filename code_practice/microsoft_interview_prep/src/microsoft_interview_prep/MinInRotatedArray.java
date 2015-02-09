package microsoft_interview_prep;

public class MinInRotatedArray {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6,7};
		System.out.println("min no is: " + findMin(a, 0, a.length - 1));
	}
	
	public static int findMin(int a[], int start, int end)
	{
		int mid = (start + end) / 2;
		if(mid == 0)
				return a[mid];
		if(a[mid] < a[mid-1])
			return a[mid];
		if(a[mid] > a[end])
			return findMin(a, mid + 1, end);
		else 
			return findMin(a, start, mid - 1);
	}

}
