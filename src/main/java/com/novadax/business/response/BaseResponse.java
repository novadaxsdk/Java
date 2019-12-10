package com.novadax.business.response;

import com.novadax.business.exception.ApiException;

public class BaseResponse<T> {

    private String code;
    private String message;
    private T data;

    public T checkAndReturn() throws ApiException {
        if ("A10000".equals(code)) {
            return data;
        }
        throw new ApiException("code:" + code + ", message:" + message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
