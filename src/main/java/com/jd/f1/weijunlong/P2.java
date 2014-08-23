package com.jd.f1.weijunlong;

import com.jd.f1.Solution;

public class P2 implements Solution<Integer, Integer> {

    @Override
    public Integer run(Integer input) {
        return (int)countPrimeLessNumber(input);
    }

    @Override
    public String getAuthor() {
        return "weijunlong";
    }
    
    private boolean isPrime(Long number) {
        double seq = java.lang.StrictMath.pow(number.doubleValue(), 0.5) + 1;
        for (int i = 2; i < seq; ++i) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public long countPrimeLessNumber(long number) {
        Long count = 0L;
        if (number >= 2L) {
            count = 1L;
        }
        for (Long j = 3L; j <= number; j = j + 2L) {
            if (isPrime(j)) {
                ++count;
            }
        }
        return count;
    }
}
