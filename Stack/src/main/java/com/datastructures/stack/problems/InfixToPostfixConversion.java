package com.datastructures.stack.problems;

public class InfixToPostfixConversion {

	/**
	 * examples : 
	 * Infix : a + b
	 * Postfix : ab+
	 * 
	 * Infix : a + b * c
	 * Postfix : a + bc* => abc*+
	 * 
	 * Infix : a * b + c
	 * Postfix : ab* + c => ab*c+
	 * 
	 * Infix : a + (b - c)
	 * Postfix : a + bc- => abc-+
	 * 
	 * Precedence between parenthesis('(') and operator(+,-,/,*)
	 * 1. + < ( Here '(' has more priority
	 * 2. ( < + Here '+' has more priority
	 * 
	 * Algorithm
	 * ----------
	 * 1. create a stack.
	 * 2. for each character 't' in the input stream.
	 * 		If 't' is an operand then
	 * 			output t.
	 * 		else if 't' is an right parenthesis then
	 * 			pop out all tokens until left parenthesis is popped out(but not output left parenthesis)
	 * 		else( here 't' is an operator or left parenthesis)
	 * 			pop and output tokens until one of the lower priority token that 't' is encountered
	 * 			or left parenthesis is encountered(because left parenthesis will have lower priority 
	 * 			than other operators(+,-,*,/) or stack is empty.
	 * 			Push 't'.
	 * 	3. Pop and output tokens until stack is empty.
	 * 
	 * 
	 * The stack used in this algorithm is called operator stack because only operators will be pushed 
	 * into stack.	 
	 */
	public void algorithm() {
		
	}
}
