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
    private int location;
    private String address;
    private Timestamp createTime;

    public User() {
    }

    public User(String username, String contact, int type, String phone, int state, int location, String address) {
        this.username = username;
        this.contact = contact;
        this.type = type;
        this.phone = phone;
        this.state = state;
        this.location = location;
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

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
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
                ", location=" + location +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
