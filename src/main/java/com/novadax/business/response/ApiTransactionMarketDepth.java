package com.novadax.business.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ApiTransactionMarketDepth {
    private static final long serialVersionUID = 5527653741345040840L;


    private List<List<BigDecimal>> bids;


    private List<List<BigDecimal>> asks;

    private Long timestamp;
}
