package cn.demo.gas.pay.dao.mapper;

import cn.demo.gas.pay.model.QuerySubmit;
import cn.demo.gas.pay.model.Recharge;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhaohg on 2017/7/27.
 */
@Repository
public interface RechargeMapper {

    List<Recharge> getRechargeList(QuerySubmit submit);

    int getRechargeCount(QuerySubmit querySubmit);

    //TODO 分个人用户还是商业用户 获取昨天的支付宝、微信、 现金、苹果、银联、委托 交易总额


}
