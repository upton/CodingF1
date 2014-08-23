package com.jd.f1;

/**
 * Coding F1 第三期
 * 2^15=32768，32768每一位上数字的和为：3+2+7+6+8=26。请算出2^1000各位之和是多少？
 *
 */
public class P3_RunMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] classess = {
                "com.jd.f1.weijunlong.P3",
                "com.jd.f1.xiaoyang.P3",
                "com.jd.f1.liangxi.P3",
                "com.jd.f1.guomin.P3",
                "com.jd.f1.chenzehong.P3",
                "com.jd.f1.luogenxiong.P3",
                "com.jd.f1.zhangjianyong.P3",
                "com.jd.f1.zhangyouquan.P3"
                };

        Integer[] checkCorrectInputs = {};
        Integer[] checkCorrectExpects = {};
        
        Integer runTimeInput = 1000;
        
        RunSolutions runner = new RunSolutions("3rd", 5, 1000);
        runner.runAllSolutions(classess, checkCorrectInputs, checkCorrectExpects, runTimeInput);
    }
}