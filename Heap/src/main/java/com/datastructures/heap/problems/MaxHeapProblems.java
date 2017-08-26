package com.datastructures.heap.problems;

import com.datastructures.heap.implementation.MaxHeap;

public class MaxHeapProblems {

	private MaxHeap heap;
	
	public MaxHeapProblems() {
		heap = new MaxHeap();
	}
	
	public Integer findMinimum(Integer[] maxHeap) {
		if(maxHeap == null)
			return null;
		
		Integer LeafStartingIndex = (int)Math.floor(maxHeap.length/2.0);
		
		Integer min=Integer.MAX_VALUE;
		for(int i=LeafStartingIndex;i<maxHeap.length;++i) {
			if(min>maxHeap[i])
				min=maxHeap[i];
		}
		return min;
	}
	
	public boolean deleteArbitaryElement(Integer[] maxHeap,Integer key) {
		if(maxHeap == null || key == null)
			return false;
		
		for(int i=0;i<maxHeap.length;++i) {
			if(key == maxHeap[i]) {
				delete(maxHeap,i);
				return true;
			}
		}
		return false;
	}
	
	private void delete(Integer[] maxHeap,Integer index) {
		if(maxHeap == null || index <0)
			return;
		
		Integer lastIndex = maxHeap.length-1;
		maxHeap[index]=maxHeap[lastIndex];
		maxHeap[lastIndex]=Integer.MIN_VALUE;
		heap.heapify(maxHeap,index);
	}
	
	public void printKLargestElements(Integer[] maxHeap,Integer k) {
		if(maxHeap == null || k<=0) 
			return;
		
		heap.buildHeap(maxHeap);
		
		for(int i=0;i<k;++i) {
			System.out.println(heap.extractMax(maxHeap));
		}
	}
	
	
	
	
}
