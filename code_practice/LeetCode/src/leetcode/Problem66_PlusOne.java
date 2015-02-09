package leetcode;

public class Problem66_PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {9,9};
		int[] res = plusOne(a);
		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length -1;
        int sum;
        while(carry != 0 && n >= 0)
        {
        	sum = digits[n] + carry;
        	digits[n] = sum % 10;
        	carry = sum /10;
        	n--;
        }
        if(carry != 0)
        {
        	int a[] = new int[digits.length + 1];
        	a[0] = 1;
        	for(int i = 1; i < digits.length + 1; i++)
        		a[i] = 0;
        	return a;
        }
        return digits;
    }
	
}
