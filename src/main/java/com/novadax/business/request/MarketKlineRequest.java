package com.novadax.business.request;

import java.io.Serializable;

/**
 * Created by bh on 2020/10/13.
 */
public class MarketKlineRequest implements Serializable{
    private String symbol;
    private String kLineTimeUnitEnum;
    private Long from;
    private Long to;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getkLineTimeUnitEnum() {
        return kLineTimeUnitEnum;
    }

    public void setkLineTimeUnitEnum(String kLineTimeUnitEnum) {
        this.kLineTimeUnitEnum = kLineTimeUnitEnum;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}
