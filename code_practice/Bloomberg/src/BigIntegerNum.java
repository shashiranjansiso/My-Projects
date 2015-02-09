import java.math.BigInteger;


public class BigIntegerNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*BigInteger bigint = new BigInteger("12345679123456789123456789");
		int num = bigint.intValue();
		System.out.println(bigint);
		System.out.println(num);*/
		//int a[] = {-1,100,2,100,100,4,100};
		//System.out.println(majorityElement(a));
		//trailingZeroes(4);
		compareVersion("1", "2");
	}

	public static int trailingZeroes(int n) {
        int power = 1;
        double trailingZeroes = 0;
        while(n / Math.pow(5, power) > 1)
        {
            trailingZeroes = trailingZeroes + n/Math.pow(5, power);
            power++;
        }
        return (int)trailingZeroes;
    }
	public static int majorityElement(int[] num) {
        int count = 1;
        int element = num[0];
        for(int i = 1; i < num.length; i++)
        {
        	if(count == 0)
        	{
        		element = num[i];
        		count++;
        	}
        	else if(count > 0 && element == num[i])
        		count++;
        	else
        		count--;
        }
        return element;
    }
	public static int compareVersion(String version1, String version2) {
		String[] version1Arr = version1.split("\\.");
		String[] version2Arr = version2.split("\\.");
		int maxSize = Math.max(version1Arr.length, version2Arr.length);
		for(int i = 0; i< maxSize; i++)
		{
			int v1 = 0,v2 = 0;
			if(i > version2Arr.length - 1)
				v2 = 0;
			else
				v2 = Integer.parseInt(version2Arr[i]);
			if(i > version1Arr.length - 1)
				v1 = 0;
			else
				v1 = Integer.parseInt(version1Arr[i]);
			if(v1 > v2)
				return 1;
			else if(v1 < v2)
				return -1;
		}
        return 0;
    }
}
