package cn.demo.gas.pay.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhaohg on 2017/8/6.
 */
public class StatData {

    private long id;
    private Integer year;
    private Integer month;
    private Integer day;
    private BigDecimal userAliPay;      //支付宝
    private BigDecimal userWechatPay;   //微信
    private BigDecimal userCashPay;     //现金
    private BigDecimal userApplePay;    //苹果
    private BigDecimal userUnionPay;    //银联
    private BigDecimal userEntrustPay;  //银行委托
    private Long addUpUser;       //新增用户数

    private BigDecimal companyAliPay;      //支付宝
    private BigDecimal companyWechatPay;   //微信
    private BigDecimal companyCashPay;     //现金
    private BigDecimal companyApplePay;    //苹果
    private BigDecimal companyUnionPay;    //银联
    private BigDecimal companyEntrustPay;  //银行委托
    private Long addUpCompany;        //新增用户数

    private Date statTime;                 //统计这个日期的数据
    private Date createTime;                //创建时间


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public BigDecimal getUserAliPay() {
        return userAliPay;
    }

    public void setUserAliPay(BigDecimal userAliPay) {
        this.userAliPay = userAliPay;
    }

    public BigDecimal getUserWechatPay() {
        return userWechatPay;
    }

    public void setUserWechatPay(BigDecimal userWechatPay) {
        this.userWechatPay = userWechatPay;
    }

    public BigDecimal getUserCashPay() {
        return userCashPay;
    }

    public void setUserCashPay(BigDecimal userCashPay) {
        this.userCashPay = userCashPay;
    }

    public BigDecimal getUserApplePay() {
        return userApplePay;
    }

    public void setUserApplePay(BigDecimal userApplePay) {
        this.userApplePay = userApplePay;
    }

    public BigDecimal getUserUnionPay() {
        return userUnionPay;
    }

    public void setUserUnionPay(BigDecimal userUnionPay) {
        this.userUnionPay = userUnionPay;
    }

    public BigDecimal getUserEntrustPay() {
        return userEntrustPay;
    }

    public void setUserEntrustPay(BigDecimal userEntrustPay) {
        this.userEntrustPay = userEntrustPay;
    }

    public Long getAddUpUser() {
        return addUpUser;
    }

    public void setAddUpUser(Long addUpUser) {
        this.addUpUser = addUpUser;
    }

    public BigDecimal getCompanyAliPay() {
        return companyAliPay;
    }

    public void setCompanyAliPay(BigDecimal companyAliPay) {
        this.companyAliPay = companyAliPay;
    }

    public BigDecimal getCompanyWechatPay() {
        return companyWechatPay;
    }

    public void setCompanyWechatPay(BigDecimal companyWechatPay) {
        this.companyWechatPay = companyWechatPay;
    }

    public BigDecimal getCompanyCashPay() {
        return companyCashPay;
    }

    public void setCompanyCashPay(BigDecimal companyCashPay) {
        this.companyCashPay = companyCashPay;
    }

    public BigDecimal getCompanyApplePay() {
        return companyApplePay;
    }

    public void setCompanyApplePay(BigDecimal companyApplePay) {
        this.companyApplePay = companyApplePay;
    }

    public BigDecimal getCompanyUnionPay() {
        return companyUnionPay;
    }

    public void setCompanyUnionPay(BigDecimal companyUnionPay) {
        this.companyUnionPay = companyUnionPay;
    }

    public BigDecimal getCompanyEntrustPay() {
        return companyEntrustPay;
    }

    public void setCompanyEntrustPay(BigDecimal companyEntrustPay) {
        this.companyEntrustPay = companyEntrustPay;
    }

    public Long getAddUpCompany() {
        return addUpCompany;
    }

    public void setAddUpCompany(Long addUpCompany) {
        this.addUpCompany = addUpCompany;
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
