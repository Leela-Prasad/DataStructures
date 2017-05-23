package com.datastructures.stack.problems;

import java.util.Stack;

public class ClosestGreatestValue {

	private Stack<Element> stack;
	
	public ClosestGreatestValue() {
		stack = new Stack<>();
	}
	
	//10,20,1,5,25,500,60
	
	public Integer[] findClosestGreatestValues(Integer[] input) {
		
		if(null==input)
			return null;
		
		Integer[] output = new Integer[input.length];
		
		for(int i=0;i<input.length;++i) {
			
			if(stack.isEmpty()) {
				stack.push(new Element(input[i],i));
			}else {
				if(input[i]<=stack.peek().getValue()) {
					stack.push(new Element(input[i],i));
				}else {
					//Never ever place a variable size() method in for loop condition 
					//because it will vary and we will not do right no. of iterations.
					int size = stack.size();
					for(int j=0;j<size;++j) {
						Integer value = stack.peek().getValue();
						Integer index = stack.peek().getIndex();
						if(input[i]>value) {
							output[index]=input[i];
							stack.pop();
						}	
					}
					stack.push(new Element(input[i],i));
				}
			}
		}
		
		while(!(stack.isEmpty())) {
			Integer index = stack.peek().getIndex();
			output[index]=Integer.MIN_VALUE;
			stack.pop();
		}
		
		return output;
	}
	
	class Element {
		Integer value;
		Integer index;
		
		public Element() {
			super();
		}
		
		public Element(Integer value,Integer index) {
			this.value=value;
			this.index=index;
		}
		
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		public Integer getIndex() {
			return index;
		}
		public void setIndex(Integer index) {
			this.index = index;
		}
		
		public String toString() {
			return "(" + value.toString() + "," + index.toString() + ")";
		}
	
}


	
}