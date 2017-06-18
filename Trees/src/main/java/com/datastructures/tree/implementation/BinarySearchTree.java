package com.datastructures.tree.implementation;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.domain.Node;

public class BinarySearchTree implements ITree{

	private Node root;
	
	public Node getRoot() {
		return root;
	}
	
	public BinarySearchTree() {
		super();
	}
	
	public BinarySearchTree(Node root) {
		this.root=root;
	}
	
	public void preOrderTraversal(Node node) {
		if(node==null)
			return;
		
		System.out.print(node.getData() + "\t");
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
		
	}
	
	public void inOrderTraversal(Node node) {
		if(node==null)
			return;
		
		inOrderTraversal(node.getLeft());
		System.out.print(node.getData() + "\t");
		inOrderTraversal(node.getRight());
		
	}
	
	public void postOrderTraversal(Node node) {
		if(node==null)
			return;
		
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.print(node.getData() + "\t");
		
	}
	
	public void levelOrderTraversal() {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		while(!(queue.isEmpty())) {
			Node temp = queue.poll();
				System.out.print(temp.getData() + "\t");
				if(temp.getLeft()!=null)
					queue.offer(temp.getLeft());
				if(temp.getRight()!=null)
					queue.offer(temp.getRight());
		}
	}
	
	public void insert(Node node) {
		if(node == null)
			return;
		if(root == null) {
			root=node;
			return;
		}
			
		insertHelper(root,node);
	}

	private void insertHelper(Node root, Node node) {
	
		if(node!=null) {
			if(node.getData().compareTo(root.getData())<=0) {
				if(root.getLeft() == null) {
					root.setLeft(node);
					return;
				}else {
					insertHelper(root.getLeft(),node);
				}
				
			}else {
				if(root.getRight() == null) {
					root.setRight(node);
					return;
				}else {
					insertHelper(root.getRight(), node);
				}
			}
		}
		
	}
	
	public boolean search(Integer data) {
		if(root == null)
			return false;
		
		if(data == null)
			return false;
		
		return searchHelper(root,data);
			
	}

	private boolean searchHelper(Node root, Integer data) {
		
		if(root == null)
			return false;
		
		if(data.compareTo(root.getData())==0) {
			return true;
		}else if(data.compareTo(root.getData())<0) {
			return searchHelper(root.getLeft(),data);
		}else {
			return searchHelper(root.getRight(),data);
		}
	}
	
	public Node findMinimum(Node root) {
		if(root == null)
			return null;
		
		if(root.getLeft() == null)
			return root;
		else 
			return findMinimum(root.getLeft());
	}
	
	public Node findMaximum(Node root) {
		if(root == null)
			return null;
		
		if(root.getRight() == null)
			return root;
		else
			return findMaximum(root.getRight());
	}
	
	public Node inorderPrecedor(Node root) {
		if(root == null)
			return null;
		
		return findMaximum(root.getLeft());
	}
	
	public Node inorderSuccessor(Node root) {
		if(root == null)
			return null;
		
		return findMinimum(root.getRight());
	}
	
	public boolean delete(Integer data) {
		
		if(data == null)
			return false;
		
		if(root == null)
			return false;
		
		return deleteHelper(root,null,false,data);
		
	}
	
	private boolean deleteHelper(Node root, Node parent, boolean isLeft, Integer data) {
		if(root == null)
			return false;
		
		if(data.compareTo(root.getData())<0) {
			return deleteHelper(root.getLeft(),root,true,data);
		}else if(data.compareTo(root.getData())>0) {
			return deleteHelper(root.getRight(),root,false,data);
		}else {
			
			//case 1: If deleted Node is Leaf
			if(root.getLeft() == null && root.getRight() == null) {
				if(isLeft)
					parent.setLeft(null);
				else
					parent.setRight(null);
			}
			//case 2 : If deleted Node has only one child
			else if((root.getLeft()!=null && root.getRight() == null) ||
					 (root.getLeft() == null && root.getRight()!=null)) {
				if(root.getLeft()!=null && root.getRight() == null) {
					if(isLeft) {
						parent.setLeft(root.getLeft());
					}else {
						parent.setRight(root.getLeft());
					}
				}else {
					if(isLeft) {
						parent.setLeft(root.getRight());
					}else {
						parent.setRight(root.getRight());
					}
				}
			}
			//case 3 : If deleted Node has both childs
			else {
				Node successorNode = inorderSuccessor(root);
				delete(successorNode.getData());
				root.setData(successorNode.getData());		
			}
			
			return true;
		}
	}

	public boolean isComplete(Node root) {
		if(root == null)
			return true;
		
		if(root.getLeft() == null && root.getRight() == null) 
			return true;
		else if(root.getLeft()!=null && root.getRight()!=null)
			return isComplete(root.getLeft()) && isComplete(root.getRight());
		else 
			return false;
		
	}
 	
}

