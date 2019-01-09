/**
 * Copyright (C), 2018-2019
 * FileName: SequentialPrimeFinder
 * Author:   Administrator
 * Date:     2019/1/9 13:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.thead.eg1;

/**
 * 启动类，单线程计算一个范围内的素数
 */
public class SequentialPrimeFinder extends AbstractPrimeFinder {
    /**
     * 实现父类中的方法
     * @param number
     * @return
     */
    @Override
    public int countPrimes(final int number) {
        return countPrimesInRange(1,number);
    }
    /**
     * 程序主方法
     * @param args
     */
    public static void main(String[] args){
        //计算的区间为1到10000000
        new SequentialPrimeFinder().timeAndCompute(10000000);
    }
}
