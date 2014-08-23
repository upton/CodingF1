package com.jd.f1.dongxu;

import com.jd.f1.Solution;

public class P2 implements Solution<Integer, Integer>{

    @Override
    public Integer run(Integer input) {
        return getCount(input);
    }

    @Override
    public String getAuthor() {
        return "dongxu";
    }

    public int getCount(int n) {
        if( n < 2 ) {
            return 0;
        }
        else if( n < 3 ){
            return 1;
        }
        else if(n < 5 ){
            return 2;
        }
        else if( n < 7 ) {
            return 3;
        }
        else if( n == 7 ) {
            return 4;
        }
        int len = n/2;
        int[] primeList = new int[len];
        int count = 2;
        primeList[0] = 3;
        int primeListOffset = 1;
        for( int i = 5; i <= n; i += 2) {
            boolean isPrime = true;
            int sqrt = (int)Math.round(Math.sqrt(i) + 1.0);
            int j = 0;
            for(  ; j < primeList.length; j++) {
                int prime = primeList[j];
                if( prime == 0) {
                    break;
                }
                if( prime > sqrt) {
                    break;
                }
                if( i % prime == 0 ) {
                    isPrime = false;
                    break;
                }
            }
            if( isPrime ) {
                primeList[primeListOffset++] = i;
                count += 1;
            }
        }
        return count;
    }
}
