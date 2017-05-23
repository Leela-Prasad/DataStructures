package com.datastructures.stack.problems;

import java.util.Stack;

public class StackForGetMinimumInConstantTime {

	private Stack<Integer> s1;
	private Stack<Integer> s2;
	
	public StackForGetMinimumInConstantTime() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	public boolean push(Integer item) {
		
		if(item == null) {
			System.out.println("Element is Null");
			return false;
		}
		
		s1.push(item);
		if(s2.isEmpty()) {
			s2.push(item);
		}else if(item <= s2.peek()){
			s2.push(item);
		}
		return true;
	}
	
	public Integer pop() {
		
		Integer temp = s1.pop();
		if(temp == s2.peek()) {
			s2.pop();
		}
		return temp;
	}
	
	public Integer getMinimum() {
		return s2.peek();
	}
}
