package com.novadax.business.enums;

public enum TransactionOrderSideEnum {
    BUY("buy"),
    SELL("sell");

    private final String descripiton;

    TransactionOrderSideEnum(String descripiton) {
        this.descripiton = descripiton;
    }

    public String getDescripiton() {
        return descripiton;
    }
}
