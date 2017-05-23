package com.datastructures.queue.implementation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueueUsingTwoStacksTest {

	private IQueue queue; 
	
	@Before
	public void setup() {
		queue=new QueueUsingTwoStacks();
	}
	
	@After
	public void tearDown() {
		queue=null;
	}
	
	@Test(expected=NullPointerException.class)
	public void testEnQueue_NullInput_ExceptionThrown() {
		queue.enQueue(null);
	}
	
	@Test
	public void testEnQueue_LimitNotExceeded_ReturnsTrue() {
		assertTrue(queue.enQueue(1));
	}
	
	@Test
	public void testDeQueue_EmptyQueue_ReturnsNegativeValue() {
		assertEquals(new Integer(-1),queue.deQueue());
	}
	
	@Test
	public void testDeQueue_NotEmptyQueue_ReturnsElementValue() {
		
		for(int i=0;i<10;++i) {
			queue.enQueue(i);
		}
		
		assertNotNull(queue.deQueue());
	}
	
	@Test
	public void testSize() {
		for(int i=0;i<3;++i) {
			queue.enQueue(i);
		}
		
		assertEquals(new Integer(3), queue.size());
	}

	@Test
	public void testIsEmpty_EmptyQueue_ReturnsTrue() {
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testIsEmpty_NotEmptyQueue_ReturnsFalse() {
		for(int i=0;i<3;++i) {
			queue.enQueue(i);
		}
		assertFalse(queue.isEmpty());
	}

}
