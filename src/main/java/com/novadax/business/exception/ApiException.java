package com.novadax.business.exception;

/**
 * @author bh
 * @date 2019/8/8
 */
public class ApiException extends RuntimeException{

    final String errCode;

    public ApiException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }

    public ApiException(Exception e) {
        super(e);
        this.errCode = e.getClass().getName();
    }

}
