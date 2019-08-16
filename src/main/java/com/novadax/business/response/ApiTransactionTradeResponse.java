package com.novadax.business.response;

import com.novadax.business.enums.TransactionOrderSideEnum;


import java.io.Serializable;
import java.math.BigDecimal;


public class ApiTransactionTradeResponse implements Serializable {

    public BigDecimal price;

    public BigDecimal amount;

    public TransactionOrderSideEnum side;

    public Long timestamp;


}
