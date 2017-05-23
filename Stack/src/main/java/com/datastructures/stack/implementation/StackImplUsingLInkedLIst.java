package com.datastructures.stack.implementation;

import org.springframework.stereotype.Component;

import com.datastructures.domain.Node;

@Component
public class StackImplUsingLInkedLIst implements IStack{

	private Node head;
	private int size;
	
	public StackImplUsingLInkedLIst() {
		head=null;
		size=0;
	}
	
	@Override
	public boolean push(Integer item) {
		
		if(item == null)
			throw new NullPointerException("Item is Null");
		
		Node newNode = new Node();
		newNode.setData(item);
		newNode.setNextNode(head);
		head=newNode;
		++size;
		
		return true;
	}

	@Override
	public Integer pop() {
		
		if(head==null) {
			System.out.println("No Elements in Stack");
			return -1;
		}
		
		Node tempNode = head;
		head=head.getNextNode();
		tempNode.setNextNode(null);
		--size;
		
		return tempNode.getData();
	}

	@Override
	public Integer size() {
		
		/*if(head==null)
			return 0;
		int size=0;
		
		Node current = head;
		while(current!=null) {
			++size;
			current=current.getNextNode();
		}
		
		return size;*/
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head==null;
	}

}
