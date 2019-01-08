/**
 * Copyright (C), 2018-2019
 * FileName: Player
 * Author:   Administrator
 * Date:     2019/1/7 11:18
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
 */
public class Player implements Runnable{

    private CountDownLatch begin;

    private CountDownLatch end;

    Player(CountDownLatch begin, CountDownLatch end){
        this.begin = begin;
        this.end = end;
    }

    public void run() {

        try {
            begin.await();
            System.out.println(Thread.currentThread().getName() + " arrived !");;
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}