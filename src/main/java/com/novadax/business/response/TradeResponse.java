package com.novadax.business.response;



import com.novadax.business.enums.TradeType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class TradeResponse implements Serializable {

    public BigDecimal amount;

    public BigDecimal price;

    public TradeType transType;

    public Date date;
}
