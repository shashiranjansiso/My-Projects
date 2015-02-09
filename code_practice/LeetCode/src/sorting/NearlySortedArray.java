package sorting;

public class NearlySortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 6, 3, 12, 56, 8};
		int k = 3;
		sortK(arr, k);
	}
	
	public static void sortK(int[] arr, int k)
	{
		
		MinHeap h = createAndBuildMinHeap(arr, k + 1);
			
	}
	
	public static MinHeap createAndBuildMinHeap(int[] arr, int k)
	{
		MinHeap h = new MinHeap(arr, k);
		int end = (k-2)/2;
		for(int i = end ; i>=0;i--)
		{
			heapify(h, i);
		}
		return h;
	}
	
	public static void heapify(MinHeap h, int idx)
	{
		int smallest = idx;
		int left = (idx<<1) + 1;
		int right = (idx + 1)<<1;
		if(left < h.size && h.arr[left] <h.arr[smallest])
			smallest = left;
		if(right < h.size && h.arr[right] < h.arr[smallest])
			smallest = right;
		if(idx != smallest)
		{
			swap(h.arr, smallest, idx);
			heapify(h, smallest);
		}
	}
	
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static class MinHeap
	{
		int[] arr;
		int size;
		public MinHeap(int[] arr, int size) {
			// TODO Auto-generated constructor stub
			this.size = size;
			this.arr = new int[size];
			for(int i =0; i<size; i++)
				this.arr[i] = arr[i];
		}
	}

}
