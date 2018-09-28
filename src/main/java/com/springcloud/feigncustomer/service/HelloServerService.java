package com.springcloud.feigncustomer.service;

import com.springcloud.feigncustomer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "HELLO-PROVIDER")
@Service
public interface HelloServerService {

    @RequestMapping(value = "/send/1")
    String hello(@RequestParam(value = "what") long what);

    @RequestMapping(value = "/user")
    String helloUser(@RequestBody User user);

}
