package com.novadax.business.request;

import java.io.Serializable;

/**
 * Created by bh on 2019/8/12.
 */
public class ApiDepthRequest implements Serializable {
    public String symbol;
    public Integer limit;
}
