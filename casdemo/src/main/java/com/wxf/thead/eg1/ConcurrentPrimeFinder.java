/**
 * Copyright (C), 2018-2019
 * FileName: ConcurrentPrimeFinder
 * Author:   Administrator
 * Date:     2019/1/9 13:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.thead.eg1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 多线程计算一个范围内的素数
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/9
 * @since 1.0.0
 */
public class ConcurrentPrimeFinder extends AbstractPrimeFinder {
    private final int poolSize;//创建线程的个数
    private final int numberOfParts;//任务的份数

    /**
     * 构造方法初始化线程的个数和任务的划分
     * @param poolSize
     * @param numberOfParts
     */
    public ConcurrentPrimeFinder(final int poolSize, final int numberOfParts) {
        this.poolSize = poolSize;
        this.numberOfParts = numberOfParts;
    }

    @Override
    public int countPrimes(final int number) {
        int count=0;//统计各区间的素数个数
        try {
            final List<Callable<Integer>> partitions=new ArrayList<Callable<Integer>>();
            final int chunksPerPartion=number /numberOfParts;
            for(int i=0; i<numberOfParts;i++){
                final int lower=(i*chunksPerPartion)+1;
                final int upper=(i==numberOfParts-1)? number:lower+chunksPerPartion-1;
                partitions.add(new Callable<Integer>() {
                    @Override
                    public Integer call() {
                        return countPrimesInRange(lower,upper);
                    }
                });
            }
            final ExecutorService executorPool= Executors.newFixedThreadPool(poolSize);//在线程池中创建线程
            final List<Future<Integer>> resultFromParts=executorPool.invokeAll(partitions,10000, TimeUnit.SECONDS);
            executorPool.shutdown();//执行完成之后关闭线程池
            for(final Future<Integer> result:resultFromParts)//统计各任务的素数个数
                count +=result.get();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return count;
    }
    public static void main(String[] args){
        new ConcurrentPrimeFinder(4,4).timeAndCompute(10000000);
    }
}
