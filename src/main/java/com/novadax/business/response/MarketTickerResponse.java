package com.novadax.business.response;


import java.io.Serializable;


public class MarketTickerResponse implements Serializable {

    private String symbol;
    private String lastPrice;
    private String bid;
    private String ask;
    private String high24h;
    private String low24h;
    private String open24h;
    private String baseVolume24h;
    private String quoteVolume24h;
    private Long timestamp;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getHigh24h() {
        return high24h;
    }

    public void setHigh24h(String high24h) {
        this.high24h = high24h;
    }

    public String getLow24h() {
        return low24h;
    }

    public void setLow24h(String low24h) {
        this.low24h = low24h;
    }

    public String getOpen24h() {
        return open24h;
    }

    public void setOpen24h(String open24h) {
        this.open24h = open24h;
    }

    public String getBaseVolume24h() {
        return baseVolume24h;
    }

    public void setBaseVolume24h(String baseVolume24h) {
        this.baseVolume24h = baseVolume24h;
    }

    public String getQuoteVolume24h() {
        return quoteVolume24h;
    }

    public void setQuoteVolume24h(String quoteVolume24h) {
        this.quoteVolume24h = quoteVolume24h;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
