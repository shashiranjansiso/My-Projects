package vmware;


public class GivenSumExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 4, 45, 6, 0, 19};
		System.out.println(isSumExist(a, 22, a.length -1, 22));
	}
	
	public static boolean isSumExist(int a[],int sum, int index, int origsum)
	{
		if(sum == 0)
			return true;
		if(index < 0)
			return false;
		if(a[index] == origsum)
			return true;
		if(sum < 0)
			return false;
		return isSumExist(a, sum, index -1, origsum) || isSumExist(a, sum - a[index], index -1, origsum);
	}
}
