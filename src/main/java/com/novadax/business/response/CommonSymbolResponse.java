package com.novadax.business.response;

import java.io.Serializable;

/**
 * Created by bh on 2019/8/8.
 */
public class CommonSymbolResponse implements Serializable {

    private String symbol;
    private String baseCurrency;
    private String quoteCurrency;
    private Integer pricePrecision;
    private Integer amountPrecision;
    private Integer valuePrecision;
    private String minOrderAmount;
    private String minOrderValue;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public Integer getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(Integer pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public Integer getAmountPrecision() {
        return amountPrecision;
    }

    public void setAmountPrecision(Integer amountPrecision) {
        this.amountPrecision = amountPrecision;
    }

    public Integer getValuePrecision() {
        return valuePrecision;
    }

    public void setValuePrecision(Integer valuePrecision) {
        this.valuePrecision = valuePrecision;
    }

    public String getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(String minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    public String getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(String minOrderValue) {
        this.minOrderValue = minOrderValue;
    }
}
