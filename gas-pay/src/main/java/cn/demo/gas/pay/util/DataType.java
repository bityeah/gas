package cn.demo.gas.pay.util;

/**
 * Created by zhaohg on 2017/8/6.
 */
public enum DataType {

    DAY (1, "天"),
    WEEK(2, "周"),
    MONTH(3, "月"),
    YEAR(4, "年");


    private int type;
    private String name;

    DataType(int type, String name) {
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
