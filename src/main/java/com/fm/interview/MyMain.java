package com.fm.interview;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 序列化问题
 *
 * @author FM
 * @Description
 * @create 2020-10-10 21:02
 */
public class MyMain {

    public static void main(String[] args) throws Exception {
    }

    public void serializableType() throws Exception {
        // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("1.txt"));
        // SonClass sc=new SonClass();
        // oos.writeObject(sc);
        // oos.flush();
        // oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("1.txt"));
        SonClass o = (SonClass) ois.readObject();
        System.out.println(o);
    }

}
