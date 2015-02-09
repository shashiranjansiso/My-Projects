package sorting;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 11, 13, 5, 6, 7};
		MaxHeap heap = heapSort(arr);
		System.out.println("Sorted Array is:");
		for(int i = 0; i<heap.arr.length; i++)
			System.out.println(heap.arr[i]);
	}
	
	public static MaxHeap heapSort(int[] arr)
	{
		MaxHeap heap = createAndBuildHeap(arr);
		while(heap.size > 1)
		{
			swap(heap.arr, 0, heap.size -1);
			heap.size--;
			heapify(heap, 0);
		}
		return heap;
	}

	public static MaxHeap createAndBuildHeap(int[] arr)
	{
		MaxHeap heap = new MaxHeap();
		heap.size = arr.length;
		heap.arr = arr;
		int end = (arr.length -2)/2;
		for(int i = end; i >= 0; i--)
		{
			heapify(heap, i);
		}
		return heap;
	}
	
	public static void heapify(MaxHeap heap, int idx)
	{
		int largest = idx;
		int left = (idx<<1) + 1;
		int right = (idx + 1)<<1;
		if(left < heap.size && heap.arr[left] > heap.arr[largest])
			largest = left;
		if(right < heap.size && heap.arr[right] > heap.arr[largest])
			largest = right;
		if(largest != idx)
		{
			swap(heap.arr, largest, idx);
			heapify(heap, largest);
		}
	}
	
	public static void swap(int[] arr, int src, int dst)
	{
		int temp = arr[src];
		arr[src] = arr[dst];
		arr[dst] = temp;
	}
	public static class MaxHeap
	{
		public int[] arr;
		public int size;
		public MaxHeap() {
			// TODO Auto-generated constructor stub
		}
		public MaxHeap(int[] arr, int size) {
			// TODO Auto-generated constructor stub
			this.arr = arr;
			this.size = size;
		}
	}
	
	
	
}
