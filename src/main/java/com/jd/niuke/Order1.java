package com.jd.niuke;

/**
 * @author FM
 * @Description
 * @create 2021-03-04 22:21
 */
public class Order1 {
    public static int count=1;
    public static Order1 order1=new Order1();

    public Order1(){
        System.out.println(count);
        count++;
    }


}
