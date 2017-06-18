package com.datastructures.tree.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
	
	public void printNodesAtKthLevel(Node root,Integer k) {
		if(root == null) 
			return;
		
		printNodesAtKthLevel(root,k,0);
	}

	private void printNodesAtKthLevel(Node root, Integer k, Integer currentDistance) {
		
		if(root == null)
			return;
		
		if(k == currentDistance) {
			System.out.print(root.getData() + "\t");
			return;
		}
		printNodesAtKthLevel(root.getLeft(),k,currentDistance+1);
		printNodesAtKthLevel(root.getRight(),k,currentDistance+1);
		
	}
	
	/*public void printNodesAtKthDistanceFromGivenNode(Node root,Node node,Integer distance) {
		
		if(root == null || node == null)
			return;
		if(distance <= 0)
			return;
		
		//Node parent = getParent(root,node);
		ITree bst = new BinarySearchTree(root);
		if(bst.search(node.getData())) {
			printNodesAtKthDistanceFromGivenNode(node,parent,distance,0);
		}else {
			System.out.println(node.getData() + " is not present in Binary Tree");
		}
	}
	
	
	private void printNodesAtKthDistanceFromGivenNode(Node root, Node node, Node parent, Integer distance,Integer currentDistance) {
		if(root == null)
			return;
		
		if(currentDistance == distance) {
			System.out.print(root.getData() + "\t");
			return;
		}
		
		if(root.getLeft().getData().compareTo(parent.getData())==0) {
			printNodesAtKthDistanceFromGivenNode(root.getRight(),node,root,distance,currentDistance+1);
		}else if(root.getRight().getData().compareTo(parent.getData())==0) {
			printNodesAtKthDistanceFromGivenNode(root.getLeft(),node,root,distance,currentDistance+1);
		}else {
			printNodesAtKthDistanceFromGivenNode(root.getLeft(),node,root,distance,currentDistance+1);
			printNodesAtKthDistanceFromGivenNode(root.getRight(),node,root,distance,currentDistance+1);
		}
		
		
	}*/

	public Node getParent(Node root,Node node) {
		if(root == null || node == null)
			return null;
		
		return getParent(root,node,null);
	}

	private Node getParent(Node root, Node node, Node parent) {
		if(root ==null)
			return null;
		
		if(root.getData().compareTo(node.getData())==0) {
			return parent;
		}
		
		Node temp = getParent(root.getLeft(),node,root);
		if(temp!=null)
			return temp;
		return getParent(root.getRight(),node,root);
	}
	
	public void verticalOrderTraversal(Node root) {
		
		if(root == null)
			return;
		
		Map<Integer,List<Integer>> ht = new TreeMap<>();
		verticalOrderTraversal(root,ht,0);
		
		System.out.println(ht);
		
	}

	private void verticalOrderTraversal(Node root, Map<Integer, List<Integer>> ht,Integer hd) {
		
		if(root == null)
			return;
		
		if(ht.get(hd) == null) {
			List<Integer> list = new LinkedList<>();
			list.add(root.getData());
			ht.put(hd,list);
		}else {
			List<Integer> list = ht.get(hd);
			list.add(root.getData());
			ht.put(hd,list);
		}
		
		verticalOrderTraversal(root.getLeft(),ht,hd-1);
		verticalOrderTraversal(root.getRight(), ht, hd+1);
	}
	
	
	public Integer isSumTree(Node root) {
		
		if(root == null)
			return 0;
		
		if(root.getLeft()==null && root.getRight()==null)
			return root.getData();
		
		Integer leftSum = isSumTree(root.getLeft());
			if(leftSum == -1)
				return -1;
		Integer rightSum = isSumTree(root.getRight());
			if(rightSum == -1)
				return -1;
		if(root.getData() ==leftSum + rightSum) {
			return 2*root.getData();
		}
		return -1;
	}
	
	public Map<Integer,Integer> getVerticalSum(Node root) {
		if(root ==  null)
			return null;
		
		Map<Integer,Integer> verticalSumMap = new TreeMap<>();
		getVerticalSum(root,verticalSumMap,0);
		return verticalSumMap;
		
	}

	private void getVerticalSum(Node root, Map<Integer, Integer> verticalSumMap, Integer hd) {
		
		if(root == null || hd == null)
			return;
		if(verticalSumMap == null)
			verticalSumMap = new TreeMap<>();
		
		if(verticalSumMap.get(hd) == null) 
			verticalSumMap.put(hd, root.getData());
		else
			verticalSumMap.put(hd, verticalSumMap.get(hd) + root.getData());
		
		getVerticalSum(root.getLeft(),verticalSumMap,hd-1);
		getVerticalSum(root.getRight(),verticalSumMap,hd+1);
		
	}
	
	public void printTopView(Node root) {
		
		if(root == null)
			return;
		
		Map<Integer,Integer> topViewMap = new TreeMap<>();
		
		Queue<QueueItem> queue = new LinkedList<>();
		queue.offer(new QueueItem(root,0));
		
		while(!(queue.isEmpty())) {
			
			QueueItem temp = queue.poll();
			
			if(topViewMap.get(temp.hd) == null) {
				topViewMap.put(temp.hd, temp.node.getData());
			}
			
			if(temp.node.getLeft()!=null)
				queue.offer(new QueueItem(temp.node.getLeft(),temp.hd-1));
			if(temp.node.getRight()!=null)
				queue.offer(new QueueItem(temp.node.getRight(),temp.hd+1));
				
		}
		
		System.out.println(topViewMap);
	}
	
	public void printBottomView(Node root) {
		
		if(root == null)
			return;
		
		Map<Integer,Integer> topViewMap = new TreeMap<>();
		
		Queue<QueueItem> queue = new LinkedList<>();
		queue.offer(new QueueItem(root,0));
		
		while(!(queue.isEmpty())) {
			
			QueueItem temp = queue.poll();
			
			topViewMap.put(temp.hd, temp.node.getData());
			
			if(temp.node.getLeft()!=null)
				queue.offer(new QueueItem(temp.node.getLeft(),temp.hd-1));
			if(temp.node.getRight()!=null)
				queue.offer(new QueueItem(temp.node.getRight(),temp.hd+1));
				
		}
		
		System.out.println(topViewMap);
	}
	
	class QueueItem {
		private Node node;
		private Integer hd;
		
		public QueueItem(Node node, Integer hd) {
			this.node=node;
			this.hd=hd;
		}
	}
	
	private Integer maxLevel=0;
	
	public void printLeftView(Node root) {
		if(root == null)
			return;
		printLeftView(root,1);		
	}

	private void printLeftView(Node root, Integer level) {
		
		if(root == null || level == null || maxLevel == null)
			return;
		
		if(level > maxLevel) {
			maxLevel = level;
			System.out.print(root.getData() + "\t");
		}
		
		printLeftView(root.getLeft(),level+1);
		printLeftView(root.getRight(),level+1);
	}
	
	public void printRightView(Node root) {
		if(root == null)
			return;
		printRightView(root,1);
	}

	private void printRightView(Node root, Integer level) {
		
		if(root == null || level == null || maxLevel == null)
			return;
		
		if(level > maxLevel) {
			maxLevel = level;
			System.out.print(root.getData() + "\t");
		}
		
		printRightView(root.getRight(),level+1);
		printRightView(root.getLeft(),level+1);
	}
	
	public StringBuilder preOrderTraversal(Node node,StringBuilder preOrderSequence) {
		if(node==null)
			return preOrderSequence;

		preOrderSequence.append(node.getData() + ",");
		preOrderTraversal(node.getLeft(),preOrderSequence);
		preOrderTraversal(node.getRight(),preOrderSequence);
		return preOrderSequence;
		
	}
	
	public StringBuilder inOrderTraversal(Node node,StringBuilder inOrderSequence) {
		if(node==null)
			return inOrderSequence;
		
		inOrderTraversal(node.getLeft(),inOrderSequence);
		inOrderSequence.append(node.getData() + ",");
		inOrderTraversal(node.getRight(),inOrderSequence);
		return inOrderSequence;
	}
	
	public StringBuilder postOrderTraversal(Node node,StringBuilder postOrderSequence) {
		if(node==null)
			return postOrderSequence;
		
		postOrderTraversal(node.getLeft(),postOrderSequence);
		postOrderTraversal(node.getRight(),postOrderSequence);
		postOrderSequence.append(node.getData()+",");
		return postOrderSequence;
		
	}
	
	public boolean isSubTree(Node root1,Node root2) {
		if(root1 == null)
			return true;
		if(root2 == null)
			return false;
		
		String preOrderForRoot1 = preOrderTraversal(root1,new StringBuilder("")).toString();
		String preOrderForRoot2 = preOrderTraversal(root2,new StringBuilder("")).toString();
		
		String inOrderForRoot1 = inOrderTraversal(root1,new StringBuilder("")).toString();
		String inOrderForRoot2 = inOrderTraversal(root2,new StringBuilder("")).toString();
		return preOrderForRoot2.contains(preOrderForRoot1) && inOrderForRoot2.contains(inOrderForRoot1);
	}
	
	public void deletePathLessThanKFromRoot(Node root,Integer k) {
		ITree bst = new BinarySearchTree(root);
		deletePathLessThanKFromRoot(bst,root,k);
	}
	
	private Node deletePathLessThanKFromRoot(ITree bst,Node root,Integer k) {
		if(root == null)
			return null;
		if(k==0)
			return root;
		Node leftNode = deletePathLessThanKFromRoot(bst,root.getLeft(),k-1);
		Node rightNode = deletePathLessThanKFromRoot(bst,root.getRight(),k-1);
		if(leftNode == null && rightNode == null) {
			bst.delete(root.getData());
			return null;
		}
		return root;
	}
	
	public boolean isSiblings(Node root,Node node1,Node node2) {
		
		if(root == null || node1 == null || node2 == null)
			return false;
		
		if(root.getLeft()!=null && root.getRight()!=null) {
			if((root.getLeft().getData().equals(node1.getData()) && root.getRight().getData().equals(node2.getData())) ||
				(root.getLeft().getData().equals(node2.getData()) && root.getRight().getData().equals(node1.getData())))
					return true;
		}
		
		return isSiblings(root.getLeft(),node1,node2) || isSiblings(root.getRight(), node1, node2);
		
	}
	
	
	public Integer getLevel(Node root,Node node) {
		if(root == null || node == null)
			return -1;
		
		return getLevel(root,node,1);
	}
	
	
	
	private Integer getLevel(Node root, Node node, Integer level) {
		
		if(root == null)
			return -1;
		
		if(root.getData() == node.getData())
			return level;
		
		Integer leftLevel = getLevel(root.getLeft(),node,level+1);
		if(leftLevel!=-1)
			return leftLevel;
		return getLevel(root.getRight(),node,level+1);
		
	}

	public boolean isCousins(Node root,Node node1,Node node2) {
		
		if(root == null || node1 == null || node2 == null) 
			return false;
		
		return (getLevel(root,node1) == getLevel(root,node2)) && !isSiblings(root,node1,node2);
			
			
	}
	
/*	public Node isCousinsUsingLCAApproach(Node root,Integer node1,Integer node2) {
		if(root == null || node1 == null || node2 == null)
			return null;
		
		if(node1 == node2)
			return null;
		
		ITree bst = new BinarySearchTree(root);
		if(bst.search(node1) && bst.search(node2)) {
			Integer[] heightAndLCA = isCousinsUsingLCAApproachHelper(root,node1,node2);
			if(heightAndLCA[0] == heightAndLCA[1] && ())
			
		}
			
			
			return isCousinsUsingLCAApproachHelper(root,node1,node2);
		else
			return null;
		
	}
	
	private Integer[] isCousinsUsingLCAApproachHelper(Node root, Integer node1, Integer node2) {
		
		Integer[] heightAndLCA = {0,0,null};
		
		if(root == null) {
			heightAndLCA[0]=0;
			heightAndLCA[1]=0;
			heightAndLCA[2]=null;
			return heightAndLCA;
		}
		
		if(root.getLeft() == null && root.getRight() == null) {
			heightAndLCA[0]=1;
			heightAndLCA[1]=1;
			heightAndLCA[2]=null;
			return heightAndLCA;
		}
		
		if(root.getData() == node1 || root.getData() == node2) {
			heightAndLCA[0]=height(new Node(node1));	//TODO have to see alternative
			heightAndLCA[1]=height(new Node(node2));
			heightAndLCA[2]=root.getData();
			return heightAndLCA;
		}
		
		Integer[] leftHeightAndLCA = isCousinsUsingLCAApproachHelper(root.getLeft(),node1,node2);
		Integer[] rightHeightAndLCA = isCousinsUsingLCAApproachHelper(root.getRight(),node1,node2);
		
		heightAndLCA[0] = 1+Math.max(leftHeightAndLCA[0], rightHeightAndLCA[0]);
		heightAndLCA[1] = 1+Math.max(leftHeightAndLCA[1], rightHeightAndLCA[1]);
		
		if(leftHeightAndLCA[2]!=null && rightHeightAndLCA[2]!=null) {
			heightAndLCA[2]=root.getData();
			return heightAndLCA;
		}
		
		if(leftHeightAndLCA[2]!=null) {
			heightAndLCA[2]=leftHeightAndLCA[2];
			return heightAndLCA;
		}else {
			heightAndLCA[2]=rightHeightAndLCA[2];
			return heightAndLCA;
		}
	
	}*/

	public Node constructBSTFromSortedArray(Integer[] elements) {
		if(elements == null)
			return null;
		
		return constructBSTFromSortedArray(elements,0,elements.length-1);
	}

	private Node constructBSTFromSortedArray(Integer[] elements, Integer start, Integer end) {
		if(start>end)
			return null;
		
		Integer middle = start + (end -start)/2;
		Node root = new Node(elements[middle]);
		root.setLeft(constructBSTFromSortedArray(elements,start,middle-1));
		root.setRight(constructBSTFromSortedArray(elements,middle+1,end));
		
		return root;
	}
	
}
