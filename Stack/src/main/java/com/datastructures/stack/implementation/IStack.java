package com.datastructures.stack.implementation;

/**
 *
 * @author Leela
 * Interface for Stack DataStructure.
 *
 */
public interface IStack {
	
	/**
	 *  @param item - data that needs to be pushed on to the stack.
	 *  
	 *  push method is used to push an element to the stack.
	 *  
	 *  T(n)=O(1)
	 */
	boolean push(Integer item);
	
	/**
	 * @return returns elements that is popped out from the stack.
	 * 		   returns -1 if No elements are present in the stack.
	 * pop method is used to pop an element from the stack.
	 * 
	 * T(n)=O(1)
	 */
	Integer pop();
	
	/**
	 * 
	 * @return number of elements in stack.
	 * T(n)=O(1)
	 */
	Integer size();
	
	/**
	 * 
	 * @return true if stack is empty.
	 * T(n)=O(1)
	 */
	boolean isEmpty();
	
}
