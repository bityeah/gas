package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaohg on 2017/7/27.
 */
@RestController
public class StatController {

    @Autowired
    private StatService StatService;


    @RequestMapping("/stat/index")
    public String alipay() {
        return "";
    }
}
