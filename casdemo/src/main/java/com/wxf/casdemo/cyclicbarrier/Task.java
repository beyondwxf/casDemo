/**
 * Copyright (C), 2018-2019
 * FileName: Task
 * Author:   Administrator
 * Date:     2019/1/8 11:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.casdemo.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/8
 * @since 1.0.0
 */
public class Task implements Runnable {
    private  final CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getId()+"waiting");
            cyclicBarrier.await(); //线程到达时将阻塞，只有当所有线程都到达时才会打开
            System.out.println(Thread.currentThread().getId() +"working");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}