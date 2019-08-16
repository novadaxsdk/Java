package com.novadax.business.response;


import com.novadax.business.enums.TradeType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class TickerResponse implements Serializable {

    public String symbol;
    public String lastPrice;
    public String bid;
    public String ask;
    public String high24h;
    public String low24h;
    public String open24h;
    public String baseVolume24h;
    public String quoteVolume24h;
    public Long timestamp;
}
