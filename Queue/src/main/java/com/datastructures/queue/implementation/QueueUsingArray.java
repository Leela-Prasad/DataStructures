package com.datastructures.queue.implementation;

import org.springframework.stereotype.Component;

@Component
public class QueueUsingArray implements IQueue{

	private Integer[] queue;
	private int  front;
	private int rear;
	private int size;
	
	
	public QueueUsingArray() {
		queue=new Integer[10];
		front=0;
		rear=0;
		size=0;
	}
	
	@Override
	public boolean enQueue(Integer item) {
		
		if(item==null)
			throw new NullPointerException("Item is Null");
		
		rear = (rear+1)%(queue.length);
		
		if(front==rear) {
			System.out.println("Queue Exceeded");
			if(rear==0) {
				rear=queue.length-1;
			}else {
				rear=rear-1;
			}
			return false;
		}
		
		queue[rear]=item;
		++size;
		
		return true;
	}

	@Override
	public Integer deQueue() {
		
		if(front==rear) {
			System.out.println("No Elements present in Queue");
			return -1;
		}
		
		front=(front+1)%queue.length;
		Integer removedElement=queue[front];
		--size;
		
		return removedElement;
	}

	@Override
	public Integer size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front==rear;
	}

}
