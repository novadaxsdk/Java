package com.novadax.business.request;

import java.io.Serializable;

/**
 * Created by bh on 2019/8/12.
 */
public class MarketDepthRequest implements Serializable {

    private String symbol;
    private Integer limit;

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
