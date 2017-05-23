package com.datastructures.stack.problems;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackUsingTwoQueuesTest {
	
	private StackUsingTwoQueues stack;
	
	@Before
	public void setup() {
		stack = new StackUsingTwoQueues();
	}
	
	@After
	public void tearDown() {
		stack=null;
	}
	
	@Test
	public void testPush_NullInput_NullPointerExceptionThrown() {
		assertFalse(stack.push(null));
	}
	
	@Test
	public void testPush_ValidInput_ReturnsTrue() {
		assertTrue(stack.push(10));
	}
	
	@Test
	public void testPop_PoppingElement_ReturnsNegativeValue() {
		assertEquals(new Integer(-1), stack.pop());
	}
	
	@Test
	public void testPop_PoppingElement_Executed() {
		stack.push(1);
		stack.push(2);
		
		assertNotNull(stack.pop());
		
	}
	
	@Test
	public void testSize() {

		for(int i=0;i<10;++i) {
			stack.push(i);
		}
		assertEquals(new Integer(10), stack.size());
		
	}
	
	@Test
	public void isEmpty_valid_returnsTrue() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void isEmpty_Invalid_returnsFalse() {

		stack.push(10);
		assertFalse(stack.isEmpty());
		
	}

}
