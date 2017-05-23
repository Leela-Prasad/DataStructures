package com.datastructures.stack.problems;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BalancedParenthesisCheckTest {

	private BalancedParenthesisCheck parenthesisCheck;
	
	@Before
	public void setUp() throws Exception {
		parenthesisCheck = new BalancedParenthesisCheck();
	}

	@After
	public void tearDown() throws Exception {
		parenthesisCheck = null;
	}

	@Test
	public void testIsBalanced1() {
		assertTrue(parenthesisCheck.isBalanced("(A+B)+(C+D)"));
	}
	
	@Test
	public void testIsBalanced2() {
		assertTrue(parenthesisCheck.isBalanced("((A+B)+[C+D])"));
	}
	
	@Test
	public void testIsBalanced3() {
		assertTrue(parenthesisCheck.isBalanced("[()]{}[()()]"));
	}
	
	@Test
	public void testIsBalanced4() {
		assertFalse(parenthesisCheck.isBalanced("[()]{}()())]}"));
	}
	
	@Test
	public void testIsBalanced5() {
		assertFalse(parenthesisCheck.isBalanced("[()]{}[()()]}}"));
	}
	
}
