package com.jd.f1;

/**
 * Coding F1 第二期
 * 给定一个正整数n（可能在百万，千万级别），请算出小于等于n的质数个数？比如：n=13，那么质数为2、3、5、7、11、13一共6个，答案就是6
 *
 */
public class P2_RunMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] classess = {                             
                "com.jd.f1.zhangjianyong.P2",
                "com.jd.f1.dongxu.P2",
                "com.jd.f1.chenzehong.P2",
                "com.jd.f1.chenzehong.P2_1",
                "com.jd.f1.liangxi.P2",
                "com.jd.f1.luogenxiong.P2",
                "com.jd.f1.zhangyouquan.P2",
                "com.jd.f1.guomin.P2",
                "com.jd.f1.weijunlong.P2",
                };

        Integer[] checkCorrectInputs = { 13, 14, 23, 25, 33, 100, 199, 2998, 34567, 100000, 200001, 1000000 };
        Integer[] checkCorrectExpects = { 6, 6,  9,  9,  11, 25,  46,  429,  3692,  9592,   17984,  78498 };
        
        Integer runTimeInput = 1398877;
        
        RunSolutions runner = new RunSolutions("2nd", 5);
        runner.runAllSolutions(classess, checkCorrectInputs, checkCorrectExpects, runTimeInput);
    }
}
