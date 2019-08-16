package com.novadax.business.response;


import com.novadax.business.exception.ApiException;

public class ApiResponse<T> {

    public String code;
    public String message;
    public T data;

    public T checkAndReturn() {
        if ("A10000".equals(code)) {
            return data;
        }
        throw new ApiException(code, message);
    }
}
