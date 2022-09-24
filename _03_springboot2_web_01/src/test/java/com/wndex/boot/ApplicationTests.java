package com.wndex.boot;

import com.wndex.boot.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootTest
class ApplicationTests {

    // @Test
    // void contextLoads() {
    //     Consumer<String> consumer1 = new Consumer<String>() {
    //         @Override
    //         public void accept(String s) {
    //             System.out.println(s);
    //         }
    //     };
    //     consumer1.accept("hello");
    //
    //     // lambda
    //     Consumer<String> consumer2 = s -> System.out.println(s);
    //     consumer2.accept("hello");
    //
    //     // method reference
    //     Consumer<String> consumer3 = System.out::println;
    //     consumer3.accept("hello");
    //
    //
    //     User user = new User("张三", 18);
    //     Supplier<String> supplier1 = new Supplier<String>() {
    //         @Override
    //         public String get() {
    //             return user.getName();
    //         }
    //     };
    //     System.out.println(supplier1.get());
    //
    //     // lambda
    //     Supplier<String> supplier2 = () -> user.getName();
    //     System.out.println(supplier2.get());
    //
    //     // method reference
    //     Supplier<String> supplier3 = user::getName;
    //     System.out.println(supplier3.get());
    //
    //     Comparator<String> com1 = new Comparator<String>() {
    //         @Override
    //         public int compare(String o1, String o2) {
    //             return o1.compareTo(o2);
    //         }
    //     };
    //
    //     // lambda
    //     Comparator<String> com2 = (o1, o2) -> o1.compareTo(o2);
    //
    //     // method reference
    //     Comparator<String> com3 = String::compareTo;
    //     int compare = com3.compare("abc", "abd");
    //     System.out.println(compare);
    //
    //     Function<User, String> function1 = new Function<User, String>() {
    //         @Override
    //         public String apply(User user) {
    //             return user.getName();
    //         }
    //     };
    //
    //     Function<User, String> function2 = User::getName;
    //     String username = function2.apply(user);
    //     System.out.println(username);
    // }
}
