package com.fm.lombok;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author FM
 * @Description
 * @create 2021-04-21 21:04
 */
@AllArgsConstructor
@NoArgsConstructor
// @Data
@ToString
@Accessors(chain=true)
public class Book {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private double price;

    @NonNull
    @Getter
    @Setter
    private String author;

}
