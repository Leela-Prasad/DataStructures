package com.datastructures.LinkedList.problems;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastructures.LinkedList.implementation.LinkedList;
import com.datastructures.LinkedList.implementation.Node;

public class LinkedListProblemsTest {

	private LinkedListProblems problems;
	private LinkedList ll;
	
	@Before
	public void setUp() throws Exception {
		problems = new LinkedListProblems();
		ll = new LinkedList();
		ll.insert(10);
		ll.insert(20);
		ll.insert(30);
		ll.insert(40);
		ll.insert(50);
		ll.insert(60);
	}

	@After
	public void tearDown() throws Exception {
		problems=null;
		ll=null;
	}

	@Test
	public void testPrintLLInReverseOrder() {
		problems.printLLInReverseOrder(ll.getHead());
	}
	
	@Test
	public void testPrintLLInReverseOrderIterativeApproach() {
		problems.printLLInReverseOrderIterativeApproach(ll.getHead());
	}
	
	@Test
	public void testReverse() {
		Node head = problems.reverse(ll.getHead());
		problems.printNodes(head);
	}
	
	@Test
	public void testFindMiddleNode() {
		Node middleNode = problems.findMiddleNode(ll.getHead());
		assertEquals(new Integer(30),middleNode.getData());
		ll.insert(70);
		middleNode = problems.findMiddleNode(ll.getHead());
		assertEquals(new Integer(40),middleNode.getData());
	}
	
	@Test
	public void testFindKthNodeFromEnd() {
		assertEquals(new Integer(30),problems.findKthNodeFromEnd(ll.getHead(), 3).getData());
		assertEquals(new Integer(50),problems.findKthNodeFromEnd(ll.getHead(), 5).getData());
		assertNull(problems.findKthNodeFromEnd(ll.getHead(), 9));	
	}
	
	@Test
	public void testIsLoopExist() {
		
		assertFalse(problems.isLoopExist(ll.getHead()));
		Node current = ll.getHead();
		while(current.getNext()!=null) 
			current=current.getNext();
		current.setNext(ll.getHead().getNext());
		
		assertTrue(problems.isLoopExist(ll.getHead()));	
	}
	
	@Test
	public void testGetFirstNodeOfLoop() {
		
		Node current = ll.getHead();
		while(current.getNext()!=null) 
			current=current.getNext();
		current.setNext(ll.getHead().getNext());
		
		assertEquals(new Integer(50),problems.getFirstNodeOfLoop(ll.getHead()).getData());	
	}
	
	@Test
	public void testGetLength() {
		assertEquals(new Integer(6),problems.getLength(ll.getHead()));
	}
	
	@Test
	public void testAddLinkedLists() {
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ll1.insert(7);
		ll1.insert(0);
		ll1.insert(0);
		ll1.insert(1);
		
		ll2.insert(3);
		ll2.insert(9);
		Node head = problems.addLinkedLists(ll1.getHead(), ll2.getHead());
		Node current = head;
		System.out.println();
		while(current!=null) {
			System.out.print(current.getData() + "\t");
			current = current.getNext();
		}
	}
	
	@Test
	public void testGetInsertionNodeOfLinkedLists() {
		LinkedList list1 =new LinkedList(new Node(1));
		list1.getHead().setNext(new Node(10));
		list1.getHead().getNext().setNext(new Node(20));
		list1.getHead().getNext().getNext().setNext(new Node(30));
		list1.getHead().getNext().getNext().getNext().setNext(new Node(40));
		list1.getHead().getNext().getNext().getNext().getNext().setNext(new Node(50));
		LinkedList list2 =new LinkedList(new Node(5));
		list2.getHead().setNext(new Node(15));
		list2.getHead().getNext().setNext(list1.getHead().getNext().getNext().getNext());
		
		/*Node current=list2.getHead();
		while(current!=null) {
			System.out.print(current.getData() + "\t");
			current=current.getNext();
		}*/
			
		assertEquals(new Integer(30),problems.getIntersectionNodeOfLinkedLists(list1.getHead(), list2.getHead()).getData());
	}
	
	@Test
	public void testGetIntersectionNodeOfLinkedListsUsingCircularListApproach() {
		LinkedList list1 =new LinkedList(new Node(1));
		list1.getHead().setNext(new Node(10));
		list1.getHead().getNext().setNext(new Node(20));
		list1.getHead().getNext().getNext().setNext(new Node(30));
		list1.getHead().getNext().getNext().getNext().setNext(new Node(40));
		list1.getHead().getNext().getNext().getNext().getNext().setNext(new Node(50));
		LinkedList list2 =new LinkedList(new Node(5));
		list2.getHead().setNext(new Node(15));
		list2.getHead().getNext().setNext(list1.getHead().getNext().getNext().getNext());
		
		assertEquals(new Integer(30),problems.getIntersectionNodeOfLinkedListsUsingCircularListApproach(list1.getHead(), list2.getHead()).getData());
	}
	
	@Test
	public void testAlternateSplitOfLinkedList() {
		LinkedList list = new LinkedList();
		list.insert(70);
		list.insert(60);
		list.insert(50);
		list.insert(40);
		list.insert(30);
		list.insert(20);
		list.insert(10);
		
		problems.alternateSplitOfLinkedList(list.getHead());
	}
	
	/*@Test
	public void testIsPalindrome() {
		problems.isPalindrome(ll.getHead())
	}
	
	@Test
	public void testGetMiddleNode() {
		LinkedList list = new LinkedList();
		list.insert(70);
		list.insert(60);
		list.insert(50);
		list.insert(40);
		list.insert(30);
		list.insert(20);
		list.insert(10);
		System.out.println(problems.getMiddleNode(list.getHead()).getData());
	}*/
	
	@Test
	public void testMerge2SortedLinkedList() {
		LinkedList list1 = new LinkedList();
		list1.insertAtEnd(5);
		list1.insertAtEnd(8);
		list1.insertAtEnd(10);
		list1.insertAtEnd(32);
		LinkedList list2 = new LinkedList();
		list2.insertAtEnd(1);
		list2.insertAtEnd(3);
		list2.insertAtEnd(6);
		list2.insertAtEnd(10);
		list2.insertAtEnd(15);
		list2.insertAtEnd(25);
		list2.insertAtEnd(35);
		
		Node mergeList = problems.merge2SortedLinkedList(list1.getHead(), list2.getHead());
		problems.printNodes(mergeList);
	}
	
	@Test
	public void testMergeKSortedLinkedListsUsingMinHeap() {
		
		LinkedList list1 = new LinkedList();
		list1.insertAtEnd(1);
		list1.insertAtEnd(5);
		list1.insertAtEnd(10);
		list1.insertAtEnd(17);
		list1.insertAtEnd(40);
		
		LinkedList list2 = new LinkedList();
		list2.insertAtEnd(7);
		list2.insertAtEnd(13);
		list2.insertAtEnd(15);
		list2.insertAtEnd(17);
		list2.insertAtEnd(20);
		
		LinkedList list3 = new LinkedList();
		list3.insertAtEnd(5);
		list3.insertAtEnd(8);
		list3.insertAtEnd(13);
		list3.insertAtEnd(15);
		list3.insertAtEnd(19);
		
		LinkedList list4 = new LinkedList();
		list4.insertAtEnd(4);
		list4.insertAtEnd(6);
		list4.insertAtEnd(12);
		list4.insertAtEnd(16);
		list4.insertAtEnd(18);
		list4.insertAtEnd(25);
		
		Node[] lists = new Node[4];
		lists[0]=list1.getHead();
		lists[1]=list2.getHead();
		lists[2]=list3.getHead();
		lists[3]=list4.getHead();
		
		Node mergeList = problems.mergeKSortedLinkedListsUsingMinHeap(lists);
		problems.printNodes(mergeList);
	}

	@Test
	public void testmergeKSortedLinkedListsUsingMergeTechnique() {
		
		LinkedList list1 = new LinkedList();
		list1.insertAtEnd(1);
		list1.insertAtEnd(5);
		list1.insertAtEnd(10);
		list1.insertAtEnd(17);
		list1.insertAtEnd(40);
		
		LinkedList list2 = new LinkedList();
		list2.insertAtEnd(7);
		list2.insertAtEnd(13);
		list2.insertAtEnd(15);
		list2.insertAtEnd(17);
		list2.insertAtEnd(20);
		
		LinkedList list3 = new LinkedList();
		list3.insertAtEnd(5);
		list3.insertAtEnd(8);
		list3.insertAtEnd(13);
		list3.insertAtEnd(15);
		list3.insertAtEnd(19);
		
		LinkedList list4 = new LinkedList();
		list4.insertAtEnd(4);
		list4.insertAtEnd(6);
		list4.insertAtEnd(12);
		list4.insertAtEnd(16);
		list4.insertAtEnd(18);
		list4.insertAtEnd(25);
		
		Node[] lists = new Node[4];
		lists[0]=list1.getHead();
		lists[1]=list2.getHead();
		lists[2]=list3.getHead();
		lists[3]=list4.getHead();
		
		Node mergeList = problems.mergeKSortedLinkedListsUsingMergeTechnique(lists,3);
		problems.printNodes(mergeList);
	}
	
	@Test
	public void test() {
		System.out.println((int)Math.ceil(5.0/2));
	}

}
