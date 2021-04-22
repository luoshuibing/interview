package com.fm.sout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FM
 * @Description
 * @create 2021-04-02 23:06
 */
public class SoutMain {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        changeList(list);
        System.out.println(list);
        byte b=127;
        b=(byte)(b+1);
        System.out.println(10%-3);
        System.out.println(18.67%4);
        byte a = 5;short s = 3;

    }

    private static void changeList(List<String> list) {
        list.add("d");
        list.add("e");
        list.add("f");

    }

}
