package cn.demo.gas.pay.dao.mapper;

import cn.demo.gas.pay.model.QuerySubmit;
import cn.demo.gas.pay.model.Recharge;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaohg on 2017/7/27.
 */
@Repository
public interface RechargeMapper {

    List<Recharge> getRechargeList(QuerySubmit submit);

    long getRechargeCount(QuerySubmit querySubmit);

    //分个人用户还是商业用户 获取支付宝、微信、 现金、苹果、银联、委托 交易总额
    BigDecimal getRechargeTotalAmount(Map<String, Object> map);


}
