package cracking.codinginterview.sorting;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[30];
		a[0] = 1;
		a[1] = 3;
		a[2] = 5;
		a[3] = 7;
		a[4] = 9;
		
		int[] b = new int[]{2,4,6,8};
		//a = {1,3,5,7,9};
		//a[30] = 10;
		merge(a, 5, b, 4);
		for (int i = 0; i < 9; i++) {
			System.out.println(a[i]);
		}
		//System.out.println(a);
	}
	
	public static void merge(int[] a, int size1, int[] b, int size2)
	{
		int end = size1 + size2 - 1;
		int s1 = size1 - 1;
		int s2 = size2 - 1;
		while(s2>=0)
		{
			if(a[s1] > b[s2])
				a[end--] = a[s1--];
			else
				a[end--] = b[s2--];
		}
		System.out.println(end);
	}
}
