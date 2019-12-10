package com.novadax.business;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.novadax.business.api.NovadaxApiClient;
import com.novadax.business.request.*;
import com.novadax.business.response.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bh on 2019/8/12.
 */

public class ApiClientTest {

    private Gson gson = new GsonBuilder()
            .serializeNulls()
            .create();

    private String access_key = "-";
    private String secret_key = "-";

    private NovadaxApiClient novadaxApiClient = new NovadaxApiClient(access_key, secret_key);

    @Test
    public void createOrder() {
        OrderCreateRequest placeRequest = new OrderCreateRequest();
        placeRequest.setSymbol("BTC_BRL");
        placeRequest.setType("LIMIT");
        placeRequest.setSide("SELL");
        placeRequest.setPrice("40000");
        placeRequest.setAmount("0.12");
        OrderRecordResponse order = novadaxApiClient.createOrder(placeRequest);
        System.out.println(gson.toJson(order));
    }

    @Test
    public void symbols() {
        NovadaxApiClient novadaxApiClient = new NovadaxApiClient(access_key, secret_key);
        List<CommonSymbolResponse> symbols = novadaxApiClient.getSymbols();
        System.out.println(gson.toJson(symbols));
    }

    @Test
    public void getOrderList() {
        OrderFilterRequest request = new OrderFilterRequest();
        request.setSymbol("BTC_BRL");
        List<OrderRecordResponse> orderList = novadaxApiClient.getOrderList(request);
        System.out.println(gson.toJson(orderList));
    }

    @Test
    public void getTimestamp() {
        Long timestamp = novadaxApiClient.getTimestamp();
        System.out.println(timestamp);
    }

    @Test
    public void getTickers() {
        List<MarketTickerResponse> tickers = novadaxApiClient.getTickers();
        System.out.println(new Gson().toJson(tickers));
    }

    @Test
    public void getTicker() {
        MarketTickerResponse ticker = novadaxApiClient.getTicker("BTC_BRL");
        System.out.println(gson.toJson(ticker));
    }

    @Test
    public void getDepth() {
        MarketDepthRequest marketDepthRequest = new MarketDepthRequest();
        marketDepthRequest.setSymbol("BTC_BRL");
        marketDepthRequest.setLimit(5);
        MarketDepthResponse depth = novadaxApiClient.getDepth(marketDepthRequest);
        System.out.println(gson.toJson(depth));
    }

    @Test
    public void getTrades() {
        MarketTradesFilterRequest marketTradesFilterRequest = new MarketTradesFilterRequest();
        marketTradesFilterRequest.setSymbol("BTC_BRL");
        marketTradesFilterRequest.setLimit(5);
        List<MarketTradeResponse> trades = novadaxApiClient.getTrades(marketTradesFilterRequest);
        System.out.println(gson.toJson(trades));
    }

    @Test
    public void cancelOrder() {
        OrderCancelResponse apiCancelOrderResponse = novadaxApiClient.cancelOrder("610563954179051520");
        System.out.println(gson.toJson(apiCancelOrderResponse));
    }

    @Test
    public void getOrderDetail() {
        OrderRecordResponse orderDetail = novadaxApiClient.getOrderDetail("610563954179051520");
        System.out.println(gson.toJson(orderDetail));
    }

    @Test
    public void getOrderFill() {
        List<OrderDetailResponse> orderFill = novadaxApiClient.getOrderFill("610563954179051520");
        System.out.println(gson.toJson(orderFill));
    }

    @Test
    public void getOrderTrades() {
        List<OrderDetailResponse> orderTrades = novadaxApiClient.getOrderTrades("608678940474609664");
        System.out.println(gson.toJson(orderTrades));
    }

    @Test
    public void getAccount() {
        List<AccountResponse> accounts = novadaxApiClient.getAccounts();
        System.out.println(gson.toJson(accounts));

        /*
        WithdrawCoinRequest request = new WithdrawCoinRequest();
        request.setAmount("0.001");
        request.setCode("BCH");
        request.setWallet("....");
        String id = novadaxApiClinet.withdrawcoin(request);
        Assert.assertNotNull(id);
        */
    }


    @Test
    public void getSubs() {
        // subs
        List<AccountSubResponse> subs = novadaxApiClient.getSubs();
        System.out.println(gson.toJson(subs));

        // sub-balance
        String subId = "CA648855702269333504";
        List<AccountSubBalanceResponse> sb = novadaxApiClient.getSubBalance(subId);
        System.out.println(gson.toJson(sb));

        // sub-record
        List<AccountSubTransferResponse> st = novadaxApiClient.getSubTransfer(subId);
        System.out.println(gson.toJson(st));

    }

    @Test
    public void subTransfer() {
        // sub-transfer
        AccountSubTransferRequest request = new AccountSubTransferRequest();
        request.setSubId("CA6521740260341");
        request.setCurrency("BTC");
        request.setTransferAmount(new BigDecimal("0.52"));
        request.setTransferType("master-transfer-in");
        int id = novadaxApiClient.subTransfer(request);
        System.out.println(id);

    }
}
