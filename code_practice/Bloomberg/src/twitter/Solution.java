package twitter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        String filename = "\\Users\\shashi\\Desktop\\workspace\\Bloomberg\\src\\twitter\\input000.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        long res;
        
        int _arr_size = Integer.parseInt(in.nextLine());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine());
            _arr[_arr_i] = _arr_item;
        }
        
        res = sumOfIntegers(_arr);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }

	public static long sumOfIntegers(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum+=i;
		}
		System.out.println(sum);
		return sum;
    }

}
