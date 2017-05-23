package com.datastructures.stack.problems;

import java.util.Stack;

public class StockSpanProblem {

	
	public StockSpanProblem() {
		super();
	}
	
	public Integer[] findSpan(Integer[] price) {	
		
		if(null == price) {
			return null;
		}
		
		Integer[] span = new Integer[price.length];
		Stack<Integer> stack = new Stack<>();
		
		span[0]=0;
		stack.push(0);
		/*for(int i=1;i<price.length;++i) {	
			
				if(price[i] < price[stack.peek()]) {
					span[i]= i - stack.peek() -1;
					stack.push(i);
				}else {
					int size=stack.size();
					for(int j=0;j<size;++j) {
						if(price[i]>=price[stack.peek()]) {
							stack.pop();
						}
					}
					if(stack.isEmpty()) {
						span[i]=i;
					}else {
						span[i]= i - stack.peek() -1;
					}
					stack.push(i);
				}
			}*/
		
		for(int i=1;i<price.length;++i) {	
				
			while(!(stack.isEmpty()) && price[i]>=price[stack.peek()]) {
				stack.pop();
			}
				
			span[i] = (stack.isEmpty()) ? i : i - stack.peek() -1;
			stack.push(i);
		}
		
		return span;
	}
}
