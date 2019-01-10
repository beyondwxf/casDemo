/**
 * Copyright (C), 2018-2019
 * FileName: TestRunnable
 * Author:   Administrator
 * Date:     2019/1/10 14:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.thead.newFixedThreadPool;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/10
 * @since 1.0.0
 */
public class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "现场被调用。。");
//        while (true){
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }

    }
}