package leetcode;

import java.util.HashMap;

public class Arrays_Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int numbers[] = {2, 11, 7, 15};
		//int ans[] = twoSum(numbers, 9);
		//for (int i : ans) {
		//	System.out.println(i + "    ");
		//}
		int[] a = {2, 5, 7, 5, 4, 4, 2};
		minDist(a, 2,3);
	}

	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int output[] = new int[2];
		for(int i =0; i < numbers.length; i++)
		{
			int req = target - numbers[i];
			if(map.get(req) == null)
				map.put(numbers[i], i);
			else
			{
				output[0] = map.get(req);
				output[1] = i;
			}
		}
        return output;
    }
	
	
	public static void minDist(int[] a, int x, int y)
	{
		int min = Integer.MAX_VALUE;
		int dist = 0, prev = 0;
		boolean found = false;
		for(int i = 0;i<a.length; i++)
		{
			if(found && a[i] == prev)
				dist = 0;
			else if((a[i] == x || a[i] == y) && !found)
			{
				found = true;
				dist = 0;
				prev = a[i];
			}
			else if(found)
				dist++;
			if(found && (a[i] == x || a[i] == y) && (prev != a[i]))
			{
				if(dist < min)
					min = dist;
				dist = 0;
				prev = a[i];
			}	
		}
		System.out.println(min);
	}
	
	
	
}
