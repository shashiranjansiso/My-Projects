package cracking.codinginterview.linklist;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack(10);
		stack.push(10);
		stack.push(20);
		stack.push(5);
		stack.push(30);
		stack.push(2);
		System.out.println("pop 1 : " + stack.pop());
		System.out.println("pop 2 : " + stack.pop());
	}

}
