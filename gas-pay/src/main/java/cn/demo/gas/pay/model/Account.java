package cn.demo.gas.pay.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by huangjp on 2017/7/18.
 */
public class Account {

    private int uid;
    private BigDecimal balance;
    private int type;
    private Timestamp createTime;

    public Account(int uid, BigDecimal balance, int type) {
        this.uid = uid;
        this.balance = balance;
        this.type = type;
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "uid=" + uid +
                ", balance=" + balance +
                ", type=" + type +
                ", createTime=" + createTime +
                '}';
    }
}
