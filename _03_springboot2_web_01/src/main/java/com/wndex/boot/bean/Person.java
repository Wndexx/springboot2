package com.wndex.boot.bean;

import lombok.*;

import java.util.Date;

/**
 * @author wndexx 2022-09-19 18:22
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}
