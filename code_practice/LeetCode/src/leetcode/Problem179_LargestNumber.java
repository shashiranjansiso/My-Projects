package leetcode;

public class Problem179_LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(num));
	}

	public static String largestNumber(int[] num) {
		 
        String[] NUM = new String[num.length];
 
        for (int i = 0; i < num.length; i++) {
            NUM[i] = String.valueOf(num[i]);
        }
 
        java.util.Arrays.sort(NUM, new java.util.Comparator<String>() {
            public int compare(String left, String right) {
                String leftRight = left.concat(right);
                String rightLeft = right.concat(left);
                return rightLeft.compareTo(leftRight);
            }
        });
 
        java.lang.StringBuffer buffer = new java.lang.StringBuffer();
        for (int i = 0; i < NUM.length; i++) {
            buffer.append(NUM[i]);
        }
        // String result = buffer.toString();
        java.math.BigInteger result = new java.math.BigInteger(
                buffer.toString());
        return result.toString();
    }
	
}
