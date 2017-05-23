package com.datastructures.stack.problems;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

	private Queue<Integer> q1;
	private Queue<Integer> q2;
	private int size;
	
	public StackUsingTwoQueues() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		size=0;
	}
	
	/**
	 *	Here at any time we should operate with one queue
	 *		empty queue for push operation.
	 *		non empty queue for pop operation.
	 *  because in stack we have only one end for push and pop operations  
	 */
	/**
	 * 
	 * @param item to be insterted
	 * @return true if inserted otherwise false will be returned.
	 * 
	 * We have to push an element in an empty queue.
	 * after that we have to dequeue all elements from another queue 
	 * and enqueue to this queue to make other queue empty for next push operation.
	 */
	public boolean push(Integer item) {
		
		boolean isPushed=false;
		if(null == item) {
			System.out.println("Item is Null and is not inserted");
			return false;
		}
		
		if(q1.isEmpty()) {
			q1.offer(item);
			while(!(q2.isEmpty())) {
				q1.offer(q2.poll());
				isPushed=true;
			}
		}
		
		if(q2.isEmpty()) {
			q2.offer(item);
			while(!(q1.isEmpty())) {
				q2.offer(q1.poll());
				isPushed=true;
			}
		}
		
		if(isPushed)
			++size;
		
		return isPushed;
	}
	/**
	 * 
	 * @return returns removed element
	 * 
	 * Here we have to dequeue from a Non empty queue.
	 */
	public Integer pop() {
		
		boolean isPopped=false;
		Integer removedElement;
		
		if(!(q1.isEmpty())) {
			removedElement = q1.poll();
			isPopped=true;
			return removedElement;
			
		}
		
		if(!(q2.isEmpty())) {
			removedElement = q2.poll();
			isPopped=true;
			return removedElement;
		}
		
		if(isPopped)
			--size;
		
		return -1;
	}
	
	public Integer size() {
		return size;
	}
	
	public boolean isEmpty() {
		if(q1.isEmpty() && q2.isEmpty())
			return true;
		return false;
	}
}
