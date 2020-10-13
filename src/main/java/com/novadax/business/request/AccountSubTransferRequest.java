package com.novadax.business.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: a002
 * @project: novadax-java-sdk
 * @description:
 * @date: 2019/12/4-19:13
 */
public class AccountSubTransferRequest implements Serializable {
    private String subId;
    private String currency;
    private BigDecimal transferAmount;
    private String transferType;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }
}
