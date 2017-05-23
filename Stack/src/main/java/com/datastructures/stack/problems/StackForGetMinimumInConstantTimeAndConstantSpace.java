package com.datastructures.stack.problems;

import java.util.Stack;

public class StackForGetMinimumInConstantTimeAndConstantSpace {

	private Stack<Integer> stack;
	private Integer minValue;
	
	public StackForGetMinimumInConstantTimeAndConstantSpace() {
		stack = new Stack<>();
	}
	
	public void push(Integer item) {
		
		if(null == item) {
			System.out.println("Item is Null and is not inserted");
			return;
		}
		
		if(stack.isEmpty()) {
			stack.push(item);
			minValue=item;
			return;
		}
		
		if(item>=minValue) {
			stack.push(item);
		}else {
			Integer diffValue =item - minValue;
			stack.push(diffValue);
			minValue=item;
		}
	}
	
	public Integer pop() {
		if(stack.peek() >= minValue) {
			return stack.pop();
		}else {
			Integer item = minValue - stack.pop();
			minValue=item;
			return item;
		}
	}
	
	public Integer getMinimum() {
		return minValue;
	}
}
