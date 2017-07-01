package com.datastructures.hashing.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashingProblems {

	public boolean checkDuplicateExistsInKDistance(Integer[] arr, Integer k) {
		if(arr == null ||  k == null || k<=0)
			return false;
		
		Set<Integer> hash = new HashSet<>();
		
		for(int i=0;i<arr.length;++i) {
			
			if(hash.contains(arr[i])) {
				return true;
			}
			
			hash.add(arr[i]);
			
			if(i>=k) {
				hash.remove(arr[i-k]);
			}
		}
		
		return false;
	}
	
	public boolean isDisjointSets(Integer[] set1, Integer[] set2) {
		
		if(set1 == null && set2 == null)
			return false;
		
		if(set1 == null || set2 == null)
			return true;
		
		Set<Integer> hash = new HashSet<>();
		
		for(Integer anElement : set1) {
			hash.add(anElement);
		}
		
		for(Integer anElement : set2) {
			if(hash.contains(anElement)) {
				return false;
			}
		}
		
		return true;
	}
	
	public void groupElementsByFirstOccurence(Integer[] input) {
		if(input == null)
			return;
		
		//Integer[] output = new Integer[input.length];
		Map<Integer,Integer> hash = new HashMap<>();
		
		for(Integer anElement : input) {
			if(hash.containsKey(anElement)) {
				hash.put(anElement, hash.get(anElement)+1);
			}else {
				hash.put(anElement, 1);
			}
		}
		
		for(Integer anElement : input) {
			
			Integer count = hash.get(anElement);
			if(count!=0) {
				
				for(int i=0;i<count;++i) {
					System.out.print(anElement + "\t");
				}
				
				hash.put(anElement, 0);
			}
		}
		
	}
	
	public void printDistinctCountsForWindowSizeK(Integer[] input,Integer k) {
		if(input == null || k == null || k<=0)
			return;
		
		Map<Integer,Integer> hash = new HashMap<>();
		Integer distCount=0;
		
		for(int i=0;i<k;++i) {	
			if(hash.containsKey(input[i])) {
				hash.put(input[i], hash.get(input[i])+1); 
				--distCount;
			}else {
				hash.put(input[i], 1);
				++distCount;
			}
		
		}
		
		System.out.print(distCount + "\t");
		
		for(int i=k;i<input.length;++i) {
			
			if(hash.containsKey(input[i-k])) {
				Integer count = hash.get(input[i-k])-1;
				hash.put(input[i-k], count);	
				if(count==1)
					++distCount;
				else 
					--distCount;
			}
			
			
			if(hash.containsKey(input[i])) {
				Integer count = hash.get(input[i])+1;
				hash.put(input[i], count);
				if(count==1)
					++distCount;
				else 
					--distCount;
			}else {
				hash.put(input[i], 1);
				++distCount;
			}
			System.out.print(distCount + "\t");
		}
	}
	
	public void printElementsNotInTheRange(Integer[] input,Integer low, Integer high) {
		if(input == null || low == null || high == null)
			return;
		
		if(low>high)
			return;
		Set<Integer> hash = new HashSet<>();
		
		for(Integer anElement : input) {
			hash.add(anElement);
		}
			
		for(int i=low;i<=high;++i) {
			if(!(hash.contains(i)))
				System.out.print(i + "\t");
		}
		
	}
	
	public void printAllSubArraysWhoseSum0(Integer[] input) {
		if(input == null)
			return;
		
		Integer sum = 0;
		Map<Integer,LinkedList<Integer>> hash = new HashMap<>();
		
		for(int i=0;i<input.length;++i) {
			
			
			sum += input[i];
			
			if(sum == 0)
				printSubArray(input,0,i);
			
			if(hash.containsKey(sum)) {
				LinkedList<Integer> indexes = hash.get(sum);
				printSubArray(input,indexes,i);
				
				if(i+1==input.length)
					indexes.add(i);
				else
					indexes.add(i+1);
				hash.put(sum, indexes);
			}else {
				LinkedList<Integer> indexes = new LinkedList<>();
				if(i+1==input.length)
					indexes.add(i);
				else
					indexes.add(i+1);
				hash.put(sum,indexes);
			}
			
		}
	}

	private void printSubArray(Integer[] input, LinkedList<Integer> indexes, int end) {
		
		for(Integer anIndex : indexes) {
			printSubArray(input,anIndex,end);
		}
				
	}

	private void printSubArray(Integer[] input, int start, int end) {
		if(start>end || input == null)
			return;
		
		for(int i=start; i<=end;++i) {
			System.out.print(input[i] + "\t");
		}
		System.out.println();
		
	}
	
	public void findPairs(Integer[] input) {
		
		Integer sum=0;
		HashMap<Integer,LinkedList<Pair>> hash = new HashMap<>();
		
		for(int i=0;i<input.length;++i) {
			for(int j=i+1;j<input.length;++j) {
				sum = input[i] + input[j];
				Pair pair = new Pair(input[i],input[j]);
				LinkedList<Pair> list;
				if(hash.containsKey(sum)) {
					list = hash.get(sum);
				}else {
					list = new LinkedList<>();
				}
				list.add(pair);
				hash.put(sum, list);
			}
		}
		
		printPairs(hash);
	}
	
	
	
	private void printPairs(HashMap<Integer, LinkedList<Pair>> hash) {
		
		for(Entry<Integer,LinkedList<Pair>> entry :  hash.entrySet()) {
			LinkedList<Pair> aPair=entry.getValue();
			if(aPair.size()>1) {
				System.out.println(aPair);
			}
		}
		
	}



	private class Pair {
		Integer x;
		Integer y;
		
		public Pair(Integer x,Integer y) {
			this.x=x;
			this.y=y;
		}
		
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
		
	}
}
