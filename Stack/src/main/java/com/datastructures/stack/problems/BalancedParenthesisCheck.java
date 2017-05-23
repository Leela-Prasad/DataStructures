package com.datastructures.stack.problems;

import java.util.Stack;

public class BalancedParenthesisCheck {

	private Stack<Character> stack;
	
	public BalancedParenthesisCheck() {
		stack = new Stack<>(); 
	}
	public boolean isBalanced(String str) {
		char[] stringTokens = str.toCharArray();
		
		for(char aChar : stringTokens) {
			if(aChar == '(' || aChar == '[' || aChar == '{') {
				stack.push(aChar);
			}else if(aChar == ')') {
				if(!(stack.isEmpty()) && '(' == stack.peek()){
					stack.pop();
				}else  {
					return false;
				}
			}else if(aChar == ']') {
				if(!(stack.isEmpty()) && '[' == stack.peek()){
					stack.pop();
				}else  {
					return false;
				}
			}else if(aChar == '}') {
				if(!(stack.isEmpty()) && '{' == stack.peek()){
					stack.pop();
				}else  {
					return false;
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}else  {
			return false;
		}
	}
}
