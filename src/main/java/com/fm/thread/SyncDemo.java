package com.fm.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author FM
 * @Description
 * @create 2021-04-23 1:22
 */
public class SyncDemo {

    private Lock lock = new ReentrantLock();

    public void sync(){
        synchronized (SyncDemo.class){
            System.out.println();
        }
    }

    public void lock(){
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }
    }

}
