
public class RankOfElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {46, 32, 16, 73, 57, 2};
		int b[] = new int[a.length];
		
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a.length; j++)
				b[j] = a[j];
			System.out.print("Rank of " + a[i] + "		");
			System.out.println(findRank(b, a[i], 0, a.length -1));
		}
			
	}
	
	public static int findRank(int b[], int n, int l, int h)
	{
	    if(l <= h)
	    {
	        int index = partition(b, l, h);
	        if(b[index] == n)
	            return index + 1;
	        else if(n > b[index])
	            return findRank(b, n, index +1, h);
	        else
	            return findRank(b, n, l, index-1);
	    }
	    return -1;
	}


	public static int partition(int a[], int l, int h)
	{    
	    int i = l;
	    int j = h-1;
	    while(i <= j)
	    {
	    	if(a[i] > a[h] && a[j] < a[h])
	        {   
	        	swap(a, i, j);
	        	i++;j--;
	        }
	        if(a[i] < a[h])
	            i++;
	        if(a[j] > a[h])
	            j--;
	    }
	    swap(a, i, h);
	    return i;
	}

	public static void swap(int a[], int i, int j)
	{
	    int t = a[i];
	    a[i] = a[j];
	    a[j] = t;
	}

}
