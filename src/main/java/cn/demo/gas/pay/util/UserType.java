package cn.demo.gas.pay.util;

/**
 * Created by zhaohg on 2017/8/6.
 */
public enum UserType {

    PERSONAL_USER (1, "个人用户"),
    BUSINESS_USER(2, "商业用户");

    private int type;
    private String name;

    UserType(int type, String name) {
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
