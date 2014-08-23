package com.jd.f1.chenzehong;

import com.jd.f1.Solution;

/**
 * Coding F1 第二期
 * 给定一个正整数n（可能在百万，千万级别），请算出小于等于n的质数个数？比如：n=13，那么质数为2、3、5、7、11、13一共6个，答案就是6
 * 
 * @author chenzehong
 * 
 */
public class P2_1 implements Solution<Integer, Integer> {
    private static final int step = 2000;
    private boolean[] primes = null;
    private int[] sums = null;

    public P2_1() {
        init();
    }

    @Override
    public Integer run(Integer input) {
        int primeNum = -2;
        int length = input + 1;

        int sumIdx = (length / step) - 1;

        if (sumIdx >= 0) {
            primeNum = sums[sumIdx];
        }

        for (int i = (length / step) * step; i < length; i++) {
            if (!primes[i]) {
                primeNum++;
            }
        }

        return primeNum;
    }

    @Override
    public String getAuthor() {
        return "chenzehong";
    }

    public void init() {
        // 初始化质数数组, false表示不是质数，true表示是质数，数组下标代表数字本身
        int length = 100000001;
        primes = new boolean[length];
        sums = new int[length / step];

        int maxSqrt = (int) Math.sqrt(length);
        for (int i = 2; i <= maxSqrt; i++) {
            // 是质数
            if (primes[i] == false) {
                for (int j = i * i; j < length; j += i) {
                    // 该质数的等倍数都不是质数
                    primes[j] = true;
                }
            }
        }

        int sum = -2;
        for (int i = 0; i < sums.length; i++) {
            int end = i * step + step;
            for (int j = i * step; j < end; j++) {
                if (primes[j] == false) {
                    sum++;
                }
            }

            sums[i] = sum;
        }
    }
}
