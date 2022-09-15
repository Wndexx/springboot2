package com.wndex.boot.bean;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author wndexx 2022-09-15 8:25
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
// @Component
public class User {
    private String name;
    private Integer age;
}
