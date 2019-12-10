package com.novadax.business.response;

import java.io.Serializable;
import java.util.List;

public class MarketDepthResponse implements Serializable {

    private List<List<String>> bids;
    private List<List<String>> asks;
    private Long timestamp;

    public List<List<String>> getBids() {
        return bids;
    }

    public void setBids(List<List<String>> bids) {
        this.bids = bids;
    }

    public List<List<String>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<String>> asks) {
        this.asks = asks;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
