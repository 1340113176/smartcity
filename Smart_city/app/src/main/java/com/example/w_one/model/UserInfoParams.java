package com.example.w_one.model;

public class UserInfoParams {

    public UserInfoParams(String account, String nickName, String password, String email, String phonenumber, String idCard, String sex) {
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.phonenumber = phonenumber;
        this.idCard = idCard;
        this.sex = sex;
        this.password = password;
    }
    private String userName;
    private String nickName;
    private String password;
    private String email;
    private String phonenumber;
    private String idCard;
    private String sex;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
