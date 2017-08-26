package com.datastructures.heap.problems;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastructures.heap.implementation.MaxHeap;

public class MaxHeapProblemsTest {

	private MaxHeap heap;
	private MaxHeapProblems problems;
	
	@Before
	public void setUp() throws Exception {
		heap = new MaxHeap();
		problems = new MaxHeapProblems();
	}

	@After
	public void tearDown() throws Exception {
		heap=null;
		problems=null;
	}

	@Test
	public void testFindMinimum() {
		Integer[] input = {1,14,10,8,7,9,3,2,4,6};
		Integer[] maxHeap = heap.buildHeap(input);
		assertEquals(new Integer(1),problems.findMinimum(maxHeap));
	}
	
	@Test
	public void testDeleteArbitaryElement() {
		Integer[] input = {1,14,10,8,7,9,3,2,4,6};
		Integer[] maxHeap = heap.buildHeap(input);
		assertTrue(problems.deleteArbitaryElement(maxHeap, 9));
		heap.printHeap(maxHeap);
		assertFalse(problems.deleteArbitaryElement(maxHeap, 50));
	}
	
	@Test
	public void testPrintKLargestElements() {
		Integer[] input = {1,14,10,8,7,9,3,2,4,6};
		problems.printKLargestElements(input, 3);
	}

}
