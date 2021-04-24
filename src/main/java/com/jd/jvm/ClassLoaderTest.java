package com.jd.jvm;

/**
 * @author FM
 * @Description
 * @create 2021-04-23 22:51
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        Object o=new Object();
        System.out.println(o.getClass().getClassLoader());
        ClassLoaderTest classLoaderTest=new ClassLoaderTest();
        System.out.println(classLoaderTest.getClass().getClassLoader());
        System.out.println(classLoaderTest.getClass().getClassLoader().getParent());
        System.out.println(classLoaderTest.getClass().getClassLoader().getParent().getParent());
    }

}
