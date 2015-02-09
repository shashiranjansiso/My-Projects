package cracking.codinginterview.sorting;

public class Problem6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,2,3,4,5},
					{6,7,8,9,10},
					{11,12,13,14,15},
					{16,17,18,19,20},
					{21,22,23,24,25}};
		int rowIndex = getRowIndex(a, 8, 0, 4, 4);
		System.out.println(rowIndex);
	}

	public static int getRowIndex(int[][] a, int num, int l, int h,int max)
	{
		if(l>h) return -1;
		int mid = (l + h)/2;
		if(num >= a[mid][0] && num <=a[mid][max])
			return mid;
		else if(num > a[mid][0])
			return getRowIndex(a, num, mid + 1, h, max);
		else
			return getRowIndex(a, num, l, mid - 1, max);
	}
	
}
