package com.jd.jvm;

import com.jd.jndi.Person;

/**
 * @author FM
 * @Description
 * @create 2021-04-23 22:14
 */
public class TransferValue {

    public void changeValue1(int age){
        age=30;
    }

    public static void main(String[] args) {
        TransferValue transferValue = new TransferValue();
        Person person = new Person();
        // int age=20;
        // transferValue.changeValue1(age);
        // System.out.println("age:"+age);
    }

}
