package com.jd.f1.guomin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.jd.f1.Solution;

public class P2 implements Solution<Integer, Integer> {

    @Override
    public Integer run(Integer input) {
        return sumPrime3(input);
    }

    @Override
    public String getAuthor() {
        return "guomin";
    }

    /**
     * 计算质数个数
     * @param maxdigest
     */
    private int sumPrime3(long maxdigest)
    {
        //只能是奇数
        //2n+1  2n+11   2n+21   2n+31
        long maxFactor = (long)Math.ceil(Math.sqrt(maxdigest));
        final List<Long> primes = sumPrimeOriginal(maxFactor);
        if(maxdigest % 2 == 0)
        {
            maxdigest--;
        }
        int total = 0;
        if(maxdigest >= 2)
        {
            total = 1;
        }
        final AtomicLong maxLong = new AtomicLong(maxdigest);
        final AtomicInteger countTotal = new AtomicInteger(total);
        int count = 10;
        final CountDownLatch key = new CountDownLatch(count);
        while(count > 0)
        {
            new Thread()
            {
                public void run() {
                    long digest = 0;
                    while((digest = maxLong.getAndAdd(-2)) > 1)
                    {
                        if(isProme(digest, primes))
                        {
                            countTotal.addAndGet(1);
                        }
                    }
                    key.countDown();
                }
            }.start();
            count--;
        }
        try
        {
            key.await();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return countTotal.get();
    }
    
    private static boolean isProme(long digest, List<Long> primes)
    {
        if(digest == 2)
        {
            return true;
        }
        if(digest % 2 == 0)
        {
            return false;
        }
        long maxFactor = (long)Math.ceil(Math.sqrt(digest));
        boolean isPrime = true;
        for(long prime : primes)
        {
            if(maxFactor < prime)
            {
                break;
            }
            if(digest % prime == 0)
            {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
    
    /**
     * 计算出指定数以内的质数队列（不包含2）
     * @param maxdigest
     * @return
     */
    private static List<Long> sumPrimeOriginal(long maxdigest)
    {
        int total = 0;
        if(maxdigest >= 2)//2也是质数
        {
            total += 1;
        }
        if(maxdigest % 2 == 0)
        {
            maxdigest--;
        }
        List<Long> primes = new ArrayList<Long>();
        long start = 3;
        while(start <= maxdigest)
        {
            if(start % 2 != 0)
            {
                boolean isPrime = true;
                long maxFactor = (long)Math.ceil(Math.sqrt(start));
                for(long prime : primes)
                {
                    if(maxFactor < prime)
                    {
                        break;
                    }
                    if(start % prime == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime)
                {
                    total++;
                    primes.add(start);
                }
            }
            start += 2;
        }
        return primes;
    }
}
