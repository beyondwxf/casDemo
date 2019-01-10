/**
 * Copyright (C), 2018-2019
 * FileName: TestCachedThreadPool
 * Author:   Administrator
 * Date:     2019/1/10 11:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.thead.newFixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/10
 * @since 1.0.0
 */
public class TestCachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 15; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"线程被调用了。。。");
                }
            });
//            executorService.execute(new TestRunnable());
            System.out.println("************************** a"+i +"********");
        }
        executorService.shutdown();
    }



}