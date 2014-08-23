package com.jd.f1.xiaoyang;

import com.jd.f1.Solution;

public class P3 implements Solution<Integer, Integer> {

	@Override
	public Integer run(Integer input) {
		int[] in = new int[input];
		in[0] = 1;
		int bit = 0;
		for (int i = 0; i < input; i++) {
			for (int j = bit; j>=0; j--) {
				in[j] = in[j]<<1;
				if (in[j] > 9) {
					if (j == bit) {
						bit++;
					}
					in[j] -= 10;
					in[j + 1]++;
				}
			}
		}
		//System.out.println(bit);
		int count = 0;
		for (int i = 0; i <= bit; i++) {
			// System.out.print(in[i]);
			count += in[i];
		}
		return count;
	}

	@Override
	public String getAuthor() {
		return "xiaoyang";
	}

	public static void main(String[] args) {
		P3 p = new P3();
		p.run(1000);
	}
}
