package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.from.RechargeSubmit;
import cn.demo.gas.pay.model.Recharge;
import cn.demo.gas.pay.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 交易流水
 * Created by zhaohg on 2017/7/27.
 */
@RequestMapping("/recharge")
@RestController
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;


    @RequestMapping("/list")
    public List<Recharge> getRechargeList(RechargeSubmit rechargeSubmit) {
        return rechargeService.getRechargeList(rechargeSubmit);
    }


}
