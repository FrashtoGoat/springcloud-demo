package com.xiaoluban.thirdparty;

import com.demo.planemachines.factory.AcmeFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangxubin
 * @Date 2023/2/15 10:46
 */
@RestController
public class DemoController {

    @Resource
    private AcmeFactory acmeFactory;

    @RequestMapping("/acme")
    public String acme(){
        acmeFactory.init();
        return acmeFactory.toString();
    }
}
