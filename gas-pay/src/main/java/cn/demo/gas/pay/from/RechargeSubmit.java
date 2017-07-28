package cn.demo.gas.pay.from;

import cn.demo.gas.pay.model.QuerySubmit;

import java.sql.Timestamp;

/**
 * Created by zhaohg on 2017/7/27.
 */
public class RechargeSubmit {

    private Long uid;
    private Integer source;         // 支付方式：1.支付宝 2.微信 3.现金 4.银联 5.苹果支付
    private Integer payType;        // 付款类型：1.缴费 2.预付费
    private Integer state;          // 交易状态 0.失败 1.成功

    private Integer userType;       // 用户类型
    private Integer provinceId;        //付款地区

    private Long startTime;
    private Long endTime;

    private int page = 1;
    private int pageSize = 10;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setParams(QuerySubmit querySubmit) {
        if (this.page < 1) {
            this.page = 1;
        }
        if (this.pageSize < 10) {
            this.pageSize = 10;
        }

        if (startTime != null && startTime > 0) {
            querySubmit.put("startTime", new Timestamp(startTime));
        }

        if (endTime != null && endTime > 0) {
            querySubmit.put("endTime", new Timestamp(endTime));
        }

        querySubmit.put("uid", uid);
        querySubmit.put("source", source);
        querySubmit.put("payType", payType);
        querySubmit.put("state", state);
        querySubmit.put("userType", userType);
        querySubmit.put("provinceId", provinceId);
        querySubmit.setLimit(page, pageSize);
    }
}
