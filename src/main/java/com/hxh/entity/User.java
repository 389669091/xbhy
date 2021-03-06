package com.hxh.entity;


import java.util.Date;

/**
 * @auth hxh
 * @date 2020/6/23 0:29
 * @Description
 */
public class User {
    private String sexName;
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String qqOpenid;
    private String wxOpenid;
    private String realName;
    private Integer age;
    private String phone;
    private Integer sex;
    private String description;
    private Date registerTime;
    private String loginTime;
    private String pic;
    private Integer look;
    private String isSecret;
    private String deptName;
    private Integer deptId;

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getLook() {
        return look;
    }

    public void setLook(Integer look) {
        this.look = look;
    }

    public String getIsSecret() {
        return isSecret;
    }

    public void setIsSecret(String isSecret) {
        this.isSecret = isSecret;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", qqOpenid='" + qqOpenid + '\'' +
                ", wxOpenid='" + wxOpenid + '\'' +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", description='" + description + '\'' +
                ", registerTime=" + registerTime +
                ", loginTime='" + loginTime + '\'' +
                ", pic='" + pic + '\'' +
                ", look=" + look +
                ", isSecret='" + isSecret + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
