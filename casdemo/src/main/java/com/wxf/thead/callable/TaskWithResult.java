/**
 * Copyright (C), 2018-2019
 * FileName: TaskWithResult
 * Author:   Administrator
 * Date:     2019/1/10 15:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.thead.callable;

import java.util.concurrent.Callable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/10
 * @since 1.0.0
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }


    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用干活！！！ "+Thread.currentThread().getId());
            return"call()方法被自动调用，任务的结果是：" + id + "    " + Thread.currentThread().getName();

    }
}