package com.example.w_one.backup;

public class Userwe {
    private int id; //用户id
    private String username; //用户名
    private String nicheng; //昵称
    private String email;  //邮箱
    private String phone; //手机号
    private String password; //密码
    private int sex; //性别
    private String yue; //余额
    private String jifen; //积分

    public Userwe(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;

    }

    public Userwe(int id, String username, String nicheng, String email, String phone, String password, int sex, String yue, String jifen) {
        this.id = id;
        this.username = username;
        this.nicheng = nicheng;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.sex = sex;
        this.yue = yue;
        this.jifen = jifen;
    }

    @Override
    public String toString() {
        return "Userwe{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nicheng='" + nicheng + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", yue='" + yue + '\'' +
                ", jifen='" + jifen + '\'' +
                '}';
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

    public String getNicheng() {
        return nicheng;
    }

    public void setNicheng(String nicheng) {
        this.nicheng = nicheng;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getYue() {
        return yue;
    }

    public void setYue(String yue) {
        this.yue = yue;
    }

    public String getJifen() {
        return jifen;
    }

    public void setJifen(String jifen) {
        this.jifen = jifen;
    }
}
