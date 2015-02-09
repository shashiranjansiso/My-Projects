package icims;

public class program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,1};
		int b[]= {3,3};
		System.out.println(solution(a, b));
		//System.out.println(solution(a));
	}
	
	public static int solution(int[] A, int[] B) {
        // write your code in Java SE 8
		if(A.length == 0 || A.length == 0)
			return -1;
		sort(A);
		sort(B);
		int i =0, j = 0;
		while(i < A.length && j < B.length)
		{
			if(A[i] == B[j])
				return A[i];
			if(A[i] < B[j])
				i++;
			else
				j++;
		}
		return -1;
    }

	public static void sort(int[] inputArr) {
        
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        int length = inputArr.length;
        quickSort(inputArr, 0, length - 1);
    }
 
    public static void quickSort(int[] array, int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(array, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array, lowerIndex, j);
        if (i < higherIndex)
            quickSort(array, i, higherIndex);
    }
 
    public static void exchangeNumbers(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
