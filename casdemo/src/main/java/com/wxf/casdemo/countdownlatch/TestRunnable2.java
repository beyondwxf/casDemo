/**
 * Copyright (C), 2018-2019
 * FileName: qq
 * Author:   Administrator
 * Date:     2019/1/7 13:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.casdemo.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/7
 * @since 1.0.0
 *
 */
public class TestRunnable2 implements Runnable{

    /** 处理main线程阻塞（等待所有子线程） */
    private CountDownLatch countDown;

    /** 线程名字 */
    private String  threadName;


    public TestRunnable2(CountDownLatch countDownLatch, String threadName) {
        this.countDown = countDownLatch;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println( "[" + threadName + "] Running ! [countDownLatch.getCount() = " + countDown.getCount() + "]." );
        // 每个独立子线程执行完后,countDownLatch值减1
        countDown.countDown();
    }

    public static void main(String [] args) throws InterruptedException {
        int countNum = 5;
        CountDownLatch countDownLatch = new CountDownLatch(countNum);
        for(int i=0; i<countNum; i++){
            new Thread(new TestRunnable2(countDownLatch,"子线程" + (i+100))).start();
        }
        System.out.println("主线程阻塞,等待所有子线程执行完成");
        //endLatch.await()使得主线程（main）阻塞直到endLatch.countDown()为零才继续执行
        countDownLatch.await();
        System.out.println("所有线程执行完成!");
    }
//    此外可以用java.util.concurrent.CountDownLatch类更简洁的实现这种场景.
//
//CountDownLatch 的作用和 Thread.join() 方法类似，可用于一组线程和另外一组线程的协作。
//
//例如：主线程在做一项工作之前需要一系列的准备工作，只有这些准备工作都完成，主线程才能继续它的工作,这些准备工作彼此独立,所以可以并发执行以提高速度。

// 在这个场景下就可以使用 CountDownLatch 协调线程之间的调度了。
//
//在直接创建线程的年代(Java 5.0 之前),我们可以使用 Thread.join().在 JUC 出现后，因为线程池中的线程不能直接被引用，所以就必须使用 CountDownLatch 了。
//
//CountDownLatch 是能使一组线程等另一组线程都跑完了再继续跑 ,CountDownLatch.await() 方法在倒计数为0之前会阻塞当前线程.
}