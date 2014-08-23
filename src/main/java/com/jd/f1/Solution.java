package com.jd.f1;

/**
 * F1解决方案的接口定义
 *
 * @param <I>  输入参数的类型
 * @param <O>  输出数据的类型
 */
public interface Solution<I, O> {
    /**
     * 执行具体的解决方案
     * @param input 输入条件
     * @return 返回结果
     */
    public O run(final I input);
    
    /**
     * 获取作者名字
     * @return
     */
    public String getAuthor();
}