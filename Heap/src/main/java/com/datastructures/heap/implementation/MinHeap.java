package com.datastructures.heap.implementation;

public class MinHeap {

	
	public Integer[] buildHeap(Integer[] input) {
		if(input == null)
			return null;
		
		Integer LeafIndex = (int)Math.floor(input.length/2.0);
		for(int i=LeafIndex-1;i>=0;--i) {
			heapify(input,i);
		}
		return input;
	}

	private void heapify(Integer[] input, int i) {
		if(input == null || i<0)
			return;
		
		Integer leftChild = 2*i+1;
		Integer rightChild = 2*i+2;
		Integer min= Integer.MAX_VALUE;
		
		if(leftChild<input.length && input[leftChild]<input[i])
			min=leftChild;
		else
			min=i;
		
		if(rightChild<input.length && input[rightChild]<input[min])
			min=rightChild;
		
		if(min!=i) {
			swap(input,min,i);
			heapify(input,min);
		}
	}
	
	private void swap(Integer[] input,Integer index1,Integer index2) {
		if(input == null || index1<0 || index2 <0)
			return;
		
		Integer temp= input[index1];
		input[index1]=input[index2];
		input[index2]=temp;
		
	}
	
	public void printHeap(Integer[] input) {
		for(Integer anElement : input) 
			System.out.print(anElement + "\t");
	}
	
}
