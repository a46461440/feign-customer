package com.springcloud.feigncustomer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.feigncustomer.pojo.User;
import com.springcloud.feigncustomer.service.HelloServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloServerService helloServer;

    @RequestMapping("send/hello/{time}")
    @ResponseBody
    public String getHello(@PathVariable(value = "time") long time) {
        return this.helloServer.hello(time);
    }

    @HystrixCommand(fallbackMethod = "fallBack")
    @RequestMapping("get/user")
    public String getHello() {
        User user = new User();
        user.setName("zxc");
        user.setAge(23);
        return this.helloServer.helloUser(user);
    }

    private String fallBack() {
        return "request fail";
    }

}
