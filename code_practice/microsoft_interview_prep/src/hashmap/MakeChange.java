package hashmap;

public class MakeChange {
	public static void main(String[] args)
	{
		int[] d = {2,3,5};
		int result = makeChange(10, d);
		System.out.println(result);
		//System.out.println(makeChange(10, d, d.length));
	}
	
	public static int  makeChange(int am, int[] d)
	{
		int result = 0;
		if(am < 0)
			return 0;
		if(am == 0)
			return 1;
		else
		{
			for(int i = 0; i< d.length; i++)
			{
				int res = makeChange(am-d[i],d);
				result = result + res;
				if(res == 1)
					break;
			}
		}
		return result;
	}
	
	public static int my_count(int Amount, int i, int Denomination[], int N)
	{
	    if (Amount == 0) {
	        return 1;
	    }
	    if (i == N) {
	        return 0;
	    }
	    int n, j, result;
	    n = Amount / Denomination[i];
	    result = 0;
	    for (j = 0; j <= n; j++) {
	        result += my_count(Amount - j * Denomination[i], i + 1, Denomination, N);
	    }
	    return result;

	}
	public static int makeChange(int Amount, int Denomination[], int N)
	{
	    return my_count(Amount, 0, Denomination, N);
	}
}
