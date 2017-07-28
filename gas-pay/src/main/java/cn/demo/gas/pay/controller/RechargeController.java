package cn.demo.gas.pay.controller;

import cn.demo.gas.pay.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 交易流水
 * Created by zhaohg on 2017/7/27.
 */
@RequestMapping("/stat")
@RestController
public class TradeController {

    @Autowired
    private TradeService tradeService;
}
