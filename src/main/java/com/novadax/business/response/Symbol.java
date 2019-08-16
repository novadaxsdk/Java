package com.novadax.business.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by bh on 2019/8/8.
 */
public class Symbol implements Serializable{

    public String baseCurrency;

    public String symbol;

    public String quoteCurrency;

    public Integer pricePrecision;

    public Integer amountPrecision;

    public Integer valuePrecision;

    public BigDecimal minOrderAmount;

    public BigDecimal minOrderValue;
 
}
