package com.jd.niuke;

/**
 * @author FM
 * @Description
 * @create 2021-03-04 22:13
 */
public class MainTest {
    String str="hello";
    char[] ch = {'a', 'b'};

    public static void main(String[] args) {
        MainTest mainTest=new MainTest();
        System.out.println(mainTest.hashCode());
        mainTest.change(mainTest.str,mainTest.ch);
        System.out.println(mainTest.hashCode());
        System.out.println(mainTest.str);
        System.out.println(mainTest.ch[0]);
    }

    public void change(String str,char[] ch){
        System.out.println(str.hashCode());
        // str = "test ok";
        str = new String("test ok");
        System.out.println(str.hashCode());
        ch[0]='c';
    }

}
