package com.jd;

import com.jd.block.code.Code;
import com.jd.block.code.CodeBlock;
import com.jd.block.code.Son;
import com.jd.thread.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

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

    }

    @Test
    public void test3() throws Exception {
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

        new Thread(() -> {
            while (true) {
                try {
                    shareData.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            while (true) {
                try {
                    shareData.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();

    }

    /**
     * A打印5次，B打印10次，c打印15次
     * 循环10次
     */
    @Test
    public void test4() {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareResource.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareResource.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareResource.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

    }

    @Test
    public void test5() {
        Thread thread = new Thread(() -> {
            Date date = new Date();
            log.info("程序开始");
            while ((System.currentTimeMillis() - date.getTime()) < 2000) {
            }
            log.info("程序结束");
        });
        thread.start();
        thread.interrupt();
    }

    @Test
    public void test6() {
        System.out.println("======");
        new Code();
        new CodeBlock();
    }

    @Test
    public void test7() {
        new Son();
        System.out.println("===");
        new Son();
        System.out.println("===");
    }

    /**
     * 该方法主要讲的是synchrnoized到底是那个锁对象？
     * 加了static加了类的锁对象
     * 不加static谁调用加上谁的锁
     *
     * @throws Exception
     */
    @Test
    public void test8() throws Exception {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            try {
                phone1.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            try {
                phone2.getMsg();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }

    /**
     * 讲述CountDownLatch用法
     *
     * @throws Exception
     */
    @Test
    public void closeDoor() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "灭国");
                countDownLatch.countDown();
            }, Country.getByNum(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println("一统天下");
    }

    @Test
    public void test9() {
        System.out.println(Country.valueOf("ONE"));
    }

    @Test
    public void test10() {
        int number = 7;
        CyclicBarrier cb = new CyclicBarrier(number, () -> {
            System.out.println("召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集到第：" + temp);
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }

    @Test
    public void test11() {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }

    @Test
    public void test12(){
        // List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }



    @After
    public void sleep() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
