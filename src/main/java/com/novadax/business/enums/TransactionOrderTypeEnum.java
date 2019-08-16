package com.novadax.business.enums;

public enum TransactionOrderTypeEnum {
    LIMIT("limit transaction"),
    MARKET("marker transaction"),
    MAKER_ONLY("marker only"),;

    private final String description;

    TransactionOrderTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
