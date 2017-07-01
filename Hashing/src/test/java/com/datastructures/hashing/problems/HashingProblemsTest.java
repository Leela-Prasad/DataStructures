package com.datastructures.hashing.problems;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HashingProblemsTest {

	private HashingProblems problems;

	@Before
	public void setUp() throws Exception {
		problems = new HashingProblems();
	}

	@After
	public void tearDown() throws Exception {
		problems=null;
	}

	@Test
	public void testCheckDuplicateExistsInKDistance() {
		Integer arr[]={1,2,3,4,1,2,3,4};
		assertFalse(problems.checkDuplicateExistsInKDistance(arr, 3));
		assertTrue(problems.checkDuplicateExistsInKDistance(arr, 4));
		Integer arr1[]={1,2,3,1,4,5};
		assertTrue(problems.checkDuplicateExistsInKDistance(arr1, 3));
	}

	@Test
	public void testIsDisjointSets() {
		Integer[] set1 = {1,2,3,4,5,6,7};
		Integer[] set2 = {10,12,5,20,21,30};
		Integer[] set3 = {80,70,50,60,40};
		
		assertFalse(problems.isDisjointSets(set1, set2));
		assertTrue(problems.isDisjointSets(set2, set3));
		assertTrue(problems.isDisjointSets(set1, set3));
	}
	
	@Test
	public void testGroupElementsByFirstOccurence() {
		Integer[] input = {3,2,4,5,2,5,3,4,3};
		problems.groupElementsByFirstOccurence(input);
	}
	
	@Test
	public void testPrintDistinctCountsForWindowSizeK() {
		Integer[] input = {10,10,20,30,30,40,10};
		problems.printDistinctCountsForWindowSizeK(input, 3);
	}
	
	@Test
	public void testPrintElementsNotInTheRange() {
		Integer[] input = {52,9,10,3,5,50,15,51,45,32};
		problems.printElementsNotInTheRange(input, 48, 53);
	}
	
	@Test
	public void testPrintAllSubArraysWhoseSum0() {
		Integer[] input ={6,3,-1,-3,4,-2,2,4,6,-12,-7};
		problems.printAllSubArraysWhoseSum0(input);
		
		System.out.println();
		Integer[] input1 ={6,3,-1,-3,4,-2,2,4,0,6,-12,-7};
		problems.printAllSubArraysWhoseSum0(input1);
	}
	
	@Test
	public void testfindPairs() {
		Integer[] input = {6,2,3,4,5};
		problems.findPairs(input);
	}
}
