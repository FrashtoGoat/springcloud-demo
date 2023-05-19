package com.example.springbootdemo.domain;

import javax.annotation.PostConstruct;

/**
 * @author tangxubin
 * @Date 2023/5/17 14:19
 */
public class MyBean {


    @PostConstruct
    public void init(){
        System.out.println("MyBean初始化了");
    }
    public void hello(){
        System.out.println("Mybean hello");
    }

    public MyBean(){
        System.out.println("myBean无参构造0---");
    }

}
