package com.fm.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author FM
 * @Description
 * @create 2021-04-23 0:30
 */
@Slf4j
public class ShareResource {

    private int number = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();

    private Condition condition2 = lock.newCondition();

    private Condition condition3 = lock.newCondition();

    public void print5(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            for (int i = 1; i <= 5; i++) {
                log.info("{} {} {}", Thread.currentThread().getName(), i, loop);
            }
            number = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            for (int i = 1; i <= 10; i++) {
                log.info("{} {} {}", Thread.currentThread().getName(), i, loop);
            }
            number = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            for (int i = 1; i <= 15; i++) {
                log.info("{} {} {}", Thread.currentThread().getName(), i, loop);
            }
            number = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }

}
