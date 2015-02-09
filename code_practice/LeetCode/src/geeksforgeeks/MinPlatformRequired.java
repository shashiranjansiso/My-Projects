package geeksforgeeks;

import java.util.Arrays;

public class MinPlatformRequired {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	    System.out.println(findPlatform(arr, dep, arr.length));
	}

	public static int findPlatform(int[] arr,int[] dep,int n)
	{
		Arrays.sort(dep);
		Arrays.sort(arr);
		int max = -1;
		int i =0, j = 0;
		int m = 0;
		while(i< n && j < n)
		{
			if(arr[i] < dep[j])
			{
				m++;
				i++;
				if(m>max)
					max = m;
			}
			else
			{
				m--;j++;
			}
		}
		return max;
	}
		
	
}
