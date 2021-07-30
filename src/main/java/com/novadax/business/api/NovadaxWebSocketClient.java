package com.novadax.business.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.novadax.business.listener.WebSocketListener;
import com.novadax.business.response.MarketDepthResponse;
import com.novadax.business.response.MarketTickerResponse;
import com.novadax.business.response.MarketTradeResponse;
import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NovadaxWebSocketClient {
    private String accessKey;
    private String secretKey;
    private String baseURL = "https://api.novadax.com";

    private Socket socket = null;

    private Set<String> subscribedTopics = new HashSet<>();

    private Gson gson = new Gson();

    public NovadaxWebSocketClient() {
    }

    public NovadaxWebSocketClient(String baseURL) {
        this.baseURL = baseURL;
    }

    public NovadaxWebSocketClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public NovadaxWebSocketClient(String accessKey, String secretKey, String baseURL) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.baseURL = baseURL;
    }

    public void subMarketTickers(WebSocketListener<List<MarketTickerResponse>> listener) {
        String topic = "MARKET.TICKERS";
        this.subscribe(topic, listener, new TypeToken<List<MarketTickerResponse>>() {
        });
    }

    public void subMarketTicker(String symbol, WebSocketListener<MarketTickerResponse> listener) {
        String topic = String.format("MARKET.%s.TICKER", symbol);
        this.subscribe(topic, listener, new TypeToken<MarketTickerResponse>() {
        });
    }

    public void subMarketDepth(String symbol, WebSocketListener<MarketDepthResponse> listener) {
        String topic = String.format("MARKET.%s.DEPTH.LEVEL0", symbol);
        this.subscribe(topic, listener, new TypeToken<MarketDepthResponse>() {
        });
    }

    public void subMarketTrade(String symbol, WebSocketListener<List<MarketTradeResponse>> listener) {
        String topic = String.format("MARKET.%s.TRADE", symbol);
        this.subscribe(topic, listener, new TypeToken<List<MarketTradeResponse>>() {
        });
    }

    private <T> void subscribe(String topic, WebSocketListener<T> listener, TypeToken<T> ref) {
        subscribedTopics.add(topic);
        this.getSocket().emit("SUBSCRIBE", Collections.singletonList(topic));
        this.getSocket().on(topic, (Object... args) -> {
            listener.call(gson.fromJson(args[0].toString(), ref.getType()));
        });
    }

    private void unsubscribe(String topic) {
        subscribedTopics.remove(topic);
        this.getSocket().emit(topic);
    }

    public Socket getSocket() {
        if (socket == null) {
            try {
                IO.Options opts = new IO.Options();
                opts.transports = new String[]{"websocket"};
                socket = IO.socket(baseURL, opts);

                socket.on(Socket.EVENT_RECONNECT, (Object... args) -> {
                    System.out.println("reconnect");
                    socket.emit("SUBSCRIBE", subscribedTopics);
                });

                socket.connect();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return socket;
    }
}
