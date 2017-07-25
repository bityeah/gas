package cn.demo.gas.pay.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Random;

/**
 * Created by huangjp on 2017/7/21.
 */
public class Recharge {

    private long id;
    private String tradeNo;
    private int uid;
    private int source;         // 支付方式：1.支付宝 2.微信 3.现金 4.银联 5.苹果支付
    private int type;           // 付款类型 1.缴费 2.充值
    private String payAccount;
    private int state;          // 交易状态 0.失败 1.成功
    private BigDecimal amount;
    private Timestamp payTime;

    public Recharge() {
    }

    public Recharge(long id, int uid) {
        this.id = id;
        this.tradeNo = System.nanoTime() + "";
        this.uid = uid;
        this.source = 2;
        this.type = new Random().nextInt(1);
        this.payAccount = "huangjp.hz@gmail.com";
        this.state = 2;
        this.amount = BigDecimal.ZERO;
        this.payTime = new Timestamp(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "id=" + id +
                ", tradeNo='" + tradeNo + '\'' +
                ", uid=" + uid +
                ", source=" + source +
                ", type=" + type +
                ", payAccount='" + payAccount + '\'' +
                ", state=" + state +
                ", amount=" + amount +
                ", payTime=" + payTime +
                '}';
    }
}
