package com.jd.f1.chenzehong;

import java.math.BigInteger;

import com.jd.f1.Solution;

/**
 * Coding F1 第三期
 * 2^15=32768，32768每一位上数字的和为：3+2+7+6+8=26。请算出2^1000各位之和是多少？
 * @author chenzehong
 * 
 */
public class P3 implements Solution<Integer, Integer> {

    @Override
    public Integer run(Integer input) {
        char[] cc = new BigInteger("2").pow(input).toString().toCharArray();

        int sum = 0;
        for(char c : cc){
            sum += Character.digit(c, 10);
        }
        
        return sum;
    }
    
    @Override
    public String getAuthor() {
        return "chenzehong";
    }
}
