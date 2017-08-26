package com.datastructures.heap.implementation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinHeapTest {

	private MinHeap heap;
	
	@Before
	public void setUp() throws Exception {
		heap=new MinHeap();
	}

	@After
	public void tearDown() throws Exception {
		heap=null;
	}
	
	@Test
	public void testBuildHeap() {
		Integer[] input = {1,14,10,8,7,9,3,2,4,6};
		Integer[] minHeap = heap.buildHeap(input);
		heap.printHeap(minHeap);
	}

}
