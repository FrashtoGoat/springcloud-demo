package com.xiaoluban.configclientdemo;

import com.demo.planemachines.factory.AcmeFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@SpringBootApplication
public class ConfigClientDemoApplication {


    @Value("${name")
    private String name;


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientDemoApplication.class, args);
    }

}
