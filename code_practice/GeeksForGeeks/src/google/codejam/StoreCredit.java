package google.codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class StoreCredit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "/Users/shashi/Desktop/shashi/course_material/github/My-Projects/code_practice/GeeksForGeeks/input/A-large-practice.in";
		Input ip[] = readInput(filename);
		int i = 0;
		for (Input input : ip) {
			System.out.print("Case #" + (i+1) + ": ");
			i++;
			processInput(input);
		}
	}

	public static void processInput(Input ip)
	{
		int credit = ip.credit;
		int items[] = ip.items;
		HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
		for(int i = 0; i < items.length; i++)
		{
			int req = credit - items[i];
			if(s.containsKey(req))
			{
				System.out.println((s.get(req)+1) + " " + (i+1));
			}
			else
				s.put(items[i], i);
		}
	}
	
	public static Input[] readInput(String filename)
	{
		BufferedReader br = null;
		Input ip[] = null;
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(filename));
 
			sCurrentLine = br.readLine();
			int tcs = Integer.parseInt(sCurrentLine);
			ip = new Input[tcs];
			for(int i = 0; i < tcs; i++)
			{
				sCurrentLine = br.readLine();
				int credit = Integer.parseInt(sCurrentLine);
				sCurrentLine = br.readLine();
				int numItems = Integer.parseInt(sCurrentLine);
				sCurrentLine = br.readLine();
				String items[] = sCurrentLine.split(" ");
				int is[] = new int[items.length];
				int j = 0;
				for (String item : items) {
					is[j++] = Integer.parseInt(item);
				}
				Input input = new Input(credit, numItems, is);
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

final class Input
{
	int credit;
	int numItems;
	int items[];
	public Input(int c, int n, int items[]) {
		// TODO Auto-generated constructor stub
		this.credit = c;
		this.numItems = n;
		this.items = items;
		}
}
