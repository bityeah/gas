package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.RechargeMapper;
import cn.demo.gas.pay.dao.mapper.StatMapper;
import cn.demo.gas.pay.dao.mapper.UserMapper;
import cn.demo.gas.pay.model.QuerySubmit;
import cn.demo.gas.pay.model.Stat;
import cn.demo.gas.pay.model.StatData;
import cn.demo.gas.pay.util.Result;
import cn.demo.gas.pay.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaohg on 2017/7/27.
 */
@Service
public class StatService {

    @Resource
    private StatMapper statMapper;

    @Resource
    private RechargeMapper rechargeMapper;

    @Resource
    private UserMapper userMapper;


    public void insertStatData(StatData data){
        statMapper.insertStatData(data);
    }

    public void updateStatData(StatData data){
        statMapper.updateStatData(data);
    }


    public Result getStatTop(){
        //总交易量
        BigDecimal totalAmount = statMapper.getAmountTotal(null);
        //昨日交易额
        Map<String, Object> map1 = Util.getWhereMap(1);
        BigDecimal prvDayAmount = statMapper.getAmountTotal(map1);
        //本月交易额
        Map<String, Object> map2 = Util.getWhereMap(3);
        BigDecimal monthAmount = statMapper.getAmountTotal(map2);
        //个人用户总数
        long totalUser = statMapper.getUserTotal();
        //商业用户数总数
        long totalCompany = statMapper.getCompanyTotal();
        //总用户数
        long totalUserCompany = totalCompany + totalUser;

        //年度支付类型占比          //在线交易 67% 支付宝 微信
        QuerySubmit submit = new QuerySubmit();
        Map map = Util.getWhereMap(4);
        submit.put("startTime", map.get("startTime"));
        submit.put("endTime", map.get("endTime"));
        long totalRecharge = rechargeMapper.getRechargeCount(submit);
        //现金支付单数
        submit.put("source", 3);
        long totalCash = rechargeMapper.getRechargeCount(submit);

        //年度支付宝支付总额

        //年度微信支付总额


        //个人用户商业用户占比       //个人用户 24%  各多少人

        //- 年度个人 企业总交易额

        return new Result();
    }

    //交易额走势图 条件 周 月 年
    public Result getStatList(int status) {

        if(status > 4 || status < 0) status = 1;

        //一周 一月 一年
        Map<String, Object> map = Util.getWhereMap(status);
        List<Stat> list = statMapper.getStatList(map);

        return new Result(list);
    }


    //昨日本月本年 现金、支付宝、微信、苹果、银联、委托 交易总额
    public Result getStatPayType() {
        //昨日
        Map<String, Object> map1 = Util.getWhereMap(1);
        Stat statDay = statMapper.getStatData(map1);

        //本月
        Map<String, Object> map2 = Util.getWhereMap(3);
        Stat statMonth = statMapper.getStatData(map2);

        //本年
        Map<String, Object> map3 = Util.getWhereMap(4);
        Stat statYear = statMapper.getStatData(map3);

        Map<String, Object> map = new HashMap<>(3);
        map.put("statDay", statDay);
        map.put("statMonth", statMonth);
        map.put("statYear", statYear);

        return new Result(map);
    }

    public Result getStatUserType(){ //昨日本月本年 个人、商业交易总额
        //昨日
        Map<String, Object> map1 = Util.getWhereMap(1);
        Map statDay = statMapper.getStatUserCompany(map1);

        //本月
        Map<String, Object> map2 = Util.getWhereMap(3);
        Map statMonth = statMapper.getStatUserCompany(map2);

        //本年
        Map<String, Object> map3 = Util.getWhereMap(4);
        Map statYear = statMapper.getStatUserCompany(map3);

        Map<String, Object> map = new HashMap<>(3);
        map.put("statDay", statDay);
        map.put("statMonth", statMonth);
        map.put("statYear", statYear);

        return new Result(map);
    }



}
