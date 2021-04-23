package com.fm.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author FM
 * @Description
 * @create 2021-04-22 22:15
 */
@Slf4j
public class TicketPool {

    private int count = 3000;

    private static Lock lock = new ReentrantLock();

    /**
     * 老式方法sysncharonized不用了
     */
    public void sale() {
        lock.lock();
        try {
            if(count>0){
                log.info("{}卖出第{}张票",Thread.currentThread().getName(),count--);
            }
        } finally {
            lock.unlock();
        }
    }

}
