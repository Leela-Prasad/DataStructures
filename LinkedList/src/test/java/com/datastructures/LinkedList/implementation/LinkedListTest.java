package com.datastructures.LinkedList.implementation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private LinkedList ll;
	
	@Before
	public void setUp() throws Exception {
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
		ll=null;
	}
	
	@Test
	public void testInsert() {
		System.out.println("Inserted 70 at begining of the list");
		assertTrue(ll.insert(70));
		ll.printNodes();
	}
	
	@Test
	public void testInsertAtEnd() {
		System.out.println("Inserted 80 at end of the list");
		assertTrue(ll.insertAtEnd(80));
		ll.printNodes();
	}
	
	@Test
	public void testInsertAfterNode() {
		System.out.println("Inserted 100 after 30");
		assertTrue(ll.insertAfterNode(30, 100));
		ll.printNodes();
		System.out.println("Inserted 200 after 1000");
		assertTrue(ll.insertAfterNode(200, 1000));
		ll.printNodes();
	}

	@Test
	public void testDelete() {
		System.out.println("Deleting First element");
		assertTrue(ll.delete());
		ll.printNodes();
	}
	
	@Test
	public void testdeleteFromLast() {
		System.out.println("Deleting Last element");
		assertTrue(ll.deleteFromLast());
		ll.printNodes();
	}
	
	@Test
	public void testDeleteNode() {
		System.out.println("Deleting Node 50");
		assertTrue(ll.deleteNode(50));
		ll.printNodes();
		System.out.println("Deleting Node 20");
		assertTrue(ll.deleteNode(20));
		ll.printNodes();
		System.out.println("Deleting Node 100");
		assertFalse(ll.deleteNode(100));
		ll.printNodes();
	}

}
