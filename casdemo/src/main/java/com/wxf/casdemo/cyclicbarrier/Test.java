/**
 * Copyright (C), 2018-2019
 * FileName: Test
 * Author:   Administrator
 * Date:     2019/1/8 10:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.casdemo.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/8
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            //当所有县城到达时执行此线程
            @Override
            public void run() {
                System.out.println("所有线程都执行了!");
            }
        });
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 15; i++) {
            exec.execute(new Task(cyclicBarrier));

        }
    }
}