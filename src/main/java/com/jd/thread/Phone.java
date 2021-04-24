package com.jd.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author FM
 * @Description
 * @create 2021-04-23 20:58
 */
public class Phone {

    public static synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发邮件");
    }

    public static synchronized  void getMsg() throws Exception{
        System.out.println("收短信");
    }


}
