package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.service.StatService;
import cn.demo.gas.pay.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaohg on 2017/7/27.
 */
@RestController
public class StatController {

    @Autowired
    private StatService statService;

    /**
     * 走势图
     * @return
     */
    @RequestMapping("/stat/top")
    public Result getStatTop() {
        return statService.getStatTop();
    }

    @RequestMapping("/stat/list")
    public Result getStatList(int status) {
        return statService.getStatList(status);
    }

    @RequestMapping("/stat/bottom/paytype")
    public Result getStatPayType(){
        return statService.getStatPayType();
    }

    @RequestMapping("/stat/bottom/usertype")
    public Result getStatUserType(){
        return statService.getStatUserType();
    }
}
