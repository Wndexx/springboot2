package com.wndex.boot.config;

import com.wndex.boot.bean.User;
import com.wndex.boot.bean.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author wndexx 2022-09-15 8:47
 */
// @ImportResource("classpath:applicationContext.xml")
// @Configuration(proxyBeanMethods = false)
@Configuration
public class UserConfig {
    @Bean("user03")
    public User user() {
        return new User("王五", 30);
    }

    @Bean
    public Users users() {
        return new Users(new User[]{user()});
    }
}
