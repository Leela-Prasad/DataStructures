package com.datastructures.LinkedList.implementation;

public class LinkedList {

	private Node head;
	
	public Node getHead() {
		return head;
	}
	
	public LinkedList() {
		super();
	}
	
	public LinkedList(Node node) {
		this.head=node;
	}
	
	public boolean insert(Integer data) {
		if(data == null)
			return false;
		
		Node newNode = new Node(data);
		
		if(head==null) {
			head = newNode;
			return true;
		}
			
		newNode.setNext(head);
		head=newNode;
		return true;
	}
	
	public boolean insertAtEnd(Integer data) {
		if(data == null)
			return false;
		
		Node newNode = new Node(data);
		if(head == null) {
			head=newNode;
			return true;
		}
		
		Node current = head;
		while(current.getNext()!=null)
			current = current.getNext();
		
		current.setNext(newNode);
		return true;
		
	}
	
	public boolean insertAfterNode(Integer key,Integer data) {
		if(data == null || key == null)
			return false;
		
		Node newNode = new Node(data);
		if(head == null) {
			head=newNode;
			return true;
		}
		
		Node current = head;
		while(current.getNext()!=null) {
			if(current.getData() == key) {
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				return true;
			}
			current = current.getNext();
		}
		
		current.setNext(newNode);
		return true;
			
	}
	
	public boolean delete() {
		if(head == null)
			return false;
		
		if(head.getNext() == null) {
			head.setNext(null);
			return true;
		}
			
		Node temp = head;
		head=temp.getNext();
		temp.setNext(null);
		return true;
	}
	
	public boolean deleteFromLast() {
		if(head == null)
			return false;
		
		if(head.getNext() == null) {
			head=null;
			return true;
		}
		
		if(head.getNext().getNext() == null) {
			head.setNext(null);
			return true;
		}
		
		Node current = head;
		while(current.getNext().getNext()!=null) 
			current = current.getNext();
		
		current.setNext(null);
		return true;
			
	}
	
	public boolean deleteNode(Integer key) {
		if(head == null)
			return false;
		
		if(head.getNext() == null) {
			if(head.getData() == key) {
				head=null;
				return true;
			}
			return false;
		}
		
		if(head.getNext().getNext() == null) {
			if(head.getNext().getData() == key) {
				head.setNext(null);
				return true;
			}
			return false;
		}
		
		Node current = head;
		while(current.getNext().getNext()!=null) {
			if(current.getNext().getData() == key) {
				Node temp = current.getNext();
				current.setNext(current.getNext().getNext());
				temp.setNext(null);
				return true;
			}
			current = current.getNext();
		}
		
		if(current.getNext().getData() == key) {
			current.setNext(null);
			return true;
		}
		return false;
		
		
	}
	
	public void printNodes() {
		if(head==null)
			return;
		
		Node current = head;
		while(current!=null) {
			System.out.print(current.getData() + "\t");
			current=current.getNext();
		}
		System.out.println();
		
	}
	
}
