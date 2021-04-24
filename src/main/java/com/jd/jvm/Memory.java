package com.jd.jvm;

/**
 * @author FM
 * @Description
 * @create 2021-04-24 16:30
 */
public class Memory {

    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println(maxMemory);
        System.out.println(totalMemory);
    }

}
