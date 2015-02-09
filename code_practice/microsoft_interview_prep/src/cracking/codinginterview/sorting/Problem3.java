package cracking.codinginterview.sorting;

public class Problem3 {
	public static void main(String[] args)
	{
		int[] a = {1,2,3,4,5,6};
		for (int i : a) {
			System.out.println("index of " + i + " is " + findIndex(a, i, 0, 5));
		}
	}

	public static int findIndex(int[] a, int num, int start, int end)
	{
		if(start > end) return -1;
		int mid = (start + end)/2;
		if(a[mid] == num)
			return mid;
		else if((a[mid] > a[end]) &&
				num <= a[end])
			return findIndex(a, num, mid + 1, end);
		else if((a[mid] < a[start]) &&
				num >= a[start])
			return findIndex(a, num, start, mid - 1);
		else if(num > a[mid])
			return findIndex(a, num, mid + 1, end);
		else
			return findIndex(a, num, start, mid - 1);
	}
}
