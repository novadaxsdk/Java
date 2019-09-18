package com.novadax.business;

import com.google.gson.Gson;
import com.novadax.business.api.NovadaxApiClinet;
import com.novadax.business.enums.TransactionOrderSideEnum;
import com.novadax.business.enums.TransactionOrderTypeEnum;
import com.novadax.business.request.*;
import com.novadax.business.response.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bh on 2019/8/12.
 */

public class ApiClientTest {

    static String access_key = "";
    static String secret_key = "";
    NovadaxApiClinet novadaxApiClinet = new NovadaxApiClinet(access_key, secret_key);


    @Test
    public void createOrder() {
        TransactionOrderPlaceRequest placeRequest = new TransactionOrderPlaceRequest();
        placeRequest.symbol = "BTC_BRL";
        placeRequest.type = TransactionOrderTypeEnum.LIMIT;
        placeRequest.side = TransactionOrderSideEnum.BUY;
        placeRequest.price = new BigDecimal("40000");
        placeRequest.amount = new BigDecimal("0.001");
        ApiTransactionOrderRecordResponse order = novadaxApiClinet.createOrder(placeRequest);
        System.out.println(new Gson().toJson(order));
    }

    @Test
    public void symbols() {
        NovadaxApiClinet novadaxApiClinet = new NovadaxApiClinet(access_key, secret_key);
        List<Symbol> symbols = novadaxApiClinet.getSymbols();
        System.out.println(new Gson().toJson(symbols));
    }

    @Test
    public void getOrderList() {
        ApiTransactionOrderFilterRequest request = new ApiTransactionOrderFilterRequest();
        request.symbol = "BTC_BRL";
        List<ApiTransactionOrderRecordResponse> orderList = novadaxApiClinet.getOrderList(request);
        System.out.println(new Gson().toJson(orderList));
    }

    @Test
    public void getTimestamp() {
        Long timestamp = novadaxApiClinet.getTimestamp();
        System.out.println(timestamp);
    }

    @Test
    public void getTickers() {
        List<TickerResponse> tickers = novadaxApiClinet.getTickers();
        System.out.println(new Gson().toJson(tickers));
    }

    @Test
    public void getTicker() {
        TickerResponse ticker = novadaxApiClinet.getTicker("BTC_BRL");
        System.out.println(new Gson().toJson(ticker));
    }

    @Test
    public void getDepth() {
        ApiDepthRequest apiDepthRequest = new ApiDepthRequest();
        apiDepthRequest.symbol = "BTC_BRL";
        apiDepthRequest.limit = 5;
        ApiTransactionMarketDepth depth = novadaxApiClinet.getDepth(apiDepthRequest);
        System.out.println(new Gson().toJson(depth));
    }

    @Test
    public void getTrades() {
        ApiTransactionTradeFilterRequest apiTransactionTradeFilterRequest = new ApiTransactionTradeFilterRequest();
        apiTransactionTradeFilterRequest.symbol = "BTC_BRL";
        apiTransactionTradeFilterRequest.limit = 5;
        List<ApiTransactionTradeResponse> trades = novadaxApiClinet.getTrades(apiTransactionTradeFilterRequest);
        System.out.println(new Gson().toJson(trades));
    }

    @Test
    public void cancelOrder() {
        ApiCancelOrderResponse apiCancelOrderResponse = novadaxApiClinet.cancelOrder("610563954179051520");
        System.out.println(new Gson().toJson(apiCancelOrderResponse));
    }

    @Test
    public void getOrderDetail() {
        ApiTransactionOrderRecordResponse orderDetail = novadaxApiClinet.getOrderDetail("610563954179051520");
        System.out.println(new Gson().toJson(orderDetail));
    }

    @Test
    public void getOrderTrades() {
        List<ApiTransactionOrderDetailResponse> orderTrades = novadaxApiClinet.getOrderTrades("608678940474609664");
        System.out.println(new Gson().toJson(orderTrades));
    }

    @Test
    public void getAccount() {
        //List<ApiAccountResponse> accounts = novadaxApiClinet.getAccounts();
        // System.out.println(new Gson().toJson(accounts));
        WithdrawCoinRequest request = new WithdrawCoinRequest();
        request.setAmount("0.001");
        request.setCode("BCH");
        request.setWallet("....");
        String id = novadaxApiClinet.withdrawcoin(request);
        Assert.assertNotNull(id);
    }
}
