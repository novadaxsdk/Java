package com.novadax.business.response;

import java.io.Serializable;

/**
 * @author bh
 * @date 2019/8/12
 */
public class OrderCancelResponse implements Serializable{
    private boolean result;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
