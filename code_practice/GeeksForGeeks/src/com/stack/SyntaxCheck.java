package com.stack;

import java.util.Stack;

public class SyntaxCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expr = "[(])";
		//String expr = "[()]{}{[()()]()}";
		System.out.println(checkSyntax(expr));
	}
	
	public static boolean checkSyntax(String expr)
	{
	    Stack<Character> s = new Stack<Character>();
	    if(expr == null || expr.length() == 0)
	        return true;
	    for(int i = 0; i < expr.length(); i++)
	    {
	        char c = expr.charAt(i);
	        if(s.isEmpty())
	        	s.push(c);
	        else
	        {
		        char top = s.pop();
		        if( (c == '}' && top != '{')
		                ||(c == ')' && top != '(')
		                ||(c == ']' && top != '['))
	            {
	                s.push(top);
	                s.push(c);
	            } 
		        if(c == '{' || c == '(' || c == '[')
		        {
		        	 s.push(top);
		             s.push(c);
		        }
	        }
	    }
	    if(s.isEmpty())
	        return true;
	    return false;
	}

}
