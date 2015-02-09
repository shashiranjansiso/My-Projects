package icims;

public class Program3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3, 30, 34, 5, 9};
		largestNumber(a);
		//System.out.println(solution(a, 9));
	}

	public static int solution(int[] A, int X) {
		int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else if (A[m] < X){
                l = m + 1;
            }else return m;
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
	
	public static String[] largestNumber (int[] num) {

		int z = 0, x = 0, y = 0, a = 0, b = 0;

		String ss = ("");

		String opss [] = new String [num.length];

		for (int j=0;j<num.length;j++){
			for (int i=0; i<num.length; i=i+2){
				
				y = num[i]; //gets the number at the index of i
				x = (int) (Math.log(y))+ 1; //finds the number of digits
				x= (int) Math.pow(10,x)/10; //gets the number of place valye
				a = y/x; // get the digit in the first place
				z = num[i+1]; // ———> line 12
				x = (int) Math.log(z) + 1;
				x= (int) Math.pow(10,x)/10;
				b= z/x;
				if (a>b)
					y = b;	
				else if (a<b)
					z=b;	
				else
					y =b;
			}
			ss = (""+b);
			opss[j] = ss;
		}
		return opss;
	}
}
