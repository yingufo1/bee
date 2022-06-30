package com.bee.concurrent;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

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



    public DBConnectionPool(int connectionMaxNum){
        semaphore = new Semaphore(connectionMaxNum);
        executor = Executors.newFixedThreadPool(THREAD_COUNT);
    }

    public void execute(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    //get connection from connection pool
                    //execute sql
                    //release connection
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
