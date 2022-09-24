package com.wndex.boot.bean;

import lombok.*;

/**
 * @author wndexx 2022-09-19 18:24
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Pet {
    private String name;
    private Integer age;
}
