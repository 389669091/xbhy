package com.hxh.enums;

/**
 * @auth hxh
 * @date 2020/6/28
 * @Description
 */
public enum SysEnum {

    COOKIE_LOGIN_NAME("cookieLoginName");

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
