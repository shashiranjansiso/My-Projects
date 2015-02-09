
public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,2,2,2,2,3};
		int start = bSearchStart(a, 0, 6, a.length, 3);
		System.out.println("start posistion is " + start);
	}
	
	public static int bSearchStart(int[] a, int l, int h, int size, int num)
	{
		int mid = l + (h - l)/2;
		if(mid == 0 && a[mid] == num)
			return mid;
		if(a[mid] == num && a[mid-1] != num)
			return mid;
		if(a[mid] > num || (a[mid] == num && a[mid-1] == num))
			return bSearchStart(a, l, mid -1, size, num);
		else
			return bSearchStart(a, mid + 1, h, size, num);
	}

}
