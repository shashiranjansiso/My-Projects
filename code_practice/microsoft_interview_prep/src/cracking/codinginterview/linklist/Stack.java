package cracking.codinginterview.linklist;

public class Stack {
	int top;
	Object[] arr;
	int maxSize;
	public Stack(int s)
	{
		maxSize = s;
		arr = new Object[maxSize];
		top = -1;
	}
	
	public boolean push(Object data)
	{
		if(top == maxSize - 1)
			return false;
		arr[++top] = data;
		return true;
	}
	
	public Object pop()
	{
		if(top == -1)
			return null;
		else
			return arr[top--];
	}
	
	public boolean isEmpty()
	{
		if(top == -1)
			return true;
		return false;
	}
}
