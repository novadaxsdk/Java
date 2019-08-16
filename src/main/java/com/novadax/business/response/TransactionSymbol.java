package com.novadax.business.response;


import com.novadax.business.enums.TransactionSymbolStatusEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TransactionSymbol implements Serializable {

    public Long id;

    public String symbol;

    public String baseCurrency;

    public Integer baseCurrencyPrecision;

    public String quoteCurrency;

    public Integer quoteCurrencyPrecision;

    public Integer pricePrecision;

    public List<Integer> depthPricePrecision;

    public Integer amountPrecision;

    public Integer valuePrecision;

    public BigDecimal minOrderAmount;

    public BigDecimal minOrderValue;

    public TransactionSymbolStatusEnum status;

    public Integer sort;

    public Date createdAt;

    public Date updatedAt;
}