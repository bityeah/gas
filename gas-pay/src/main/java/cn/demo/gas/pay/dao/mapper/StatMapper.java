package cn.demo.gas.pay.dao.mapper;

import cn.demo.gas.pay.model.Stat;
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

    void insertStatData(StatData data);

    void updateStatData(StatData data);

    //总交易额
    BigDecimal getAmountTotal();

    //----条件 昨日 本月 本年 && 个人 商业
    BigDecimal getUserAmountTotal();

    BigDecimal getCompanyAmountTotal();

    //交易额 条件 周 月 年
    BigDecimal getAmountTotal(Map<String, Object> map);

    //个人用户总数
    long getUserTotal();

    //商业用户总数
    long getCompanyTotal();

    //交易额走势图 条件 周 月 年
    List<Stat> getStatList(Map<String, Object> map);


    //昨日本月本年 现金、支付宝、微信、苹果、银联、委托
    Stat getStatData(Map<String, Object> map);

    Map<String, Object> getStatUserCompany(Map<String, Object> map);


}
