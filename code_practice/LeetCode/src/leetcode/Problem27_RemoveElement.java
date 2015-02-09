package leetcode;

public class Problem27_RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {4,3,2,1,2,3,6};
		System.out.println(removeElement(a, 2));
	}
	
	public static int removeElement(int[] A, int elem) {
		int replace = 0;
		for(int i = 0; i < A.length; i++)
		{
			if(A[i] != elem)
			{
				A[replace] = A[i];
				replace++;
			}
		}
        return replace;
    }
	
	
}
