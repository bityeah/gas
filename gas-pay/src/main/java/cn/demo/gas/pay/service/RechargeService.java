package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.TradeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhaohg on 2017/7/27.
 */
@Service
public class TradeService {

    @Resource
    private TradeMapper tradeMapper;
}
