package com.buercorp.wangyu.pojo;

public class UserInfo {
    private String address;
    private String nickname;
    private String gender;
    private String email;

    public UserInfo() {
    }

    public UserInfo(String address, String nickname, String gender, String email) {
        this.address = address;
        this.nickname = nickname;
        this.gender = gender;
        this.email = email;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "UserInfo{address = " + address + ", nickname = " + nickname + ", gender = " + gender + ", email = " + email + "}";
    }
}
