/**
 * Copyright (C), 2018-2019
 * FileName: CallableDemo
 * Author:   Administrator
 * Date:     2019/1/10 15:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.thead.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/10
 * @since 1.0.0
 */
//在Java5之后，任务分两类：一类是实现了Runnable接口的类，一类是实现了Callable接口的类。两者都可以被ExecutorService执行，但是Runnable任务没有返回值，而Callable任务有返回值。并且Callable的call()方法只能通过ExecutorService的(<T> task) 方法来执行，并且返回一个 <T><T>，是表示任务等待完成的 Future。
//
//public interface Callable<V>
//返回结果并且可能抛出异常的任务。实现者定义了一个不带任何参数的叫做 call 的方法。
//Callable 接口类似于，两者都是为那些其实例可能被另一个线程执行的类设计的。但是 Runnable 不会返回结果，并且无法抛出经过检查的异常。
//类包含一些从其他普通形式转换成 Callable 类的实用方法。
//
//
//Callable中的call()方法类似Runnable的run()方法，就是前者有返回值，后者没有。
//
//当将一个Callable的对象传递给ExecutorService的submit方法，则该call方法自动在一个线程上执行，并且会返回执行结果Future对象。
//
//同样，将Runnable的对象传递给ExecutorService的submit方法，则该run方法自动在一个线程上执行，并且会返回执行结果Future对象，但是在该Future对象上调用get方法，将返回null。
//
//遗憾的是，在Java API文档中，这块介绍的很糊涂，估计是翻译人员还没搞清楚的缘故吧。或者说是注释不到位。下面看个例子：
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<>();
        //创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            //使用ExecutorSevice执行callable类型任务，并将结果保存到funture变量中
            Future<String> future = executorService.submit(new TaskWithResult(i));
            //将任务执行结果存储到List中
            resultList.add(future);
        }
        //启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
        executorService.shutdown();

        String s = "";
        for (Future<String> fs :resultList ) {
            try {
                s = s+fs.get();
                System.out.println(fs.get()); //打印各个线程（任务）执行的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ssssss:"+s);
    }

    //public interface ExecutorService extends Executor {
    //
    //    //不再接受新任务，待所有任务执行完毕后关闭ExecutorService
    //    void shutdown();
    //
    //    //不再接受新任务，直接关闭ExecutorService，返回没有执行的任务列表
    //    List<Runnable> shutdownNow();
    //
    //    //判断ExecutorService是否关闭
    //    boolean isShutdown();
    //
    //    //判断ExecutorService是否终止
    //    boolean isTerminated();
    //
    //    //等待ExecutorService到达终止状态
    //    boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;
    //    <T> Future<T> submit(Callable<T> task);
    //
    //    //当task执行成功的时候future.get()返回result
    //    <T> Future<T> submit(Runnable task, T result);
    //
    //    //当task执行成功的时候future.get()返回null
    //    Future<?> submit(Runnable task);
    //
    //    //批量提交任务并获得他们的future，Task列表与Future列表一一对应
    //    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
    //        throws InterruptedException;
    //
    //    //批量提交任务并获得他们的future，并限定处理所有任务的时间
    //    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
    //    long timeout, TimeUnit unit) throws InterruptedException;
    //
    //    //批量提交任务并获得一个已经成功执行的任务的结果
    //    <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException;
    //
    //    <T> T invokeAny(Collection<? extends Callable<T>> tasks,
    //                    long timeout, TimeUnit unit)
    //        throws InterruptedException, ExecutionException, TimeoutException;
    //}
    //
    //作者：jerrik
    //链接：https://www.jianshu.com/p/ad2182f56689
    //來源：简书
    //简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
}