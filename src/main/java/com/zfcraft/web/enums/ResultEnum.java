package com.zfcraft.web.enums;

/**
 * Created by Administrator on 2017/12/12.
 */
public enum ResultEnum {

     JOBNUMER_OR_IDCARD_NULL(1000,"工号或者身份证号为空"),
     JOBNUMER_OR_IDCARD_ERROR(1001,"证件号不正确"),
     PARAMETER_ERROR(1003,"系统参数错误"),
     FILE_IS_NOT_EXCEL(1004,"文件不是Excel"),
     DATA_IS_NULL(1005,"数据为空，请填写数据"),
    USERNAME_IS_ERROR(1006,"用户名错误"),
    PASSWORD_IS_ERROR(1007,"密码错误"),
    USER_ALREADY_EXISTED(1008,"用户已存在"),
    REGISTER_FAIL(1009,"注册失败");
     Integer code;
     java.lang.String message;
    ResultEnum(Integer code, java.lang.String message){
       this.code = code;
       this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public java.lang.String getMessage() {
        return message;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }
}
