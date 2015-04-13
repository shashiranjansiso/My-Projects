package google.codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "/Users/shashi/Desktop/shashi/course_material/github/My-Projects/code_practice/GeeksForGeeks/input/reversewords/B-large-practice.in";
		Input1 ip[] = readInput(filename);
		int i = 0;
		for (Input1 input : ip) {
			System.out.print("Case #" + (i+1) + ": ");
			i++;
			processInput(input.text);
		}
	}
	/*4 11111
	1 09
	5 110011
	0 1*/
	//0 1 2 0
	public static void processInput(String str)
	{
		//implement the logic
		String a[] = str.split(" ");
		int maxS = Integer.parseInt(a[0]);
		int p[]= new int[maxS+1];
		
		for(int i = 0; i <= maxS; i++)
		{
			p[i] = Integer.parseInt(a[1].charAt(i)+"");
		}
		
		int count = 0;
		int req = 0;
		for(int i = 0; i <=maxS; i++)
		{
			if(p[i] != 0)
			{
				if(count < i)
					req = req + 1;	
			}
			count = count + p[i];
		}
		System.out.println(req);
	}
	
	
	public static Input1[] readInput(String filename)
	{
		BufferedReader br = null;
		Input1 ip[] = null;
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(filename));
 
			sCurrentLine = br.readLine();
			int tcs = Integer.parseInt(sCurrentLine);
			ip = new Input1[tcs];
			for(int i = 0; i < tcs; i++)
			{
				sCurrentLine = br.readLine();
				Input1 input = new Input1(sCurrentLine);
				ip[i] = input;
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return ip;
	}

}

class Input1
{
	String text;
	public Input1(String txt) {
		// TODO Auto-generated constructor stub
		this.text = txt;
	}
}
