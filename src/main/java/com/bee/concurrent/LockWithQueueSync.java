package com.bee.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * 基于队列阻塞(等待获取锁的线程组成的队列)和CAS实现的阻塞锁，模仿AQS的实现。
 * 实现一个这样的锁，需要考虑以下几个问题：
 * 1、需要记录哪个线程持有锁，所以需要一个变量记录当前获取锁的是哪个线程
 * 2、需要一个标记，记录是否有线程获取锁，通常用一个整型变量表示，可以方便实现重入锁，改标记记为state。比如互斥锁中，state==0代表锁未被占用，state>0代表锁被占用
 * 特别的，当前线程每重入一次锁，就需要state自增1，并且需要释放state次。读写锁中，state前16位表示读锁，后16位表示写锁，这样设计是为了可以在单个变量上做CAS操作，而不用
 * 用同步工具保证多个变量的原子性
 * 3、需要记录哪些线程没有获取到锁，通常用一个队列来保存这些线程，并让线程排队。用一个双向链表来实现一个FIFO的队列，未获取到锁的线程都阻塞，直到锁释放，被唤醒重新尝试获取锁。
 * 4、考虑如何实现公平锁和非公平锁
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0
 * 2022/6/24 11:23
 */
public abstract class LockWithQueueSync {
    private Node head;
    private Node tail;
    private volatile int state;
    private boolean fair;
    protected Thread exclueThread;//当前获取锁的线程

    public LockWithQueueSync getLockInstance(boolean isFair){
        return isFair?new FairLock():new NonFairLock();
    }

    /**
     * 对外暴露的接口
     * @return
     */
    public boolean lock(){
       return acquire(1);
    }

    /**
     * 获取锁方法，需要子类实现
     * @param arg
     * @return
     */
    abstract boolean tryAcquire(int arg);
    /**
     * 释放锁方法，需要子类实现
     * @param arg
     * @return
     */
    abstract boolean tryRelease(int arg);

    private boolean queueAcquire(Node head){
        //队列阻塞
        for(;;){
            //如果当前线程之前其他线程等待获取锁
            LockSupport.park();//阻塞；等待唤醒
            //被唤醒或继续尝试获取锁
            //成功返回true
        }
    }

    private Node addWaiter(Thread current){
        //添加到双向列表中
        return head;
    }

    /**
     * 模板方法
     * @param arg
     * @return
     */
    public boolean acquire(int arg){
        if(!tryAcquire(arg) && queueAcquire(addWaiter(Thread.currentThread()))){
            //selftInterput();
        }
        return true;
    }

    /**
     * 判断当前线程之前是否还有节点等待获取锁
     * @return true-如果当前线程之前还有其他线程在等待获取锁；否则，false
     */
    protected boolean hasPrev(){
        return head.next.t == Thread.currentThread();
    }

    class Node {
        private Node prev;
        private Node next;
        private Thread t;

        public Node(Node prev,Node next,Thread t){
            this.prev = prev;
            this.next = next;
            this.t = t ;
        }
    }

    class NonFairLock extends LockWithQueueSync{
        @Override
        public boolean tryAcquire(int arg){
            if(state == 0){//锁未被获取，先尝试获取锁
                //CAS state 0 ,1,表示获取到锁
                return true;
            }else if(Thread.currentThread() == exclueThread){//锁已被占用，是否是当前线程占用
                //是当前线程占用
                //state原子自增，代表重入
                return true;
            }

            return false;
        }

        @Override
        boolean tryRelease(int arg) {
            return false;
        }
    }

    class FairLock extends LockWithQueueSync{
        @Override
        public boolean tryAcquire(int arg){
            if(!hasPrev() && state ==0){//没有其他线程在等待获取锁了
                //cas
            }else  if(Thread.currentThread() == exclueThread){//锁已被占用，是否是当前线程占用
                //是当前线程占用
                //state原子自增，代表重入
                return true;
            }

            return false;
        }

        @Override
        boolean tryRelease(int arg) {
            return false;
        }
    }
}
