package com.jd.thread;

/**
 * @author FM
 * @Description
 * @create 2021-04-23 21:29
 */
public enum Country {
    ONE(1,"韩"),TWO(2,"魏"),THREE(3,"赵"),FOUR(4,"齐"),FIVE(5,"楚"),SIX(6,"燕");

    private int num;

    private String name;

    Country(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Country getByNum(int num){
        Country[] values = values();
        for (Country value : values) {
            if(value.getNum()==num){
                return value;
            }
        }
        return null;
    }

}
