package com.datastructures.tree.problems;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastructures.domain.Node;
import com.datastructures.tree.implementation.BinarySearchTree;
import com.datastructures.tree.implementation.ITree;

public class TreeProblemsTest {

	private TreeProblems treeProblems;
	private ITree bst;
	
	@Before
	public void setUp() throws Exception {
		treeProblems = new TreeProblems();
		
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
		treeProblems = null;
		bst=null;
	}

	@Test
	public void testFindNumberOfNodes() {
		assertEquals(new Integer(12),treeProblems.findNumberOfNodes(bst.getRoot()));
	}
	
	@Test
	public void testFindNumberOfLeafNodes() {
		assertEquals(new Integer(5),treeProblems.findNumberOfLeafNodes(bst.getRoot()));
	}
	
	@Test
	public void testFindNumberOfNonLeafNodes() {
		assertEquals(new Integer(7),treeProblems.findNumberOfNonLeafNodes(bst.getRoot()));
	}
	
	@Test
	public void testFindNumberOfFullNodes() {
		assertEquals(new Integer(4),treeProblems.findNumberOfFullNodes(bst.getRoot()));
	}
	
	@Test
	public void testHeight() {
		assertEquals(new Integer(4),treeProblems.height(bst.getRoot()));
		assertEquals(new Integer(3),treeProblems.height(bst.getRoot().getLeft()));
		assertEquals(new Integer(2),treeProblems.height(bst.getRoot().getRight()));
	}
	
	@Test
	public void testIsIdentical_InputTrees_Identical_ReturnsTrue() {
		assertTrue(treeProblems.isIdentical(bst.getRoot(), bst.getRoot()));
	}
	
	@Test
	public void testIsIdentical_InputTrees_NotIdentical_ReturnsFalse() {
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.insert(new Node(50));
		bst2.insert(new Node(15));
		bst2.insert(new Node(62));
		bst2.insert(new Node(5));
		bst2.insert(new Node(20));
		bst2.insert(new Node(58));
		bst2.insert(new Node(91));
		bst2.insert(new Node(3));
		bst2.insert(new Node(8));
		bst2.insert(new Node(37));
		bst2.insert(new Node(60));
		bst2.insert(new Node(24));
		assertTrue(treeProblems.isIdentical(bst.getRoot(), bst2.getRoot()));
	}
	
	@Test
	public void testConstructMirrorTree() {
		treeProblems.constructMirrorTree(bst.getRoot());
		bst.levelOrderTraversal();
	}
	
	@Test
	public void testFindLCA() {
		assertEquals(new Integer(50),treeProblems.findLCA(bst.getRoot(), 20, 60));
	}

	@Test
	public void testFindLCA_OneElementMatchedDuringSearch_ReturnsMatchedElement() {
		assertEquals(new Integer(5),treeProblems.findLCA(bst.getRoot(), 5, 8));
	}
	
	@Test
	public void testFindLCA_BothElementsEqual_ReturnsEqualElement() {
		assertEquals(new Integer(15),treeProblems.findLCA(bst.getRoot(), 15, 15));
	}
	
	@Test
	public void testFindLCA_OneElementNotPresent_ReturnsNull() {
		assertNull(treeProblems.findLCA(bst.getRoot(), 100, 15));
	}
	
	@Test
	public void testFindLCAInBT() {
		assertEquals(new Integer(50),treeProblems.findLCAInBT(bst.getRoot(), 20, 60));
	}

	@Test
	public void testFindLCAInBT_OneElementMatchedDuringSearch_ReturnsMatchedElement() {
		assertEquals(new Integer(5),treeProblems.findLCAInBT(bst.getRoot(), 5, 8));
	}
	
	@Test
	public void testFindLCAInBT_BothElementsEqual_ReturnsEqualElement() {
		assertEquals(new Integer(15),treeProblems.findLCAInBT(bst.getRoot(), 15, 15));
	}
	
	@Test
	public void testFindLCAInBT_OneElementNotPresent_ReturnsNull() {
		assertNull(treeProblems.findLCAInBT(bst.getRoot(), 100, 15));
	}
	
	@Test
	public void testFindDiameter() {
		Integer[] heightAndDiameter = treeProblems.findDiameter(bst.getRoot());
		assertEquals(new Integer(5),heightAndDiameter[0]);
		assertEquals(new Integer(8),heightAndDiameter[1]);
		
		Integer[] heightAndDiameter1 = treeProblems.findDiameter(bst.getRoot().getLeft());
		assertEquals(new Integer(4),heightAndDiameter1[0]);
		assertEquals(new Integer(6),heightAndDiameter1[1]);
		
		Integer[] heightAndDiameter2 = treeProblems.findDiameter(bst.getRoot().getRight());
		assertEquals(new Integer(3),heightAndDiameter2[0]);
		assertEquals(new Integer(4),heightAndDiameter2[1]);
	}
	
	@Test
	public void testFindNodeLevel() {
		assertEquals(new Integer(4),treeProblems.findNodeLevel(bst.getRoot(), 37));
		assertEquals(new Integer(-1),treeProblems.findNodeLevel(bst.getRoot(), 100));
	}
}
