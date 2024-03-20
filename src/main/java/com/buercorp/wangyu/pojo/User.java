package com.buercorp.wangyu.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 * @author 忆白
 */
@Data
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String address;
    private String nickname;
    private String gender;
    private String email;
    private String status;//1 表示已激活  0表示未激活

//    public User(Integer id, String nickname, String address, String gender, String email, String password, String username, String status) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.address = address;
//        this.nickname = nickname;
//        this.gender = gender;
//        this.email = email;
//        this.status = status;
//    }
//
//    public User() {
//    }
//
//
//    /**
//     * 获取
//     * @return id
//     */
//    public Integer getId() {
//        return id;
//    }
//
//    /**
//     * 设置
//     * @param id
//     */
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    /**
//     * 获取
//     * @return username
//     */
//    public String getUsername() {
//        return username;
//    }
//
//    /**
//     * 设置
//     * @param username
//     */
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    /**
//     * 获取
//     * @return password
//     */
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * 设置
//     * @param password
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    /**
//     * 获取
//     * @return address
//     */
//    public String getAddress() {
//        return address;
//    }
//
//    /**
//     * 设置
//     * @param address
//     */
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    /**
//     * 获取
//     * @return nickname
//     */
//    public String getNickname() {
//        return nickname;
//    }
//
//    /**
//     * 设置
//     * @param nickname
//     */
//    public void setNickname(String nickname) {
//        this.nickname = nickname;
//    }
//
//    /**
//     * 获取
//     * @return gender
//     */
//    public String getGender() {
//        return gender;
//    }
//
//    /**
//     * 设置
//     * @param gender
//     */
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    /**
//     * 获取
//     * @return email
//     */
//    public String getEmail() {
//        return email;
//    }
//
//    /**
//     * 设置
//     * @param email
//     */
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    /**
//     * 获取
//     * @return status
//     */
//    public String getStatus() {
//        return status;
//    }
//
//    /**
//     * 设置
//     * @param status
//     */
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String toString() {
//        return "User{id = " + id + ", username = " + username + ", password = " + password + ", address = " + address + ", nickname = " + nickname + ", gender = " + gender + ", email = " + email + ", status = " + status + "}";
//    }
//
//    public void update() {
//    }
}