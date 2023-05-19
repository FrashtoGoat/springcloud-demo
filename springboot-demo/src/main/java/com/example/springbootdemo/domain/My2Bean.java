package com.example.springbootdemo.domain;

import javax.annotation.PostConstruct;

/**
 * @author tangxubin
 * @Date 2023/5/17 14:19
 */
public class My2Bean {

    private MyBean myBean;

    public My2Bean(MyBean myBean){
        this.myBean=myBean;
    }

    @PostConstruct
    public void init(){
        System.out.println("MyBean2初始化了");
    }
    public void hello(){
        myBean.hello();
    }


}
