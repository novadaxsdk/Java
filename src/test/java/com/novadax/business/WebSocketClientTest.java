package com.novadax.business;

import com.novadax.business.api.NovadaxWebSocketClient;

public class WebSocketClientTest {

    public static void main(String[] args) {
        NovadaxWebSocketClient webSocketClient = new NovadaxWebSocketClient();
        webSocketClient.subMarketTickers((tickers) -> {
            System.out.printf("tickers size %s%n", tickers.size());
        });
        webSocketClient.subMarketTicker("BTC_USDT", (ticker) -> {
            System.out.printf("BTC_USDT last price %s%n", ticker.getLastPrice());
        });
        webSocketClient.subMarketDepth("BTC_USDT", (depth) -> {
            System.out.printf("BTC_USDT ask %s bid %s%n", depth.getAsks().get(0), depth.getBids().get(0));
        });
        webSocketClient.subMarketTrade("BTC_USDT", (trades) -> {
            System.out.printf("BTC_USDT recent trades %s", trades.size());
        });
    }
}
