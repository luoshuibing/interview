package com.fm.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author FM
 * @Description
 * @create 2021-04-22 22:47
 */
@Slf4j
public class ShareData {

    private int number=0;

    private Lock lock = new ReentrantLock();

    private Condition condition=lock.newCondition();

    /**
     * synchronized可以用lock和unlock代替;
     * wait用condition.await();
     * notify用condition.signal();
     * @throws Exception
     */
    public synchronized void increase() throws Exception{
        while(number==1){
            this.wait();
        }
        number++;
        log.info("{}的number值为：{}",Thread.currentThread().getName(),number);
        this.notifyAll();
    }

    public synchronized void decrease() throws Exception{
        while(number==0){
            this.wait();
        }
        number--;
        log.info("{}的number值为：{}",Thread.currentThread().getName(),number);
        this.notifyAll();
    }

}
