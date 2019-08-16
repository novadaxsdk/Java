package com.novadax.business.response;

import com.novadax.business.enums.TransactionOrderRoleEnum;
import com.novadax.business.enums.TransactionOrderSideEnum;

import java.io.Serializable;
import java.math.BigDecimal;

public class ApiTransactionOrderDetailResponse implements Serializable {

    public Long id;

    public Long orderId;

    public String symbol;

    public BigDecimal price;

    public BigDecimal amount;

    public String fee;

    public TransactionOrderSideEnum side;

    public TransactionOrderRoleEnum role;

    public Long timestamp;
}