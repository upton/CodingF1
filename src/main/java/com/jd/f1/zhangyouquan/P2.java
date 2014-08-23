package com.jd.f1.zhangyouquan;

import java.util.ArrayList;
import java.util.List;

import com.jd.f1.Solution;

public class P2 implements Solution<Integer, Integer> {

    @Override
    public Integer run(Integer input) {
        return test2(input);
    }

    @Override
    public String getAuthor() {
        return "zhangyouquan";
    }

    public int test2(int num) {
        List<Integer> list = new ArrayList<Integer>();
        
        //将12以内的质数加入结果列表中
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(11);
        
        //取得可能用到最大的一个数
        int iMaxNumTemp = (int) Math.sqrt((float) num);
        
        //累计取得的质数个数
        int findTotalNum=5;
        
        //循环判断大于11的数字
        for(int i=12;i<=num;i++){
            //判断当前数字是否为12以内的质数的倍数
//          if(i%2==0
//                  ||i%3==0
//                  ||i%5==0
//                  ||i%7==0
//                  ||i%11==0){
//              continue;
//          }
            int iTemp = (int) Math.sqrt((float) i);
            //判断当前数字是否为已经找出的质数的倍数
            boolean bl = false;
            for(int j=0;j<list.size();j++){
                if(list.get(j)>iTemp){
                    break;
                }
                if((new Integer(i)%(list.get(j)))==0){
                    bl = true;
                    break;
                }
            }
            if(!bl){
                findTotalNum++;
                //当判断的数大于最大数的平方根，则不保存做后续判断用。
                if(i<=iMaxNumTemp){
                    list.add(i);
                }
            }
        }
        
        return findTotalNum;
    }
}
