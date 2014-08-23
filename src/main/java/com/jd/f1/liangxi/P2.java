package com.jd.f1.liangxi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import com.jd.f1.Solution;

public class P2 implements Solution<Integer, Integer>{

    @Override
    public Integer run(Integer input) {
        return main(input);
    }

    @Override
    public String getAuthor() {
        return "liangxi";
    }

    public int main(int n) {
        AtomicInteger result = new AtomicInteger();
        int factor = 4; 
        
        final CountDownLatch countDownLatch = new CountDownLatch(factor);
        
        int mod = n % factor;
        int division = n / factor;
        
        for(int i = 0; i < factor; i++){
            if(i == 0){
                calPrimeInThread(result, 2, division*1, countDownLatch);
            }else if(i < factor-1){
                calPrimeInThread(result, division*i+1, division*(i+1), countDownLatch);
            }else{
                calPrimeInThread(result, division*i+1, division*(i+1)+mod, countDownLatch);
            }
        }
        
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return result.intValue();
    }
    
    private void calPrimeInThread(final AtomicInteger result, long start, long end,final CountDownLatch cdl){
        final long s = start;
        final long e = end;
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (long i = s; i <= e; i++) {
                    boolean flag = true;
                    for(int j=2; j*j <= i;j++){
                        if(i % j==0){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        result.incrementAndGet();
                    }
                }
                cdl.countDown();
            }
        });
        
        thread.start();
    }
}