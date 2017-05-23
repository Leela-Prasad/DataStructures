package com.datastructures.queue.implementation;

import java.util.Stack;

import org.springframework.stereotype.Component;

@Component
public class QueueUsingTwoStacks implements IQueue{

	private Stack<Integer> s1;
	private Stack<Integer> s2;
	int size;
	
	
	public QueueUsingTwoStacks() {
		s1=new Stack<>();
		s2=new Stack<>();
		size=0;
	}
	
	/**
	 * Here we have to provide two ends to create a queue
	 * one for front pointer and another for rear pointer
	 * so we will use one stack for front pointer(dequeue operation)
	 *  and another stack front rear pointer(enqueue operation)
	 */
	/**
	 * when we enqueue element we will always push to stack s1.
	 */
	@Override
	public boolean enQueue(Integer item) {
		if(null == item)
			throw new NullPointerException("Item is Null");
		
		s1.push(item);
		++size;
		return true;
	}

	/**
	 * During deQueue.
	 * If s2 is not empty then pop out one element from s2.
	 * If s2 is empty and s1 is empty then queue is empty.
	 * If s2 is empty and s1 is not empty then we will pop all elements
	 * of s1 and push it to s2 and then pop out one element from s2.
	 */
	@Override
	public Integer deQueue() {
		
		Integer removedElement;
		if(!(s2.isEmpty())) {
			removedElement =  s2.pop();
			--size;
			return removedElement;
		}
		
		if(s1.empty()) {
			System.out.println("Queue is empty");
			return -1;
		}else {
			while(!(s1.empty())) {
				s2.push(s1.pop());
			}
			removedElement = s2.pop();
			--size;
			return removedElement;
		}
	}

	@Override
	public Integer size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	public static void main(String[] args) {
		new QueueUsingTwoStacks().enQueue(2);
	}

	
}
