package cn.demo.gas.pay.service;

import cn.demo.gas.pay.dao.mapper.StatMapper;
import cn.demo.gas.pay.model.StatData;
import cn.demo.gas.pay.util.DateUtil;
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

//`id` int(11) NOT NULL AUTO_INCREMENT,
//`userAliPay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '个人支付宝',
//`userWechatPay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '个人微信',
//`userCashPay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '个人现金',
//`userApplePay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '个人苹果',
//`userUnionPay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '个人银联',
//`userEntrustPay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '个人银行委托',
//`companyAliPay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '商业支付宝',
//`companyWechatPay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '商业微信',
//`companyCashPay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '商业现金',
//`companyApplePay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '商业苹果',
//`companyUnionPay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '商业银联',
//`companyEntrustPay` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '商业银行委托',
//`addUpUser` int(10) NOT NULL DEFAULT '0' COMMENT '新增用户数',
//    addUpCompany
//`createTime` datetime NOT NULL,
@Service
public class StatService {


    @Resource
    private StatMapper statMapper;

    //年度交易比例 在线交易/总交易
    //年度用户比例 个人用户/总用户

    //总交易额
    public BigDecimal totalAmount() {
        return statMapper.getAmountTotal(null);
    }

    //本年度交易额
    public BigDecimal getAmountYearTotal() {

        Map<String, Object> map = new HashMap<>();
        map.put("startTime", DateUtil.parse(DateUtil.getCurrentYear()));
        map.put("payType", 1);
        statMapper.getAmountTotal(map);


        return null;
    }

    //本月交易额
    public BigDecimal getAmountMonthTotal() {

        Map<String, Object> map = new HashMap<>();
        map.put("startTime", DateUtil.parse(DateUtil.getCurrentMonth()));

        statMapper.getAmountTotal(map);

        return null;
    }

    //昨日交易额
    public BigDecimal getAmountPrvDayTotal() {

        Map<String, Object> map = Util.getWhereMap(1);
        statMapper.getAmountTotal(map);

        return null;
    }

    //总用户量
    public int getUserTotal() {
        //select sum(addUpUser + addUpCompany) as total from stat_data
        return statMapper.getUserTotal();
    }

    //交易额走势图 条件 周 月
    public List getAmountList(String whereSql) {
        //一周
        Map<String, Object> map1 = Util.getWhereMap(4);
        List<StatData> list1 = statMapper.getStatDataList(map1);

        //一月
        Map<String, Object> map2 = Util.getWhereMap(2);
        List<StatData> list2 = statMapper.getStatDataList(map2);

        return null;
    }


    //昨日本月本年 现金、支付宝、微信、苹果、银联、委托 交易总额
    public Map<String, Object> getMap() {
        //select
        //sum(userAliPay + companyAliPay) as aliPay
        //sum(userWechatPay + companyWechatPay ) as wechatPay
        //sum(userWechatPay + companyCashPay ) as cashPay
        //sum(userApplePay + companyApplePay ) as applePay
        //sum(userUnionPay + userEntrustPay) as userPayTotal
        //sum(userUnionPay + companyUnionPay) as unionPay
        //sum(userEntrustPay + companyEntrustPay) as entrustPay
        //from stat_data where 1=1 and wheresql

        //昨日
        Map<String, Object> map1 = Util.getWhereMap(1);
        StatData statDay = statMapper.getStatData(map1);

        //本月
        Map<String, Object> map2 = Util.getWhereMap(3);
        StatData statMonth = statMapper.getStatData(map2);

        //本年
        Map<String, Object> map3 = Util.getWhereMap(4);
        StatData statYear = statMapper.getStatData(map3);

        return null;
    }

    //昨日本月本年 个人、商业交易总额
    //select
    //sum(userAliPay + userWechatPay + userCashPay + userApplePay + userUnionPay + userEntrustPay) as userPayTotal
    //sum(companyAliPay + companyWechatPay + companyCashPay + companyApplePay + companyUnionPay + companyEntrustPay) as companyPayTotal
    //from stat_data where 1=1 and wheresql


}
