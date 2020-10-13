package com.novadax.business.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by bh on 2020/10/12.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiMarketKlineResponse implements Serializable{
    private static final long serialVersionUID = 764715904809312256L;


    private String symbol;

    private Long score;

    private BigDecimal amount;

    private BigDecimal count;

    private BigDecimal openPrice;

    private BigDecimal closePrice;

    private BigDecimal lowPrice;

    private BigDecimal highPrice;

    private BigDecimal vol;
}
