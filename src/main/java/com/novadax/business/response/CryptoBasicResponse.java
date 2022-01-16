package com.novadax.business.response;


import java.util.List;
import java.io.Serializable;

public class CryptoBasicResponse implements Serializable {

    private String accountCode;
    private String accountType;
    private Integer accountPrecision;
    private Integer accountOrder;
    private Integer accountState;
    private List<CryptoTokenResponse> tokens;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountPrecision() {
        return accountPrecision;
    }

    public void setAccountPrecision(Integer accountPrecision) {
        this.accountPrecision = accountPrecision;
    }

    public Integer getAccountOrder() {
        return accountOrder;
    }

    public void setAccountOrder(Integer accountOrder) {
        this.accountOrder = accountOrder;
    }

    public Integer getAccountState() {
        return accountState;
    }

    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }


    public List<CryptoTokenResponse> getTokens() {
        return tokens;
    }

    public void setTokens(List<CryptoTokenResponse> tokens) {
        this.tokens = tokens;
    }
}
