package com.example.w_one.model;

public class PutXinXi {


    private String nickName;
    private String phonenumber;
    private String sex;

    public PutXinXi(String nickName, String phonenumber, String sex) {
        this.nickName = nickName;
        this.phonenumber = phonenumber;
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
