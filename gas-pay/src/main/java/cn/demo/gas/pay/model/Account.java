package cn.demo.gas.pay.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by huangjp on 2017/7/18.
 */
public class Account {

    private int uid;
    private BigDecimal balance;
    private BigDecimal credit;
    private int type;               // 1.后付费 2.预付费
    private Timestamp createTime;

    public Account() {
    }

    public Account(int uid, BigDecimal balance, BigDecimal credit, int type) {
        this.uid = uid;
        this.balance = balance;
        this.credit = credit;
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

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
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
                ", credit=" + credit +
                ", type=" + type +
                ", createTime=" + createTime +
                '}';
    }
}
