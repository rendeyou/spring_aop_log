package com.bj.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User implements Serializable { //缓存时必须序列化

    private Integer id; //包装类，可以接收空值
    private String username, password;
    @DateTimeFormat(pattern = "yyyy-MM-dd") //mvc注解
    private Date birthday;
    private Date registTime;
    //关联集合
    List<Address> addressList = new ArrayList<>();

    public User() {
    }

    public User(Integer id, String username, String password, Date birthday, Date registTime, List<Address> addressList) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.registTime = registTime;
        this.addressList = addressList;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(registTime, user.registTime) &&
                Objects.equals(addressList, user.addressList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, birthday, registTime, addressList);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", registTime=" + registTime +
                ", addressList=" + addressList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
