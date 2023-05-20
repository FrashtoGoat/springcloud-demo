package com.example.springbootdemo.configuration;

import com.example.springbootdemo.domain.My2Bean;
import com.example.springbootdemo.domain.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tangxubin
 * @Date 2023/5/17 14:12
 * proxyBeanMethods 为 false会重新初始化一次myBean()
 * proxyBeanMethods 为 true，会先检查是否有mybean,有的话直接使用
 * 也就是proxyBeanMethods = true拿到的是同一个对象
 */
@Configuration(proxyBeanMethods = false)
public class FactoryConfiguration {

    @Bean
    public MyBean myBean(){
        return new MyBean();
    }

    @Bean
    public My2Bean my2Bean(){
        return new My2Bean(myBean());
    }

}
