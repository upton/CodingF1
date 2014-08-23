package com.jd.f1.chenzehong;

import com.jd.f1.Solution;

/**
 * 如果我们把所有小于10，且是3或5的倍数的自然数都列出来，我们得到3、5、6和9，这些数的和是23，那么，所有小于100000000（1亿）且是3或5的倍数的自然数的和是多少呢？
 * @author chenzehong
 *
 */
public class P1 implements Solution<Long, Long>{

    @Override
    public Long run(final Long input) {
        long sum = 0;
        long sum3 = sum(input - 1, 3L);
        long sum5 = sum(input - 1, 5L);
        long sum15 = sum(input - 1, 15L);
        
        sum = sum3 + sum5 - sum15;
        
        return sum;
    }

    @Override
    public String getAuthor() {
        return "chenzehong";
    }
    
    private long sum(long num, long step) {
        long sum = 0;
        long max = num - (num % step);
        long count = max / step;
        long halfCount = count / 2;
        if(count % 2 == 0){
            sum = (step + max) * halfCount;
        } else {
            sum = max * (halfCount + 1);
        }
        
        return sum;
    }
}
