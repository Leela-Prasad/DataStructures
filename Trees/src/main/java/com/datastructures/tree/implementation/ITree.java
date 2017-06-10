package com.datastructures.tree.implementation;

import com.datastructures.domain.Node;

public interface ITree {

	Node getRoot();
	
	void preOrderTraversal(Node node);
	
	void inOrderTraversal(Node node);
	
	void postOrderTraversal(Node node);
	
	void levelOrderTraversal();
	
	void insert(Node node);
	
	boolean search(Integer data);
	
	Node findMinimum(Node root);
	
	Node findMaximum(Node root);
	
	Node inorderPrecedor(Node root);
	
	Node inorderSuccessor(Node root);
	
	boolean isComplete(Node root);
	
	boolean delete(Integer data);
}
