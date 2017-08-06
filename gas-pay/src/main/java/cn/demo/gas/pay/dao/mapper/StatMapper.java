package cn.demo.gas.pay.dao.mapper;

import cn.demo.gas.pay.model.StatData;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaohg on 2017/8/4.
 */
@Repository
public interface StatMapper {

    //总交易额
    BigDecimal getAmountTotal();

    //时间段交易额
    BigDecimal getAmountTotal(Map<String, Object> map);

    //总用户量
    int getUserTotal();



    //交易额走势图 条件 周 月


    //昨日本月本年 现金、支付宝、微信、苹果、银联、委托、个人、商业交易总额
    List<StatData> getStatDataList(Map<String, Object> map);

    StatData getStatData(Map<String, Object> map);


    //----条件 昨日 本月 本年 && 个人 商业

}
