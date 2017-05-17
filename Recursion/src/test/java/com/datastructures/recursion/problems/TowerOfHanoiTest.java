package com.datastructures.recursion.problems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datastructures.config.DSConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DSConfig.class})
public class TowerOfHanoiTest {

	@Autowired
	private TowerOfHanoi toh;
	
	@Test
	public void testTOH() {
		toh.TOH(3, "A", "B", "C");
	}

}
