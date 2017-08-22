package cn.demo.gas.pay.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhaohg on 2017/8/10.
 */
public class Stat {

    private long id;
    private BigDecimal aliPay;      //支付宝
    private BigDecimal wechatPay;   //微信
    private BigDecimal cashPay;     //现金
    private BigDecimal applePay;    //苹果
    private BigDecimal unionPay;    //银联
    private BigDecimal entrustPay;  //银行委托
    private BigDecimal addUpUser;   //新增用户数
    private Date statTime;
    private Date createTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAliPay() {
        return aliPay;
    }

    public void setAliPay(BigDecimal aliPay) {
        this.aliPay = aliPay;
    }

    public BigDecimal getWechatPay() {
        return wechatPay;
    }

    public void setWechatPay(BigDecimal wechatPay) {
        this.wechatPay = wechatPay;
    }

    public BigDecimal getCashPay() {
        return cashPay;
    }

    public void setCashPay(BigDecimal cashPay) {
        this.cashPay = cashPay;
    }

    public BigDecimal getApplePay() {
        return applePay;
    }

    public void setApplePay(BigDecimal applePay) {
        this.applePay = applePay;
    }

    public BigDecimal getUnionPay() {
        return unionPay;
    }

    public void setUnionPay(BigDecimal unionPay) {
        this.unionPay = unionPay;
    }

    public BigDecimal getEntrustPay() {
        return entrustPay;
    }

    public void setEntrustPay(BigDecimal entrustPay) {
        this.entrustPay = entrustPay;
    }

    public BigDecimal getAddUpUser() {
        return addUpUser;
    }

    public void setAddUpUser(BigDecimal addUpUser) {
        this.addUpUser = addUpUser;
    }

    public Date getStatTime() {
        return statTime;
    }

    public void setStatTime(Date statTime) {
        this.statTime = statTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
