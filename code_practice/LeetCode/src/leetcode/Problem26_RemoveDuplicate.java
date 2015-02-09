package leetcode;

public class Problem26_RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,1,2};
		System.out.println(removeDuplicates(a));
	}

	public static int removeDuplicates(int[] A) {
		int r = 1;
		for(int i = 1; i < A.length; i++)
		{
			if(A[i] != A[i -1])
				A[r++] = A[i];
		}
		return r;
    }
	
}
