package com.datastructures.heap.implementation;

public class MaxHeap {

	public Integer[] buildHeap(Integer[] input) {
		if(input == null)
			return null;
		
		Integer LeafIndex = (int)Math.floor(input.length/2.0);
		for(int i=LeafIndex-1;i>=0;--i) {
			heapify(input,i);
		}
		return input;
	}

	public void heapify(Integer[] input, int i) {
		if(input == null || i<0)
			return;
		
		Integer leftChild = 2*i+1;
		Integer rightChild = 2*i+2;
		Integer max= Integer.MIN_VALUE;
		
		if(leftChild<input.length && input[leftChild]>input[i])
			max=leftChild;
		else
			max=i;
		
		if(rightChild<input.length && input[rightChild]>input[max])
			max=rightChild;
		
		if(max!=i) {
			swap(input,max,i);
			heapify(input,max);
		}
	}
	
	private void swap(Integer[] input,Integer index1,Integer index2) {
		if(input == null || index1<0 || index2 <0)
			return;
		
		Integer temp= input[index1];
		input[index1]=input[index2];
		input[index2]=temp;
		
	}
	
	public Integer findMax(Integer[] maxHeap) {
		if(maxHeap==null || maxHeap.length==0)
			return null;
		
		return maxHeap[0];
	}
	
	public Integer extractMax(Integer[] maxHeap) {
		if(maxHeap == null || maxHeap.length==0)
			return null;
		
		Integer max = maxHeap[0];
		Integer lastIndex=maxHeap.length-1;
		maxHeap[0]=maxHeap[lastIndex];
		maxHeap[lastIndex]=Integer.MIN_VALUE;
		heapify(maxHeap,0);
		return max;
		
	}
	
	public void insert(Integer[] maxHeap, Integer key) {
		if(maxHeap == null || key == null)
			return;
		
		Integer lastIndex = maxHeap.length-1;
		maxHeap[lastIndex]=key;
		
		Integer i=lastIndex;
		while(i>0  && key>maxHeap[(int)Math.floor((i-1)/2.0)]) {
			Integer parentIndex = (int)Math.floor((i-1)/2.0);
			swap(maxHeap,i,parentIndex);
			i=parentIndex;
		}
	
	}
	
	public void heapSort(Integer[] maxHeap) {
		if(maxHeap == null)
			return;
		
		Integer size=maxHeap.length;
		for(int i=maxHeap.length-1;i>0;--i) {
			swap(maxHeap,0,i);
			--size;
			heapify(maxHeap,size,0);
		}
	}
	
	private void heapify(Integer[] input,int heapSize,int i) {
		if(input == null || i<0)
			return;
		
		Integer leftChild = 2*i+1;
		Integer rightChild = 2*i+2;
		Integer max= Integer.MIN_VALUE;
		
		if(leftChild<heapSize && input[leftChild]>input[i])
			max=leftChild;
		else
			max=i;
		
		if(rightChild<heapSize && input[rightChild]>input[max])
			max=rightChild;
		
		if(max!=i) {
			swap(input,max,i);
			heapify(input,heapSize,max);
		}
	}
	
	public void printHeap(Integer[] input) {
		for(Integer anElement : input) 
			System.out.print(anElement + "\t");
	}
	
}
