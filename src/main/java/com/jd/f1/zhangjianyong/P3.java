package com.jd.f1.zhangjianyong;

import java.math.BigInteger;

import com.jd.f1.Solution;


public class P3 implements Solution<Integer, Integer> {

	public Integer run(Integer input) {
		BigInteger bi1 = new BigInteger("2");

		String bi12String = String.valueOf(bi1.pow(input));
		char[] ca = bi12String.toCharArray();
		int sum = 0, length = ca.length;
		for (int i = 0; i < length ; i ++) {
			sum += Character.digit(ca[i], 10); 
		}
		return sum;
	}

	public String getAuthor() {
		return "zhangjianyong";
	}
}
