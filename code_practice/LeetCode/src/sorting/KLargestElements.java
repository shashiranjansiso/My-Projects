package sorting;

public class KLargestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 23, 12, 9, 30, 2, 50};
		int k = 6;
		MinHeap heap = findKLargestElements(arr, k);
		System.out.println("K Largest elements are : ");
		for(int i = 0; i< k; i++)
		{
			System.out.println(heap.arr[i]);
		}
	}
	
	public static MinHeap findKLargestElements(int[] arr, int k)
	{
		MinHeap heap = createAndBuildMinHeap(arr, k);
		for(int i = k; i<arr.length; i++)
		{
			if(arr[i] > heap.arr[0])
			{
				heap.arr[0] = arr[i];
				heapify(heap, 0);
			}
		}
		return heap;
	}
	
	public static MinHeap createAndBuildMinHeap(int[] arr, int k)
	{
		MinHeap heap = new MinHeap(arr, k);
		int end = (heap.size - 2)/2;
		for(int i = end; i>=0; i--)
		{
			heapify(heap, i);
		}
		return heap;
	}
	
	public static void heapify(MinHeap heap, int idx)
	{
		int smallest = idx;
		int left = (idx<<1) + 1;
		int right = (idx+1)<<1;
		if(left<heap.size && heap.arr[left] < heap.arr[smallest])
			smallest = left;
		if(right < heap.size && heap.arr[right] < heap.arr[smallest])
			smallest = right;
		if(smallest != idx)
		{
			swap(heap.arr, idx, smallest);
			heapify(heap, smallest);
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
			this.arr = new int[size];
			for(int i = 0; i<size; i++)
				this.arr[i] = arr[i];
			this.size = size;
		}
	}

}
