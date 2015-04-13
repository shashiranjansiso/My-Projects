package com.careercup.facebookinterviewquestions;

public class EvaluateExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(evaluate("3*5+8"));
	}
	
	public static int evaluate(String exp)
	{
		String pos[] = exp.split("+");
		int sum = 0;
		for (String pExpr : pos) {
			int prod = 1;
			String mul[] = pExpr.split("*");
			for (String mExpr : mul) {
				prod = prod *Integer.parseInt(mExpr);
			}
			sum = sum + prod;
		}
		return sum;
	}

}
