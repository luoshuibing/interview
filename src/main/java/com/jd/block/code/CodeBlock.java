package com.jd.block.code;

/**
 * @author FM
 * @Description
 * @create 2021-04-23 20:49
 */
public class CodeBlock {

    {
        System.out.println("CodeBlock构造代码块555");
    }

    static {
        System.out.println("CodeBlock构造代码块666");
    }

    public CodeBlock(){
        System.out.println("CodeBlock构造代码块444");
    }

}
