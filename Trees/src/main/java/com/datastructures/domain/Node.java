package com.datastructures.domain;

public class Node {

	private Integer data;
	private Node left;
	private Node right;
	
	public Node() {
		data=0;
		left=null;
		right=null;
	}
	
	public Node(Integer data) {
		this.data=data;
		left=null;
		right=null;
	}
	
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
