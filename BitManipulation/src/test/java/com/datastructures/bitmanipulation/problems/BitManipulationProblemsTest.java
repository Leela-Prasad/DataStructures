package com.datastructures.bitmanipulation.problems;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BitManipulationProblemsTest {

	private BitManipulationProblems bitManipulationProblems;
	
	@Before
	public void setUp() throws Exception {
		bitManipulationProblems = new BitManipulationProblems();
	}

	@After
	public void tearDown() throws Exception {
		bitManipulationProblems=null;
	}

	@Test
	public void testIsKthBitSet() {
		assertTrue(bitManipulationProblems.isKthBitSet(217, 3));
		assertFalse(bitManipulationProblems.isKthBitSet(217, 5));
		assertTrue(bitManipulationProblems.isKthBitSet(217, 7));
		assertFalse(bitManipulationProblems.isKthBitSet(217, null));
	}
	
	/*@Test
	public void testLeftShiftOneByKtimes() {
		assertEquals(new Integer(8),bitManipulationProblems.leftShiftOneByKtimes(3));
		assertEquals(new Integer(4),bitManipulationProblems.leftShiftOneByKtimes(2));
		assertEquals(new Integer(32),bitManipulationProblems.leftShiftOneByKtimes(5));
	}*/
	
	@Test
	public void testSetKthBit() {
		assertEquals(new Integer(204+(int)Math.pow(2, 4)),bitManipulationProblems.setKthBit(204, 4));
		assertEquals(new Integer(204),bitManipulationProblems.setKthBit(204, 6));
	}
	
	@Test
	public void testClearKthBit() {
		assertEquals(new Integer(55-(int)Math.pow(2,4)),bitManipulationProblems.clearKthBit(55, 4));
		assertEquals(new Integer(55),bitManipulationProblems.clearKthBit(55, 3));
	}
	
	@Test
	public void testToggleKthBit() {
		assertEquals(new Integer(51-(int)Math.pow(2, 4)),bitManipulationProblems.toggleKthBit(51, 4));
		assertEquals(new Integer(51+(int)Math.pow(2, 6)),bitManipulationProblems.toggleKthBit(51, 6));
	}
	
	@Test
	public void testFindNumberOfSetBits() {
		assertEquals(new Integer(4),bitManipulationProblems.findNumberOfSetBits(51));
		assertEquals(new Integer(4),bitManipulationProblems.findNumberOfSetBits(204));
		assertEquals(new Integer(5),bitManipulationProblems.findNumberOfSetBits(55));
	}
	
	@Test
	public void testIsNumberPowerOf2() {
		assertTrue(bitManipulationProblems.isNumberPowerOf2((int)Math.pow(2, 30)));
		assertFalse(bitManipulationProblems.isNumberPowerOf2(0));
		assertFalse(bitManipulationProblems.isNumberPowerOf2((int)Math.pow(2, 30)+3));
		assertTrue(bitManipulationProblems.isNumberPowerOf2(1));
	}
	
	@Test
	public void testFindNextHigherNumberPowerOf2() {
		assertEquals(new Integer(4),bitManipulationProblems.findNextHigherNumberPowerOf2(3));
		assertEquals(new Integer(16),bitManipulationProblems.findNextHigherNumberPowerOf2(10));
	}
	
	@Test
	public void testisPowerOf4() {
		assertTrue(bitManipulationProblems.isPowerOf4((int)Math.pow(4, 10)));
		assertFalse(bitManipulationProblems.isPowerOf4((int)Math.pow(4, 10)+1));
		assertFalse(bitManipulationProblems.isPowerOf4(8));
	}

}
