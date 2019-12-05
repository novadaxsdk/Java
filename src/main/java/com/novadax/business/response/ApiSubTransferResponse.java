package com.novadax.business.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: a002
 * @project: novadax-java-sdk
 * @description:
 * @date: 2019/12/4-19:09
 */
public class ApiSubTransferResponse implements Serializable {
    private String subId;
    private BigDecimal amount;
    private String currency;
    private String state;
    private String type;
}
