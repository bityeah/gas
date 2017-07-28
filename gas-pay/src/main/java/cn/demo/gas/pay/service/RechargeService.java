package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.RechargeMapper;
import cn.demo.gas.pay.from.RechargeSubmit;
import cn.demo.gas.pay.model.QuerySubmit;
import cn.demo.gas.pay.model.Recharge;
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

    public List<Recharge> getRechargeList(RechargeSubmit submit) {
        QuerySubmit querySubmit = new QuerySubmit();
        submit.setParams(querySubmit);

        return rechargeMapper.getRechargeList(querySubmit);
    }


    public int getRechargeCount(RechargeSubmit submit){
        QuerySubmit querySubmit = new QuerySubmit();
        submit.setParams(querySubmit);

        return rechargeMapper.getRechargeCount(querySubmit);
    }
}
