package cn.demo.gas.pay.model;

/**
 * Created by huangjp on 2017/7/25.
 */
public class Region {

    private int id;
    private String name;
    private int parentId;
    private String pinyin;
    private String suffix;
    private String zipCode;
    private String code;
    private int sort;
    private byte level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", pinyin='" + pinyin + '\'' +
                ", suffix='" + suffix + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", code='" + code + '\'' +
                ", sort=" + sort +
                ", level=" + level +
                '}';
    }
}
