package com.jd.f1.zhangjianyong;

import com.jd.f1.Solution;

public class P2 implements Solution<Integer, Integer>{
    
    @Override
    public Integer run(Integer input) {
        return caculateCount(input);
    }

    @Override
    public String getAuthor() {
        return "zhangjianyong";
    }
    
    private static int caculateCount(int n) {
        int counter;
        switch(n) {
            case 2 : counter = 1; break;
            case 3 : counter = 2; break;
            case 4 : counter = 2; break;
            case 5 : counter = 3; break;
            case 6 : counter = 3; break;
            case 7 : counter = 4; break;
            default :
                //从大于7开始
                counter = 4; 
                int primeLength = 0;
                int loopBegin = 11, whileCounter = 0;
                //如果截止数是偶数，那么显然只需要判断到它前面的奇数，（为后面的统一簿长做准备，只有奇数才有可能是质数）
                n = n % 2 == 0 ? n - 1 : n;
                int sqrt = (int) Math.sqrt(n);
                int primeListArray[] = new int[sqrt/2+1];
                //判断其中的每一个奇数是不是质数
                while (loopBegin <= n) {
                    if (isPrime(loopBegin, primeListArray, primeLength)) {
                        if (loopBegin <= sqrt) {
                            primeListArray[whileCounter++] = loopBegin;
                            primeLength ++ ;
                        }
                        counter ++;
                        if (counter-5 == primeLength) {
                            primeListArray[whileCounter++] = loopBegin;
                        }
                    }
                    loopBegin = loopBegin + 2;
                }
        }
        return counter;
    }
    
    public static boolean isPrime(int number, int[] primeListArray, int primeLength) {
        //过滤掉一些出现率高的，3,5,7，如果目标数越大，这个项加得越多应该越优，目标数小的话看不出太大效果
        if (number % 3 == 0 || number % 5 == 0 || number % 7 == 0)
            return false;
        
        //按照一般判断质数的方法进行判断
        int range = (int) Math.sqrt(number);
        //和目标数一样，偶数跳过，能被偶数整除，那么就能被2整除
        range = range % 2 == 0 ? range - 1 : range;
        if (primeLength > 0) {
            int loop = 0, prime = primeListArray[0];
            while (prime <=range && loop < primeLength) {
                if (number % prime == 0) {
                    return false;
                }
                loop ++;
                prime = primeListArray[loop];
            }
        }
        return true;
    }
}
