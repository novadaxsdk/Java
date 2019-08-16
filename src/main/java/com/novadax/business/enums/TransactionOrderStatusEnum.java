package com.novadax.business.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TransactionOrderStatusEnum {
    SUBMITTED(false, "submitted"),
    PROCESSING(false, "processing"),
    PARTIAL_FILLED(false, "partial filled"),
    CANCELING(false, "canceling"),
    FILLED(true, "filled"),
    CANCELED(true, "canceled"),
    REJECTED(true, "rejected");

    private final boolean isFinal;
    private final String description;

    TransactionOrderStatusEnum(boolean isFinal, String description) {
        this.isFinal = isFinal;
        this.description = description;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public String getDescription() {
        return description;
    }

    public static List<TransactionOrderStatusEnum> getProcessing() {
        return Arrays.stream(TransactionOrderStatusEnum.values())
                .filter(status -> !status.isFinal())
                .collect(Collectors.toList());
    }

    public static List<TransactionOrderStatusEnum> getFinished() {
        return Arrays.stream(TransactionOrderStatusEnum.values())
                .filter(TransactionOrderStatusEnum::isFinal)
                .collect(Collectors.toList());
    }

    public static TransactionOrderStatusEnum fromString(String text) {
        try {
            return TransactionOrderStatusEnum.valueOf(text.trim());
        } catch (Exception ex) {
            return null;
        }
    }
}
