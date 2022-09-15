package com.wndex.boot.bean;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author wndexx 2022-09-15 8:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Users {
    private User[] users;
    private Integer count;

    public Users(User[] users) {
        this.users = users;
        this.count = users.length;
    }
}
