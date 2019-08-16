package com.novadax.business.response;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by bh on 2019/7/3.
 */

public class ApiTransactionSymbolResponse implements Serializable {

    public String symbol;

    public String baseCurrency;

    public String quoteCurrency;

    public Integer pricePrecision;

    public Integer amountPrecision;

    public Integer valuePrecision;

    public BigDecimal minOrderAmount;

    public BigDecimal minOrderValue;


}
