package cn.demo.gas.pay.util;

/**
 * Created by zhaohg on 2017/8/6.
 */
public enum PayType {

    ALI_PAY(1, "支付宝"),
    WECHAT_PAY(2, "微信"),
    CASH_PAY(3, "现金"),
    APPLE_PAY(4, "苹果"),
    UNION_PAY(5, "银联"),
    ENTRUST_PAY(6, "银行委托");

    private int type;
    private String name;

    PayType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
