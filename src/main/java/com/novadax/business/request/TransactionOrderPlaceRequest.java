package com.novadax.business.request;


import com.novadax.business.enums.TransactionOrderSideEnum;
import com.novadax.business.enums.TransactionOrderTypeEnum;

import java.io.Serializable;
import java.math.BigDecimal;


public class TransactionOrderPlaceRequest implements Serializable {

    public String accountId;

    public String symbol;

    public TransactionOrderTypeEnum type;

    public TransactionOrderSideEnum side;

    public BigDecimal price;

    public BigDecimal amount;

    public BigDecimal value;

    public String source;
}