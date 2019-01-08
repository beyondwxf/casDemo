/**
 * Copyright (C), 2018-2019
 * FileName: CountDownLatchTest
 * Author:   Administrator
 * Date:     2019/1/7 10:59
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
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);

        for(int i=0; i<3; i++){
            Thread thread = new Thread(new Player(begin,end));
            thread.start();
        }

        try{
            System.out.println("the race begin");
            begin.countDown();
            end.await();
            System.out.println("the race end");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}