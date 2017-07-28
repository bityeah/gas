package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.from.RechargeSubmit;
import cn.demo.gas.pay.service.RechargeService;
import cn.demo.gas.pay.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 交易流水
 * Created by zhaohg on 2017/7/27.
 */
@RestController
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;


    @RequestMapping("/recharge/list")
    public Result getRechargeList(RechargeSubmit rechargeSubmit) {
        return rechargeService.getRechargeList(rechargeSubmit);
    }


}
