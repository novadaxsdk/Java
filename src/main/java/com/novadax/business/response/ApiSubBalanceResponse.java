package com.novadax.business.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: a002
 * @project: novadax-java-sdk
 * @description:
 * @date: 2019/12/4-19:05
 */
public class ApiSubBalanceResponse implements Serializable {
    private BigDecimal balance;
    private String currency;
}
