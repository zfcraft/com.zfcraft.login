package com.zfcraft.web.Exception;


import com.zfcraft.web.enums.ResultEnum;

/**
 * Created by Administrator on 2017/12/12.
 */
public class LoginException extends RuntimeException {

    private Integer code;

    public LoginException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

   public LoginException(Integer code, java.lang.String message){

        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
