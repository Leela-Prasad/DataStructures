package com.datastructures.stack.problems;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PostFixEvaluationTest {

	private PostFixEvaluation eval;
	@Before
	public void setup() {
		eval = new PostFixEvaluation();
	}
	
	@After
	public void tearDown() {
		eval=null;
	}
	
	@Test(expected=NullPointerException.class)
	public void testEvaluatePostFixExpressionHelper_NullInput_ExceptionOccured() {
		eval.evaluatePostFixExpressionHelper(null);
	}
	
	@Test
	public void testEvaluatePostFixExpression1_ValidInput_Executed() {
		assertEquals(new Integer(5),eval.evaluatePostFixExpressionHelper("321*+"));
	}

	@Test
	public void testEvaluatePostFixExpression2_ValidInput_Executed() {
		assertEquals(new Integer(2),eval.evaluatePostFixExpressionHelper("123*+5-"));
	}
}
