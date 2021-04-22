package com.fm.interview;

/**
 * @author FM
 * @Description
 * @create 2020-10-11 12:37
 */
public class MethodOver {

    private int x, y;
    private float z;
    public void setVar(int a, int b, float c){
        x = a;
        y = b;
        z = c;
    }



    // public void setVar(int a, float c, int b) { setVar(a, b, c); }

    // public void setVar(int a, float c, int b) { this(a, b, c); }

    public void setVar(int a, float b){ x = a; z = b; }


}
