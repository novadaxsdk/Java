package com.novadax.business.response;

import java.math.BigDecimal;
import java.util.List;

public class ApiTransactionMarketDepth {

    public List<List<BigDecimal>> bids;


    public List<List<BigDecimal>> asks;

    public Long timestamp;
}
