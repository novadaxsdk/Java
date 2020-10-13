package com.novadax.business.response;

import java.io.Serializable;

/**
 * @author: a002
 * @project: novadax-java-sdk
 * @description:
 * @date: 2019/12/4-18:55
 */

public class AccountSubResponse implements Serializable {

    private String subId;
    // private String bussType;
    private String state;
    private String subAccount;
    private String subIdentify;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
    }

    public String getSubIdentify() {
        return subIdentify;
    }

    public void setSubIdentify(String subIdentify) {
        this.subIdentify = subIdentify;
    }
}
