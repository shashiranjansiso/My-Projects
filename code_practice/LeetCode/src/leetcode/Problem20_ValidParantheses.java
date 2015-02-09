package leetcode;

import java.util.Stack;

public class Problem20_ValidParantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "([])";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		Stack<Character> stk = new Stack<Character>();
		char c;
		for(int i = 0; i < s.length(); i++)
		{
			switch (s.charAt(i)) {
			case '(':
				stk.push(s.charAt(i));
				break;
			case ')':
				if(stk.isEmpty())
					return false;
				c = stk.pop();
				if(c != '(')
					return false;
				break;
			case '[':
				stk.push(s.charAt(i));
				break;
			case ']':
				if(stk.isEmpty())
					return false;
				c = stk.pop();
				if(c != '[')
					return false;
				break;
			case '{':
				stk.push(s.charAt(i));
				break;
			case '}':
				if(stk.isEmpty())
					return false;
				c = stk.pop();
				if(c != '{')
					return false;
				break;
			default:
				break;
			}
		}
		if(stk.isEmpty())
			return true;
		else
			return false;
    }
	
}
