package com.datastructures.heap.implementation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MaxHeapTest {
	
	private MaxHeap heap;
	
	@Before
	public void setUp() throws Exception {
		heap = new MaxHeap();
	}

	@After
	public void tearDown() throws Exception {
		heap=null;
	}

	@Test
	public void testBuildHeap() {
		Integer[] input = {1,14,10,8,7,9,3,2,4,6};
		Integer[] maxHeap = heap.buildHeap(input);
		heap.printHeap(maxHeap);
	}
	
	@Test 
	public void testFindMax() {
		Integer[] input = {1,14,10,8,7,9,3,2,4,6};
		Integer[] maxHeap = heap.buildHeap(input);
		assertEquals(new Integer(14),heap.findMax(maxHeap));
	}
	
	@Test
	public void testExtractMax() {
		Integer[] input = {1,14,10,8,7,9,3,2,4,6};
		Integer[] maxHeap = heap.buildHeap(input);
		assertEquals(new Integer(14),heap.extractMax(maxHeap));
		assertEquals(new Integer(10),heap.extractMax(maxHeap));
		assertEquals(new Integer(9),heap.extractMax(maxHeap));
	}
	
	@Test
	public void testInsert() {
		Integer[] input = {1,14,10,8,7,9,3,2,4,6};
		Integer[] maxHeap = heap.buildHeap(input);
		heap.extractMax(maxHeap);
		heap.printHeap(maxHeap);
		System.out.println();
		heap.insert(maxHeap, 13);
		heap.printHeap(maxHeap);
	}
	
	@Test
	public void testHeapSort() {
		Integer[] input = {1,14,10,8,7,9,3,2,4,6};
		Integer[] maxHeap = heap.buildHeap(input);
		heap.heapSort(maxHeap);
		heap.printHeap(maxHeap);
	}

}
