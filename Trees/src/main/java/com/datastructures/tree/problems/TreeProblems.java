package com.datastructures.tree.problems;

import com.datastructures.domain.Node;
import com.datastructures.tree.implementation.BinarySearchTree;
import com.datastructures.tree.implementation.ITree;

public class TreeProblems {

	public Integer findNumberOfNodes(Node node) {
		
		if(node == null) 
			return 0;
		return 1 + findNumberOfNodes(node.getLeft()) + findNumberOfNodes(node.getRight());
		
	}
	
	public Integer findNumberOfLeafNodes(Node node) {
		
		if(node == null)
			return 0;
		
		if(node.getLeft() == null && node.getRight() == null)
			return 1;
		return findNumberOfLeafNodes(node.getLeft()) + findNumberOfLeafNodes(node.getRight());
		
	}
	
	public Integer findNumberOfNonLeafNodes(Node node) {
		
		if(node == null)
			return 0;
		
		if(node.getLeft() == null && node.getRight() == null)
			return 0;
		return 1 + findNumberOfNonLeafNodes(node.getLeft()) + findNumberOfNonLeafNodes(node.getRight());
	}
	
	public Integer findNumberOfFullNodes(Node node) {
		if(node == null)
			return 0;
		
		if(node.getLeft() == null && node.getRight() == null)
			return 0;
		
		if(node.getLeft() !=null && node.getRight()!=null) 
			return 1 + findNumberOfFullNodes(node.getLeft()) + findNumberOfFullNodes(node.getRight());;
		
		return findNumberOfFullNodes(node.getLeft()) + findNumberOfFullNodes(node.getRight());
		
	}
	
	public Integer height(Node node) {
		if(node == null)
			return 0;
		if(node.getLeft() == null & node.getRight() == null)
			return 0;
		return 1 + Math.max(height(node.getLeft()), height(node.getRight()));	
		
	}
	
	public boolean isIdentical(Node node1,Node node2) {
		if(node1 == null && node2 == null)
			return true;
		
		if(node1!=null && node2!=null && node1.getData().compareTo(node2.getData())==0) {
			return isIdentical(node1.getLeft(),node2.getLeft()) && isIdentical(node1.getRight(), node2.getRight());
		}
		else {
			return false;
		}
	}
	
	public void constructMirrorTree(Node node) {
		if(node == null)
			return;
		
		constructMirrorTree(node.getLeft());
		constructMirrorTree(node.getRight());
		swap(node);
	}

	private void swap(Node node) {
		Node temp = node.getLeft();
		node.setLeft(node.getRight());
		node.setRight(temp);
	}
	
	public Integer findLCA(Node root,Integer element1,Integer element2) {
		ITree bst = new BinarySearchTree(root);
		
		if(root==null)
			return null;
		if(element1==element2)
			return element1;
		if(!(bst.search(element1) && bst.search(element2)))
			return null;
		
		return findLCAHelper(root,element1,element2);
			
	}

	/**
	 * 
	 * @param root
	 * @param element1
	 * @param element2
	 * @return
	 * 
	 * If Tree has duplicate values then this method 
	 * will give ambigous values.
	 */
	private Integer findLCAHelper(Node root, Integer element1, Integer element2) {
		
		if(root==null)
			return null;
		
		if(root.getData().compareTo(element1)<0 && root.getData().compareTo(element2)<0)
			return findLCAHelper(root.getRight(),element1,element2);
		if(root.getData().compareTo(element1)>0 && root.getData().compareTo(element2)>0)
			return findLCAHelper(root.getLeft(),element1,element2);
		return root.getData();
	}
	
	public Integer findLCAInBT(Node root,Integer element1,Integer element2) {
		
		if(root == null)
			return null;
		
		if(element1 == element2)
			return element1;
		
		ITree bst = new BinarySearchTree(root);
		
		if(!(bst.search(element1) && bst.search(element2)))
			return null;
		
		return findLCAInBTHelper(root,element1,element2);
	}

	/**
	 * 
	 * @param root
	 * @param element1
	 * @param element2
	 * @return
	 * 
	 * If Tree has duplicate values then this method 
	 * will give ambigous values.
	 */
	
	private Integer findLCAInBTHelper(Node root, Integer element1, Integer element2) {
		
		if(root == null)
			return null;
		
		if(element1.compareTo(root.getData()) == 0 || element2.compareTo(root.getData()) == 0)
			return element1;

		Integer left = findLCAInBTHelper(root.getLeft(),element1,element2);
		Integer right = findLCAInBTHelper(root.getRight(),element1,element2);
		
		if(left!=null && right!=null)
			return root.getData();
		
		return (left!=null)?left:right;
		
	}
	
	
	/**
	 * 
	 * @param root
	 * @return
	 * 
	 * Here Diameter will be maximum of the following
	 * 1. Height of LST + Height of RST + 1
	 * 2. Diameter of LST
	 * 3. Diameter of RST
	 * 
	 * In the below program heightAndDiameter[] will hold 2 values
	 * 0 index will indicate height and 1 index will indicate diameter 
	 */
	public Integer[] findDiameter(Node root) {
		
		Integer[] heightAndDiameter = {0,0};
		
		if(root == null)
			return heightAndDiameter;
		
		if(root.getLeft() == null && root.getRight() == null) {
			heightAndDiameter[0]=1;
			heightAndDiameter[1]=1;
			return heightAndDiameter;
		}
		
		Integer[] LeftHeightAndDiameter = findDiameter(root.getLeft());
		Integer[] rightHeightAndDiameter = findDiameter(root.getRight());
		
		Integer height = 1 + Math.max(LeftHeightAndDiameter[0], rightHeightAndDiameter[0]);
		Integer diameter = Math.max(LeftHeightAndDiameter[0]+rightHeightAndDiameter[0]+1, Math.max(LeftHeightAndDiameter[1], rightHeightAndDiameter[1]));
		
		heightAndDiameter[0]=height;
		heightAndDiameter[1]=diameter;
		
		return heightAndDiameter;
	}
	
	/**
	 * 
	 * @param root
	 * @param key
	 * @return
	 * Assumption : Root Node is at Level 1
	 */
	public Integer findNodeLevel(Node root,Integer key) {
		
		if(root == null || key == null)
			return -1;
		
		return findNodeLevel(root,1,key);
	}

	private Integer findNodeLevel(Node root, int level, Integer key) {
		
		if(root == null)
			return -1;
		
		if(key.compareTo(root.getData())==0)
			return level;
		
		Integer leftLevel = findNodeLevel(root.getLeft(),level+1,key);
		
		if(leftLevel!=-1)
			return leftLevel;
	
		return findNodeLevel(root.getRight(),level+1,key);
	
	}
	
}
