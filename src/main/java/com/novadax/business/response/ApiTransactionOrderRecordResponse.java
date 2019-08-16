package com.novadax.business.response;

import com.novadax.business.enums.TransactionOrderSideEnum;
import com.novadax.business.enums.TransactionOrderStatusEnum;
import com.novadax.business.enums.TransactionOrderTypeEnum;


import java.io.Serializable;
import java.math.BigDecimal;

public class ApiTransactionOrderRecordResponse implements Serializable {

    public Long id;

    public String symbol;

    public TransactionOrderSideEnum side;

    public TransactionOrderTypeEnum type;

    public TransactionOrderStatusEnum status;

    public BigDecimal price;

    public BigDecimal averagePrice;

    public BigDecimal filledFee;

    public BigDecimal amount;

    public BigDecimal value;

    public BigDecimal filledAmount;

    public BigDecimal filledValue;

    public Long timestamp;


}
