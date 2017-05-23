package com.datastructures.stack.problems;

import java.util.Stack;

public class PostFixEvaluation {

	private Stack<Integer> stack;
	
	public PostFixEvaluation() {
		stack = new Stack<>();
	}
	
	
	public Integer  evaluatePostFixExpressionHelper(String str) {
		
		if(!(stringNotNullOrEmpty(str))) {
			throw new NullPointerException("String is Null or Empty");
		}
		
		String[] input = new String[str.length()];
		for(int i=0;i<str.length();++i) {
			input[i]=str.substring(i, i+1);
		}
		return evaluatePostFixExpression(input);
	}
	
	/**
	 * 
	 * @param str - Postfix expression
	 * @return	- Postfix expression evaluation result.
	 * 
	 * Algorithm
	 * ----------
	 * 1. create a stack.
	 * 2. scan postfix expression from left to right.
	 * 3. repeat steps 4 and 5 until all characters are scanned.
	 * 4. If scanned character is operand then push on to the stack.
	 * 5. If scanned character is operator and 
	 * 		if operator is unary operator, then pop out an element from the stack.
	 * 		if operator is binary operator, then pop out two elements from the stack.
	 * 		after popping the elements apply operator to those popped elements. 
	 * 		and push back the result to the stack.
	 * 6. After all characters are scanned then we will have only one element in the stack.
	 * 7. Return top of the stack as result.
	 * 
	 * The stack used in algorithm is called operand stack because only operands will be pushed
	 * onto the stack.
	 */
	private Integer  evaluatePostFixExpression(String[] str) {
		
		if(null == str) {
			throw new NullPointerException("Input Array is NULL");
		}
		
		for(String aChar : str) {
			if(aChar.equals("+")) {
				Integer op2 = stack.pop();
				Integer op1 = stack.pop();
				Integer result = op1 + op2;
				stack.push(result);
			}else if(aChar.equals("-")) {
				Integer op2 = stack.pop();
				Integer op1 = stack.pop();
				Integer result = op1 - op2;
				stack.push(result);
			}else if(aChar.equals("*")) {
				Integer op2 = stack.pop();
				Integer op1 = stack.pop();
				Integer result = op1 * op2;
				stack.push(result);
			}else if(aChar.equals("/")) {
				Integer op2 = stack.pop();
				Integer op1 = stack.pop();
				Integer result = op1 / op2;
				stack.push(result);
			}else {
				stack.push(Integer.parseInt(aChar));
			}
		}
		
		return stack.pop();
	}
	
	private boolean stringNotNullOrEmpty(String str) {
		
		if(null==str || "null".equalsIgnoreCase(str) || "".equalsIgnoreCase(str))
			return false;
		return true;
		
	}

}
