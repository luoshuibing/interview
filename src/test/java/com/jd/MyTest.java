package com.jd;

import com.fm.thread.ShareData;
import com.fm.thread.ShareResource;
import com.fm.thread.TicketPool;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author FM
 * @Description
 * @create 2021-04-22 21:07
 */
@Slf4j
public class MyTest {

    @Test
    public void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(108);
        for (int i = 0; i < 108; i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("=");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
    }

    @Test
    public void test2() {
        TicketPool pool = new TicketPool();
        new Thread(() -> {
            while (true) {
                pool.sale();
            }
        }, "售票员小丽").start();
        new Thread(() -> {
            while (true) {
                pool.sale();
            }
        }, "售票员小王").start();
        new Thread(() -> {
            while (true) {
                pool.sale();
            }
        }, "售票员小美").start();
        sleep();
    }

    @Test
    public void test3() throws Exception{
        ShareData shareData = new ShareData();
        new Thread(() -> {
            while (true) {
                try {
                    shareData.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            while (true) {
                try {
                    shareData.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        sleep();
        new Thread(() -> {
            while (true) {
                try {
                    shareData.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        sleep();
        new Thread(() -> {
            while (true) {
                try {
                    shareData.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
        sleep();
    }

    /**
     * A打印5次，B打印10次，c打印15次
     * 循环10次
     */
    @Test
    public void test4(){
        ShareResource shareResource=new ShareResource();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    shareResource.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    shareResource.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    shareResource.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        sleep();
    }

    @Test
    public void test5(){
        Thread thread = new Thread(() -> {
            Date date = new Date();
            log.info("程序开始");
            while((System.currentTimeMillis()-date.getTime())<2000){
            }
            log.info("程序结束");
        });
        thread.start();
        thread.interrupt();
        sleep();
    }

    public void sleep() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
