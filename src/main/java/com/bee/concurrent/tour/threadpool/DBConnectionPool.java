package com.bee.concurrent.tour.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用信号量控制数据库连接资源。通常客户端数据库连接池会开启N个线程来处理数据库操作请求，而数据库连接是有限制的，比如M代表可以开启的数据库连接数量。当M>N时，我们希望
 * 未获取到数据库连接的线程先暂时等待，直到有其他线程释放数据库连接。这是信号量(Semaphore)使用的一个场景
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0
 * 2022/6/24 12:03
 */
public class DBConnectionPool {
    private final static int THREAD_COUNT = 30;
    private Semaphore semaphore;
    private ExecutorService executor;

    private ThreadPoolExecutor threadPoolExecutor;

    private int coreSize;
    private int maxSize;
    private BlockingQueue<Runnable> blockingQueue;
    private RejectedExecutionHandler rejectedExecutionHandler;

    private AtomicInteger count = new AtomicInteger();


    public DBConnectionPool(int connectionMaxNum) {
        semaphore = new Semaphore(connectionMaxNum);

        coreSize  = Runtime.getRuntime().availableProcessors()+1;
        maxSize = connectionMaxNum;
        blockingQueue = new LinkedBlockingQueue<>(100);
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("db-connection-%d").build();
        rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        threadPoolExecutor = new ThreadPoolExecutor(coreSize, maxSize, 0, TimeUnit.MILLISECONDS,
                blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    public void execute() {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //semaphore.acquire();
                    //get connection from connection pool
                    //execute sql
                    //release connection
                    System.out.println(Thread.currentThread().getName()+",connect db and exe sql :" + count.getAndIncrement());
                    //semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean shutdown() {
        boolean loop = true;
        threadPoolExecutor.shutdown();
        try {
            do {
                loop = !threadPoolExecutor.awaitTermination(9, TimeUnit.MILLISECONDS);
            } while (loop);
        }catch(InterruptedException e){
            return true;
        }

        return loop;
    }

    public static void main(String[] args) {
        DBConnectionPool dbConnectionPool = new DBConnectionPool(30);
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            Thread task = new Thread() {
                @Override
                public void run() {
                    dbConnectionPool.execute();
                }
            };

            task.start();
        }

        dbConnectionPool.shutdown();
        long end = System.nanoTime();
        System.out.println("cost:"+ (end-start));
    }
}
