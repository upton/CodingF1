package com.jd.f1.xiaoyang;

import com.jd.f1.Solution;

public class P2 implements Solution<Integer, Integer> {

    @Override
    public Integer run(Integer input) {
        long n = input;
        long factor = n / 8;
        new FindPrime(0, factor).start();
        new FindPrime(factor, 2 * factor).start();
        new FindPrime(2 * factor, 3 * factor).start();
        new FindPrime(3 * factor, 4 * factor).start();
        new FindPrime(4 * factor, 5 * factor).start();
        new FindPrime(5 * factor, 6 * factor).start();
        new FindPrime(6 * factor, 7 * factor).start();
        new FindPrime(7 * factor, n + 1).start();

        WatchThread wt = new WatchThread();
        wt.start();
        try {
            wt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return FindPrime.totalSum - 2;
    }

    @Override
    public String getAuthor() {
        return "xiaoyang";
    }
}

class FindPrime extends Thread {

    public static Integer totalSum = 0;
    long start;
    long end;

    public FindPrime(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        synchronized (WatchThread.trigger) {
            WatchThread.trigger++;
        }
        int sum = 0;
        for (long i = start; i < end; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                sum++;
        }
        synchronized (totalSum) {
            totalSum += sum;
        }
        synchronized (WatchThread.trigger) {
            WatchThread.trigger--;
        }
    }
}

class WatchThread extends Thread {
    public static Integer trigger = 0;

    @Override
    public void run() {
        do {
            try {
                // System.out.println("trigger : " + trigger);
                Thread.sleep(50);
                // System.out.println("trigger : " + trigger);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (trigger != 0);
    }
}
