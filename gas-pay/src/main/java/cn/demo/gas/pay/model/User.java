package cn.demo.gas.pay.model;

import java.sql.Timestamp;

/**
 * Created by huangjp on 2017/7/21.
 */
public class User {

    private int id;
    private String username;
    private String contact;
    private int type;
    private String phone;
    private int state;
    private int provinceId;
    private int cityId;
    private int areaId;
    private String address;
    private Timestamp createTime;

    public User() {
    }

    public User(String username, String contact, int type, String phone, int state, int provinceId, int cityId, int areaId, String address) {
        this.username = username;
        this.contact = contact;
        this.type = type;
        this.phone = phone;
        this.state = state;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.areaId = areaId;
        this.address = address;
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", contact='" + contact + '\'' +
                ", type=" + type +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
