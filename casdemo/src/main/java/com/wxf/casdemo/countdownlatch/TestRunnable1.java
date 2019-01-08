/**
 * Copyright (C), 2018-2019
 * FileName: TestRunnable1
 * Author:   Administrator
 * Date:     2019/1/7 13:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.casdemo.countdownlatch;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/7
 * @since 1.0.0
 */
public class TestRunnable1 implements Runnable{

    /** 线程名 */
    private String threadName;


    public TestRunnable1(String threadName) {
        this.threadName = threadName;
    }


    @Override
    public void run() {
        System.out.println( "[" + threadName + "] Running !" );
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> lists = new ArrayList<Thread>();
        for(int i=0; i<5; i++){
            Thread thread = new Thread(new TestRunnable1("子线程" + (i + 100)));
            lists.add(thread);
            thread.start();
        }
        System.out.println("主线程阻塞,等待所有子线程执行完成");
        for(Thread thread : lists){
            // 如果注释掉thread.join(),启动后 main线程 与 所有子线程 thread并发工作,并不会等待子线程完成后再执行
            thread.join();
        }
        System.out.println("所有线程执行完成!");
    }
}