package com.jd.f1.zhangyouquan;

import com.jd.f1.Solution;

public class P3 implements Solution<Integer, Integer> {
    @Override
    public Integer run(Integer input) {
        return test(input);
    }

    @Override
    public String getAuthor() {
        return "zhangyouquan";
    }
    
    public static int test(int num){
        //计算结果最大可能长度
        int maxDefault = num/3+1;
        
        //当前计算结果数组
        int[] a = new int[maxDefault];
        //当前计算进位数组
        boolean[] b = new boolean[maxDefault];
        
        //初始化个位数
        a[0]=1;
        //定义计算中间变更
        int temp=0;
        //初始化当前可能最大位数
        int maxWei=1;
        for(int i=1;i<=num;i++){
            int j=0;
            for(;j<a.length && j<=maxWei;j++){
                temp=a[j]*2+(b[j]?1:0);
                if(temp>=10){
                    b[j+1]=true;
                }
                a[j] = temp%10;
            }
            if(b[j-1]){
                maxWei=j+1;
            }
            b=new boolean[maxDefault];
        }
        int result =0;
        for(int i=0;i<a.length&& i<=maxWei;i++){
            result+=a[i];
        }
        
        return result;
    }
}
