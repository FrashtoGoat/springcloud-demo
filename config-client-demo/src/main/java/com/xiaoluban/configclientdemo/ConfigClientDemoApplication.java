package com.xiaoluban.configclientdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ConfigClientDemoApplication {

    @Value("${name")
    private String name;

    @RequestMapping("/name")
    public String home() {
        return name;
    }


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientDemoApplication.class, args);
    }

}
