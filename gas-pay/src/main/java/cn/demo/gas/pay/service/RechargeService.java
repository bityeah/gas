package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.RechargeMapper;
import cn.demo.gas.pay.from.RechargeForm;
import cn.demo.gas.pay.model.QuerySubmit;
import cn.demo.gas.pay.model.Recharge;
import cn.demo.gas.pay.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhaohg on 2017/7/27.
 */
@Service
public class RechargeService {

    @Resource
    private RechargeMapper rechargeMapper;

    public Result getRechargeList(RechargeForm submit) {
        QuerySubmit querySubmit = new QuerySubmit();
        submit.setParams(querySubmit);

        List<Recharge> list = rechargeMapper.getRechargeList(querySubmit);

       return new Result(list);
    }


    public int getRechargeCount(RechargeForm submit){
        QuerySubmit querySubmit = new QuerySubmit();
        submit.setParams(querySubmit);

        return rechargeMapper.getRechargeCount(querySubmit);
    }
}
