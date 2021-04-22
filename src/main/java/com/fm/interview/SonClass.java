package com.fm.interview;

import java.io.Serializable;

/**
 * @author FM
 * @Description
 * @create 2020-10-10 20:58
 */
public class SonClass extends ParentClass implements Serializable {

    private float radius;

    transient int color;

    public static String type = "Circle";

}
