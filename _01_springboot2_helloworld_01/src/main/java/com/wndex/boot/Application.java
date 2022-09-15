package com.wndex.boot;

import com.wndex.boot.bean.User;
import com.wndex.boot.bean.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

        String[] names = run.getBeanNamesForType(User.class);
        for (String name : names) {
            System.out.println(name);
        }

        log.info("========================");

        Users users = run.getBean("users", Users.class);
        System.out.println(users);

        User user = run.getBean("user03", User.class);
        System.out.println(user);

        System.out.println(users.getUsers()[0] == user);
    }
}
