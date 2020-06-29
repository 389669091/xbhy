package com.hxh.enums;

/**
 * @auth hxh
 * @date 2020/6/28
 * @Description
 */
public enum SysEnum {
    //用户登录cookie
    COOKIE_LOGIN_NAME("cookieLoginName"),
    //用户邮箱验证码
    COOKIE_LOGIN_CODE("cookieLoginCode");
    private String value;

    SysEnum() {
    }

    SysEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }}
