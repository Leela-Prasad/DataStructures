package com.datastructures.stack.implementation;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class StackImplUsingArrays implements IStack{

	private Integer[] stack = new Integer[MAX_ELEMENTS];
	private Integer top=-1;
	private static final Integer MAX_ELEMENTS=10;
	
	public StackImplUsingArrays() {
		stack=new Integer[MAX_ELEMENTS];
		top=-1;
	}
	
	@Override
	public boolean push(Integer item) {
		
		if(item==null) 
			throw new NullPointerException("Item is Null");
		
		if(top+1>=stack.length) {
			System.out.println("Stack Exceeded!");
			return false;
		}
			
		
		stack[++top]=item;
		return true;
		
	}

	@Override
	public Integer pop() {
		Integer temp;
		
		if(top==-1) {
			System.out.println("No Elements in Stack");
			return -1;
		}
			
		
		temp=stack[top--];
		return temp;
	}
	
	@Override
	public Integer size() {
		return top+1;
	}
	
	@Override
	public boolean isEmpty() {
		return top==-1;	
	}
	
	@Override
	public String toString() {
		return Arrays.toString(stack);
	}

}
