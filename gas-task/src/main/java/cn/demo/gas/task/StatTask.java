package cn.demo.gas.task;

import cn.demo.gas.pay.dao.mapper.RechargeMapper;
import cn.demo.gas.pay.dao.mapper.StatMapper;
import cn.demo.gas.pay.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhaohg on 2017/8/6.
 */
@Service
public class StatTask {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RechargeMapper rechargeMapper;

    @Resource
    private StatMapper statMapper;

    public void index(){
        System.out.println("111");
    }


}
