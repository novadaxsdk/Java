package com.novadax.business.request;


import java.io.Serializable;

public class ApiTransactionTradeFilterRequest implements Serializable {

    public String symbol;

    public Integer limit = 100;
}
