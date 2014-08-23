package com.jd.f1.liangxi;

import java.math.BigInteger;

import com.jd.f1.Solution;

public class P3 implements Solution<Integer, Integer> {

	@Override
	public Integer run(Integer input) {
		byte[] b = new byte[126];
		
		b[0]=(byte)0x1;
		BigInteger bi = new BigInteger(b);
		char[] c = bi.toString().toCharArray();
		int sum = 0;
		for (char d : c) {
			sum += d - 48;
		}
		return sum;
	}

	@Override
	public String getAuthor() {
		return "liangxi";
	}
}
