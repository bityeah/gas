package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.model.Order;
import cn.demo.gas.pay.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping("/insert")
    void insert() {
        testService.insert();
    }

    @RequestMapping("list")
    List<Order> queryOrderList(@RequestParam(defaultValue = "10", required = false) int pageSize,
                               @RequestParam(defaultValue = "1", required = false) int page) {
        return testService.queryOrderList(page, pageSize);
    }

}
