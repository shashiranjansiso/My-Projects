package geeksforgeeks;

public class SwapWithoutTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		swap();
	}
	
	public static void swap()
	{
		int a = 10;
		int b = 11;
		a= a+b;
		b = a -b;
		a = a-b;
		System.out.println(a);
		System.out.println(b);
	}

}
