package com.buzhiming.enums;



public enum CodeEnum {
    LOGIN_SUCCESS(200,"登录成功"),
    LOGIN_FAILURE(400,"账号或密码错误"),
    SUCCESS(200,"成功"),
    FAILURE(400,"失败"),
    UPLOADE_SUCCESS(203,"上传成功"),
    UPLOADE_FAILURE(403,"上传失败"),
    GETEMAILCODE_SUCCESS(201,"发送验证码成功"),
    GETEMAILCODE_FAILURE(401,"发送验证码失败"),
    REGISTER_SUCCESS(202,"注册成功"),
    REGISTER_FAILURE(402,"注册失败"),
    REGISTER_ERROR(402,"验证码错误")
    ;
    public Integer id;
    public String message;

    CodeEnum(int id, String message) {
        this.id = id;
        this.message = message;
    }
}
