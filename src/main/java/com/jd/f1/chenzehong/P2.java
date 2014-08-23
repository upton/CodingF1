package com.jd.f1.chenzehong;

import com.jd.f1.Solution;

/**
 * Coding F1 第二期
 * 给定一个正整数n（可能在百万，千万级别），请算出小于等于n的质数个数？比如：n=13，那么质数为2、3、5、7、11、13一共6个，答案就是6
 * 
 * @author chenzehong
 * 
 */
public class P2 implements Solution<Integer, Integer> {

    @Override
    public Integer run(Integer input) {
        // 初始化质数数组, true表示不是质数，false表示是质数，数组下标代表数字本身
        boolean[] primes = new boolean[input + 1];
        int length = primes.length;

        int maxSqrt = (int) Math.sqrt(length);
        for (int i = 2; i <= maxSqrt ; i++) {            
            // 是质数
            if (primes[i] == false) {
                for (int j = i * i; j < length; j += i) {
                    //该质数的等倍数都不是质数
                    primes[j] = true;
                }
            }
        }
        
        int primeNum = 0;
        for(int i = 2; i < length; i++){
            if(primes[i] == false){
                primeNum++;
            }
        }

        return primeNum;
    }
    
    @Override
    public String getAuthor() {
        return "chenzehong";
    }
}
