package com.novadax.business.request;


import java.io.Serializable;



public class ApiTransactionOrderFilterRequest implements Serializable {

    public String accountId;

    public String symbol;

    public String status;

    public String fromId;

    public String toId;

    public Long fromTimestamp;

    public Long toTimestamp;

    public Integer limit = 100;
}
