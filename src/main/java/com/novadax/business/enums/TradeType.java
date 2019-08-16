package com.novadax.business.enums;


import java.util.Arrays;

public enum TradeType {

    DEPOSIT("deposit", ""),
    WITHDRAW("withdraw", ""),
    COIN_IN("coin_in", ""),
    COIN_OUT("coin_out", ""),
    BUY("buy", "comprar"),
    SELL("sell", "Vender"),
    OTC_BUY("otc_buy", ""),
    OTC_SELL("otc_sell", ""),
    transfer("transfer", "");

    public String getName() {
        return name;
    }

    private String name;
    private String portuguese;

    TradeType(String name, String portuguese) {
        this.portuguese = portuguese;
        this.name = name;
    }

    public String getPortuguese() {
        return portuguese;
    }


    public static TradeType getByName(String name) {
        if (name == null) {
            return null;
        }
        return Arrays.stream(TradeType.values()).filter(x ->
                x.getName().equalsIgnoreCase(name)
        ).findFirst().get();
    }
}

