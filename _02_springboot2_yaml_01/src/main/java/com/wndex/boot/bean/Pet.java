package com.wndex.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wndexx 2022-09-15 9:37
 */
@Data
@ToString
public class Pet {
    private String name;
    private Double weight;
}