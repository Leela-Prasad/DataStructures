package com.datastructures.stack.problems;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClosestGreatestValueTest {

	private ClosestGreatestValue cgv;
	
	@Before
	public void setUp() throws Exception {
		cgv=new ClosestGreatestValue();
	}

	@After
	public void tearDown() throws Exception {
		cgv=null;
	}

	@Test
	public void testFindClosestGreatestValues() {
		Integer[] output = cgv.findClosestGreatestValues(new Integer[]{10,20,1,5,25,500,60});
		System.out.println(Arrays.toString(output));
		assertNotNull(output);
	}
	
	@Test
	public void testFindClosestGreatestValues_DecreasingOrder_Output_AllValues_IntegerMINValue() {
		Integer[] output = cgv.findClosestGreatestValues(new Integer[]{500,400,389,239,210,100,80,70});
		System.out.println(Arrays.toString(output));
		assertNotNull(output);
	}
	
	@Test
	public void testFindClosestGreatestValues_IncreasingOrder_Output_AdjacentValues() {
		Integer[] output = cgv.findClosestGreatestValues(new Integer[]{70,80,100,210,239,389,400,500});
		System.out.println(Arrays.toString(output));
		assertNotNull(output);
	}
	
	@Test
	public void testFindClosestGreatestValues_DuplicateValues() {
		Integer[] output = cgv.findClosestGreatestValues(new Integer[]{1,7,9,3,4,2,7,9,10});
		System.out.println(Arrays.toString(output));
		assertNotNull(output);
	}
	
	@Test
	public void testFindClosestGreatestValues_NullInput() {
		Integer[] output = cgv.findClosestGreatestValues(null);
		assertNull(output);
	}

}
