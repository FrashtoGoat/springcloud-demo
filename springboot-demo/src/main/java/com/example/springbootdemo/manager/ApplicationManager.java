package com.example.springbootdemo.manager;

import com.example.springbootdemo.domain.My2Bean;
import com.example.springbootdemo.domain.MyBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author tangxubin
 * @Date 2023/5/17 14:24
 */
@Component
public class ApplicationManager implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void test(){
        MyBean bean = applicationContext.getBean(MyBean.class);
        My2Bean bean2 = applicationContext.getBean(My2Bean.class);

        bean.hello();
        bean2.hello();


    }

    @Override
    public void afterPropertiesSet() throws Exception {
        test();
    }
}
