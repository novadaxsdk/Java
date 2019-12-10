package com.novadax.business.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: a002
 * @project: novadax-java-sdk
 * @description:
 * @date: 2019/12/4-19:09
 */
public class AccountSubTransferResponse implements Serializable {

    private String subId;
    private String amount;
    private String currency;
    private String state;
    private String type;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
