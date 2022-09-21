package com.xiaoluban.configserverdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerDemoApplication {


//    @Value("${config.name}")
//    String name = "World";
//
//    @RequestMapping("/")
//    public String home() {
//        return "Hello " + name;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerDemoApplication.class, args);
    }

}
