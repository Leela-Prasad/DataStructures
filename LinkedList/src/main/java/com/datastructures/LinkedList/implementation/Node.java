package com.datastructures.LinkedList.implementation;

public class Node {
	Integer data;
	Node next;
	
	public Node(){
		super();
		data=null;
		next=null;
	}
	
	public Node(Integer data) {
		this.data=data;
		next=null;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
}
