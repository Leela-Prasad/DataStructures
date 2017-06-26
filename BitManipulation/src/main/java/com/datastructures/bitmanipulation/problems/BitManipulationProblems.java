package com.datastructures.bitmanipulation.problems;

public class BitManipulationProblems {

	public boolean isKthBitSet(Integer number, Integer k) {
		if(number == null || k == null)
			return false;
		
		return (number & leftShiftOneByKtimes(k))>0;
	}

	public Integer setKthBit(Integer number,Integer k) {
		if(number == null || k == null)
			return null;
		
		return number | leftShiftOneByKtimes(k);
	}
	
	public Integer clearKthBit(Integer number,Integer k) {
		if(number == null || k == null)
			return null;
		
		Integer anOperand = ~leftShiftOneByKtimes(k);
		return number & anOperand;
		
	}
	
	public Integer toggleKthBit(Integer number,Integer k) {
		
		if(number == null || k == null)
			return null;
		
		return number ^ leftShiftOneByKtimes(k);
	}
	
	public Integer findNumberOfSetBits(Integer number) {
		if(number == null)
			return 0;
		
		int count=0;
		while(number!=0) {
			if((number&1)==1) {
				++count;
			}
			number = number>>1;
		}
		return count;
	}
	
	public boolean isNumberPowerOf2(Integer number) {
		if(number == null)
			return false;
		
		if(number == 0)
			return false; 
		
		return ((number&(number-1))==0)?true:false;
		
	}
	
	public Integer findNextHigherNumberPowerOf2(Integer number) {
		if(number == null)
			return 0;
		
		int count=0;
		while(number!=0) {
			number = number>>1;
			++count;
		}
		
		return leftShiftOneByKtimes(count);
	}
	
	public boolean isPowerOf4(Integer number) {
		if(number == null)
			return false;
		
		while(number%4==0) {
			number = number/4;
		}
		
		return number==1;
			
	}

	private Integer leftShiftOneByKtimes(Integer k) {

		if(k == null)
			return null;

		Integer number = 1;
		for(int i=0;i<k;++i) {
			number = number<<1;
		}
		return number;
	}
	
	/*private Integer rightShiftOneByKtimes(Integer k) {

		if(k == null)
			return null;

		Integer number = 1;
		for(int i=0;i<k;++i) {
			number = number>>1;
		}
		return number;
	}*/
	


}

