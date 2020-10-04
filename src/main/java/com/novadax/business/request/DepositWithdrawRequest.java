package com.novadax.business.request;

import java.io.Serializable;

/**
 * @author: a002
 * @since: JDK1.8
 * <p>
 * probject: novadax-java-sdk
 * date: 2020/10/4-17:20
 * description:
 */
public class DepositWithdrawRequest implements Serializable {
    private Long customerId;
    private String currency;
    private String type;
    private String start;
    private Integer size;
    private String direct;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }
}
