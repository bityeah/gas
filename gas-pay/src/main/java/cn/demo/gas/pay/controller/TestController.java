package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by huangjp on 2017/7/18.
 */
@RestController
public class TestController {

    @Resource
    TestService testService;

    @RequestMapping("/hello")
    String helloWorld() {
        return testService.helloWorld();
    }

}
