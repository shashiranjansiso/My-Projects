package geeksforgeeks;

public class NegOnLeft {
	public static void main(String[] args) {
		int n = 11;
		int a[]={-2,-3,4,8,9,-8,7,-12,-5,-18,10};
	    //int a[11]={-2,-3,-4,-8,-9,8,-7,-12,-5,-18,-10};
	    /*for(i=0;i<n;i++)
	    {
	        cin>>a[i];
	    }*/
	    int neg=0;
	    for(int i=0;i<n;i++)
	    {
	        if(a[i]<0)
	        {
	            swap(a, neg, i);
	            neg++;
	        }
	    }
	    for(int i = 0; i<n;i++)
	    	System.out.println(a[i]);
	}
	
	public static void swap(int a[], int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	

}
