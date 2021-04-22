package com.fm.lombok;

/**
 * @author FM
 * @Description
 * @create 2021-04-21 21:41
 */
public class MainTest {
    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1).setName("天龙八部");
        System.out.println(book);
    }
}
