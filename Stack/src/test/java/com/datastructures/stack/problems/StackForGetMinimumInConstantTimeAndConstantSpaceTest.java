package com.datastructures.stack.problems;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackForGetMinimumInConstantTimeAndConstantSpaceTest {

private StackForGetMinimumInConstantTimeAndConstantSpace stack;
	
	@Before
	public void setUp() throws Exception {
		stack=new StackForGetMinimumInConstantTimeAndConstantSpace();
		stack.push(10);
		stack.push(6);
		stack.push(20);
		stack.push(25);
		stack.push(5);
	}

	@After
	public void tearDown() throws Exception {
		stack=null;
	}

	@Test
	public void testGetMinimum_Distinct_Elements_In_Input() {
		assertEquals(new Integer(5),stack.getMinimum());
		stack.pop();
		assertEquals(new Integer(6),stack.getMinimum());
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(new Integer(10),stack.getMinimum());
	}
	
	@Test
	public void testGetMinimum_Duplicate_Elements_In_Input() {
		stack=new StackForGetMinimumInConstantTimeAndConstantSpace();
		stack.push(10);
		stack.push(6);
		stack.push(20);
		stack.push(6);
		assertEquals(new Integer(6),stack.getMinimum());
		stack.pop();
		assertEquals(new Integer(6),stack.getMinimum());
		stack.pop();
		stack.pop();
		assertEquals(new Integer(10),stack.getMinimum());
		
	}

}
