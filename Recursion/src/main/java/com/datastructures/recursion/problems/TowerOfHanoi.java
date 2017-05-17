package com.datastructures.recursion.problems;

import org.springframework.stereotype.Component;

@Component
public class TowerOfHanoi {
	
	/**
	 * 
	 * @param discs - No of discs that are there on the tower
	 * 
	 * Problem
	 * We need to move n discs from A tower to B tower using C tower.
	 * 
	 * Constraints
	 * We need to move one disc at a time.
	 * Heavier disc should not be placed on lighter disc.
	 * 
	 * Algorithm
	 * 1. Move (n-1) disc from A to C
	 * 2. Move the disc from A to B
	 * 3. Now the problem is reduced to the smaller problem with number of discs as n-1.
	 * 	  after moving the disc from A to B we can ignore that disc as it is in correct position and 
	 * 	  we will not disturb its position.
	 * 4. Now we have to move (n-1) discs from C to B using A tower. -> which is the problem statement. 
	 */
	public void TOH(Integer numberOfDiscs,String a, String b,String c) {
		
		if(numberOfDiscs==1) {
			System.out.println("Moving " + numberOfDiscs + "from " + a + "to " + b);
			return;
		}
		
		TOH(numberOfDiscs-1,a,c,b);
		System.out.println("Moving " + numberOfDiscs + "from " + a + "to " + b);
		TOH(numberOfDiscs-1,c,b,a);
		
	}

	public static void main(String[] args) {
		
		new TowerOfHanoi().TOH(3, "A", "B", "C");

	}
}
