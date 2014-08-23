package com.jd.f1.weijunlong;

import java.math.BigInteger;

import com.jd.f1.Solution;

public class P3 implements Solution<Integer, Integer> {

    @Override
    public Integer run(Integer input) {
        int sum = 0;
        for (char c : BigInteger.valueOf(2).pow(input).toString().toCharArray())
            sum += Character.digit(c, 10);
        return sum;
    }

    @Override
    public String getAuthor() {
        return "weijunlong";
    }

}
