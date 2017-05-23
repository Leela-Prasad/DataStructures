package com.datastructures.stack.problems;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StockSpanProblemTest {

	private StockSpanProblem spanProblem;
	@Before
	public void setUp() throws Exception {
		spanProblem=new StockSpanProblem();
	}

	@After
	public void tearDown() throws Exception {
		spanProblem=null;
	}

	@Test
	public void testFindSpan() {
		Integer[] span = spanProblem.findSpan(new Integer[]{100,30,10,20,25,40,26,35,45,150});
		System.out.println(Arrays.toString(span));
		assertNotNull(span);
	}
	
	@Test
	public void testFindSpan2() {
		Integer[] span = spanProblem.findSpan(new Integer[]{10,2,3,15,22,9,25,29});
		System.out.println(Arrays.toString(span));
		assertNotNull(span);
	}
	
	@Test
	public void testFindSpan_NullInput_ReturnsNull() {
		Integer[] span = spanProblem.findSpan(null);
		assertNull(span);
	}

}
