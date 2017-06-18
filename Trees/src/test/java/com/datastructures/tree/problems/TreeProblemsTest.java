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
	
	@Test
	public void testPrintNodesAtKthLevel() {
		treeProblems.printNodesAtKthLevel(bst.getRoot(), 3);
	}
	
	@Test
	public void testGetParent() {
		assertEquals(new Integer(62),treeProblems.getParent(bst.getRoot(), new Node(58)).getData());
		
		assertEquals(new Integer(20),treeProblems.getParent(bst.getRoot(), new Node(37)).getData());
		
		assertNull(treeProblems.getParent(bst.getRoot(), new Node(25)));
	}
	
	@Test
	public void testVerticalOrderTraversal() {
		treeProblems.verticalOrderTraversal(bst.getRoot());
	}
	
	@Test
	public void testIsSumTree_Valid() {
		bst = new BinarySearchTree();
		bst.insert(new Node(50));
		Node root = bst.getRoot();
		root.setLeft(new Node(15));
		root.setRight(new Node(10));
		root.getLeft().setLeft(new Node(10));
		root.getLeft().setRight(new Node(5));
		root.getRight().setLeft(new Node(7));
		root.getRight().setRight(new Node(3));
		assertNotEquals(new Integer(-1),treeProblems.isSumTree(bst.getRoot()));
	}
	
	
	@Test
	public void testIsSumTree_NotValid() {
		bst = new BinarySearchTree();
		bst.insert(new Node(50));
		Node root = bst.getRoot();
		root.setLeft(new Node(15));
		root.setRight(new Node(10));
		root.getLeft().setLeft(new Node(10));
		root.getLeft().setRight(new Node(5));
		root.getRight().setLeft(new Node(7));
		root.getRight().setRight(new Node(1));
		assertEquals(new Integer(-1),treeProblems.isSumTree(bst.getRoot()));
	}
	
	@Test
	public void testGetVerticalSum() {
		System.out.println(treeProblems.getVerticalSum(bst.getRoot()));
	}
	
	@Test
	public void testPrintTopView() {
		treeProblems.printTopView(bst.getRoot());
	}
	
	@Test
	public void testPrintBottomView() {
		treeProblems.printBottomView(bst.getRoot());
	}
	
	@Test
	public void testPrintLeftView() {
		treeProblems.printLeftView(bst.getRoot());
	}
	
	@Test
	public void testPrintRightView() {
		treeProblems.printRightView(bst.getRoot());
	}
	
	@Test
	public void testPreOrderTraversal() {
		System.out.println(treeProblems.preOrderTraversal(bst.getRoot(), new StringBuilder()));
	}
	
	@Test
	public void testInOrderTraversal() {
		System.out.println(treeProblems.inOrderTraversal(bst.getRoot(), new StringBuilder()));
	}
	
	@Test
	public void testPostOrderTraversal() {
		System.out.println(treeProblems.postOrderTraversal(bst.getRoot(), new StringBuilder()));
	}
	
	@Test
	public void testIsSubTree_Valid() {
		ITree bst2 = new BinarySearchTree();
		bst2.insert(new Node(20));
		bst2.getRoot().setRight(new Node(37));
		bst2.getRoot().getRight().setLeft(new Node(24));
		assertTrue(treeProblems.isSubTree(bst2.getRoot(), bst.getRoot()));
		
	}
	
	@Test
	public void testIsSubTree_Invalid() {
		ITree bst2 = new BinarySearchTree();
		bst2.insert(new Node(20));
		bst2.getRoot().setRight(new Node(37));
		bst2.getRoot().getRight().setLeft(new Node(24));
		bst2.getRoot().getRight().getLeft().setLeft(new Node(100));
		assertFalse(treeProblems.isSubTree(bst2.getRoot(), bst.getRoot()));
		
	}
	
	@Test
	public void testDeletePathLessThanKFromRoot() {
		treeProblems.deletePathLessThanKFromRoot(bst.getRoot(), 4);
		bst.levelOrderTraversal();
	}
	
	@Test
	public void testDeletePathLessThanKFromRoot2() {
		treeProblems.deletePathLessThanKFromRoot(bst.getRoot(), 3);
		bst.levelOrderTraversal();
	}
	
	@Test
	public void testIsSiblings() {
		assertTrue(treeProblems.isSiblings(bst.getRoot(), new Node(5), new Node(20)));
		assertTrue(treeProblems.isSiblings(bst.getRoot(), new Node(3), new Node(8)));
		assertFalse(treeProblems.isSiblings(bst.getRoot(), new Node(37), new Node(60)));
	}
	
	@Test
	public void testGetLevel() {
		assertEquals(new Integer(3),treeProblems.getLevel(bst.getRoot(), new Node(58)));
		assertEquals(new Integer(5),treeProblems.getLevel(bst.getRoot(), new Node(24)));
	}
	
	@Test
	public void testIsCousins() {
		assertTrue(treeProblems.isCousins(bst.getRoot(), new Node(5), new Node(58)));
		assertTrue(treeProblems.isCousins(bst.getRoot(), new Node(8), new Node(37)));
		assertFalse(treeProblems.isCousins(bst.getRoot(), new Node(15), new Node(91)));
	}
	
	@Test
	public void testConstructBSTFromSortedArray() {
		Integer[] elements = {10,20,30,40,50,60,70};
		ITree bst = new BinarySearchTree(treeProblems.constructBSTFromSortedArray(elements));
		bst.levelOrderTraversal();
	}
	
	@Test
	public void testConstructBSTFromSortedArray2() {
		Integer[] elements = {10,20,30,40,50,60,70,80};
		ITree bst = new BinarySearchTree(treeProblems.constructBSTFromSortedArray(elements));
		bst.levelOrderTraversal();
	}
	
}
