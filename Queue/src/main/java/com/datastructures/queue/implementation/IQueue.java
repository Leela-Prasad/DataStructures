package com.datastructures.queue.implementation;

public interface IQueue {

	/**
	 * 
	 * @param item element to be inserted.
	 * @return true if element is successfully inserted.
	 * 
	 * T(n)=O(1)
	 */
	boolean enQueue(Integer item);
	
	/**
	 * 
	 * @return element.
	 *         return -1 if no elements are present.
	 * T(n)=O(1)        
	 */
	Integer deQueue();
	
	/**
	 * 
	 * @return size of Queue
	 * T(n)=O(1)
	 */
	Integer size();
	
	/**
	 * 
	 * @return true if queue is empty.
	 * T(n)=O(1)
	 */
	boolean isEmpty();
	
	
}
