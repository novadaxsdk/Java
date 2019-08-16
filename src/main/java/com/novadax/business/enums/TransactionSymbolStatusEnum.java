package com.novadax.business.enums;

public enum TransactionSymbolStatusEnum {
    ONLINE("in transaction"),
    OFFLINE("go offline"),
    SUSPEND("paused");

    private final String description;

    TransactionSymbolStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
