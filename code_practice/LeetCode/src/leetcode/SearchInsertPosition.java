package leetcode;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,3, 5};
		System.out.println(searchInsert(a, 2));
	}
	
	public static int searchInsert(int[] A, int target) {
		if(A.length == 0)
			return 0;
		if(target <A[0])
			return 0;
		if(target > A[A.length -1])
			return A.length;
        return binarySearch(A, 0, A.length -1, target);
    }
	
	public static int binarySearch(int[] a, int l, int h, int target)
	{
		int mid = (l + h)/2;
		if(a[mid] == target)
			return mid;
		if(a[mid] < target && a[mid + 1] > target)
			return mid+1;
		if(a[mid] > target && a[mid - 1] < target)
			return mid;
		if(target > a[mid])
			return binarySearch(a, mid + 1, h, target);
		else
			return binarySearch(a, l, mid - 1, target);
			
	}

}
