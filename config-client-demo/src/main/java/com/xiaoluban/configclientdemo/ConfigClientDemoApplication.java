package com.xiaoluban.configclientdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ConfigClientDemoApplication {


    @Value("${name")
    private String name;


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientDemoApplication.class, args);
    }

}
