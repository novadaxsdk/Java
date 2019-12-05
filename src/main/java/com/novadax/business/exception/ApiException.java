package com.novadax.business.exception;

/**
 * @author bh
 * @date 2019/8/8
 */
public class ApiException extends RuntimeException{

    public ApiException(Exception e) {
        super(e);
    }

    public ApiException(String errMsg){
        super(errMsg);
    }

}
