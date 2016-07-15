package com.basara.mainpage;

import java.io.Serializable;

/**
 * Created by hzlifangjian on 2016/6/17.
 */
public class BaseJsonVO implements Serializable {

    private static final long serialVersionUID = -3031964456907048345L;

    private int code;

    private String message;

    private Object result;

    public BaseJsonVO() {
    }

    public BaseJsonVO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseJsonVO(Object result) {
        this.code = ErrorCode.NULL.getIntValue();
        this.message = ErrorCode.NULL.getDesc();
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code.getIntValue();
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
