package com.novadax.business.request;


import java.io.Serializable;

public class MarketTradesFilterRequest implements Serializable {

    private String symbol;
    private Integer limit = 100;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
