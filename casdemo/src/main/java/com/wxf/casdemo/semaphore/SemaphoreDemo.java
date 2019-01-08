/**
 * Copyright (C), 2018-2019
 * FileName: SemaphoreDemo
 * Author:   Administrator
 * Date:     2019/1/8 15:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.casdemo.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/8
 * @since 1.0.0
 */
public class SemaphoreDemo {
    private Semaphore smp = new Semaphore(3);
    private Random rnd = new Random();

    class TaskDemo implements Runnable{
        private String id;
        TaskDemo(String id){
            this.id = id;
        }
        @Override
        public void run(){
            try {
                smp.acquire();
                System.out.println("Thread " + id + " is working");
                Thread.sleep(rnd.nextInt(1000));
                smp.release();
                System.out.println("Thread " + id + " is over");
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args){
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        //注意我创建的线程池类型，
        ExecutorService se = Executors.newCachedThreadPool();
        se.submit(semaphoreDemo.new TaskDemo("a"));
        se.submit(semaphoreDemo.new TaskDemo("b"));
        se.submit(semaphoreDemo.new TaskDemo("c"));
        se.submit(semaphoreDemo.new TaskDemo("d"));
        se.submit(semaphoreDemo.new TaskDemo("e"));
        se.submit(semaphoreDemo.new TaskDemo("f"));
        se.shutdown();
    }
}