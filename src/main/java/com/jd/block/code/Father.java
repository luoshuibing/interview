package com.jd.block.code;

/**
 * @author FM
 * @Description
 * @create 2021-04-23 20:52
 */
public class Father {
    public Father(){
        System.out.println("111");
    }

    {
        System.out.println("222");
    }

    static{
        System.out.println("333");
    }
}
