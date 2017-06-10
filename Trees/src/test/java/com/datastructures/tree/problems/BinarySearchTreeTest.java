package com.datastructures.tree.problems;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastructures.domain.Node;
import com.datastructures.tree.implementation.BinarySearchTree;
import com.datastructures.tree.implementation.ITree;

public class BinarySearchTreeTest {

	private ITree bst;
	
	@Before
	public void setUp() throws Exception {
		
		bst = new BinarySearchTree();
		bst.insert(new Node(50));
		bst.insert(new Node(15));
		bst.insert(new Node(62));
		bst.insert(new Node(5));
		bst.insert(new Node(20));
		bst.insert(new Node(58));
		bst.insert(new Node(91));
		bst.insert(new Node(3));
		bst.insert(new Node(8));
		bst.insert(new Node(37));
		bst.insert(new Node(60));
		bst.insert(new Node(24));
		
	}

	@After
	public void tearDown() throws Exception {
		bst=null;
	}

	@Test
	public void testPreOrderTraversal() {
		System.out.println("\nPre Order Traversal Test case method");
		bst.preOrderTraversal(bst.getRoot());
	}

	@Test
	public void testInOrderTraversal() {
		System.out.println("\nInOrder Traversal Test case method");
		bst.inOrderTraversal(bst.getRoot());
	}
	
	@Test
	public void testPostOrderTraversal() {
		System.out.println("\nPost Order Traversal Test case method");
		bst.postOrderTraversal(bst.getRoot());
	}
	
	@Test
	public void testLevelOrderTraversal() {
		System.out.println("\n Level Order Traversal Test case method");
		bst.levelOrderTraversal();
	}
	
	@Test
	public void testSearch() {
		assertFalse(bst.search(null));
		assertTrue(bst.search(8));
		assertFalse(bst.search(100));
		assertTrue(bst.search(91));
		assertFalse(bst.search(-5));
	}
	
	@Test
	public void testFindMinimum() {
		assertEquals(new Integer(3),bst.findMinimum(bst.getRoot()).getData());
		assertEquals(new Integer(3),bst.findMinimum(bst.getRoot().getLeft()).getData());
		assertEquals(new Integer(58),bst.findMinimum(bst.getRoot().getRight()).getData());
		assertEquals(null,bst.findMinimum(null));
	}
	
	@Test
	public void testFindMaximum() {
		assertEquals(new Integer(91),bst.findMaximum(bst.getRoot()).getData());
		assertEquals(new Integer(37),bst.findMaximum(bst.getRoot().getLeft()).getData());
		assertEquals(new Integer(91),bst.findMaximum(bst.getRoot().getRight()).getData());
		assertEquals(null,bst.findMinimum(null));
	}
	
	@Test
	public void testInorderPrecedor() {
		assertEquals(new Integer(37),bst.inorderPrecedor(bst.getRoot()).getData());
		assertEquals(new Integer(8),bst.inorderPrecedor(bst.getRoot().getLeft()).getData());
		assertEquals(new Integer(60),bst.inorderPrecedor(bst.getRoot().getRight()).getData());
	}
	
	@Test
	public void testInorderSuccessor() {
		assertEquals(new Integer(58),bst.inorderSuccessor(bst.getRoot()).getData());
		assertEquals(new Integer(20),bst.inorderSuccessor(bst.getRoot().getLeft()).getData());
		assertEquals(new Integer(91),bst.inorderSuccessor(bst.getRoot().getRight()).getData());
	}
	
	@Test
	public void testIsComplete() {
		assertFalse(bst.isComplete(bst.getRoot()));
		bst = new BinarySearchTree();
		bst.insert(new Node(50));
		bst.insert(new Node(15));
		bst.insert(new Node(62));
		bst.insert(new Node(5));
		bst.insert(new Node(20));
		bst.insert(new Node(58));
		bst.insert(new Node(91));
		bst.insert(new Node(3));
		bst.insert(new Node(8));
		assertTrue(bst.isComplete(bst.getRoot()));	
	}
	
	@Test
	public void testDelete() {
		TreeProblems problems = new TreeProblems();
		bst.levelOrderTraversal();
		assertEquals(new Integer(12),problems.findNumberOfNodes(bst.getRoot()));
		bst.delete(20);
		System.out.println();
		bst.levelOrderTraversal();
		assertEquals(new Integer(11),problems.findNumberOfNodes(bst.getRoot()));
		bst.delete(60);
		System.out.println();
		bst.levelOrderTraversal();
		assertEquals(new Integer(10),problems.findNumberOfNodes(bst.getRoot()));
		bst.delete(15);
		System.out.println();
		bst.levelOrderTraversal();
		assertEquals(new Integer(9),problems.findNumberOfNodes(bst.getRoot()));
		bst.delete(62);
		System.out.println();
		bst.levelOrderTraversal();
		assertEquals(new Integer(8),problems.findNumberOfNodes(bst.getRoot()));
	}
	
}
