package com.wndex.boot.bean;

import lombok.*;

/**
 * @author wndexx 2022-09-16 0:12
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;
}
