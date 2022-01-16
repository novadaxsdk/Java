package com.novadax.business;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.novadax.business.api.NovadaxApiClient;
import com.novadax.business.request.*;
import com.novadax.business.response.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class ApiClientTest {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    private final String accessKey = "";
    private final String secretKey = "";


    private final NovadaxApiClient ApiClient = new NovadaxApiClient(accessKey, secretKey);

    @Test
    public void createOrder() {
        OrderCreateRequest placeRequest = new OrderCreateRequest();
        placeRequest.setSymbol("BTC_BRL");
        placeRequest.setType("LIMIT");
        placeRequest.setSide("SELL");
        placeRequest.setPrice("40000");
        placeRequest.setAmount("0.12");
        OrderRecordResponse order = ApiClient.createOrder(placeRequest);
        System.out.println(gson.toJson(order));
    }

    @Test
    public void createStopOrder() {
        OrderCreateRequest placeRequest = new OrderCreateRequest();
        placeRequest.setSymbol("BTC_BRL");
        placeRequest.setType("STOP_LIMIT");
        placeRequest.setSide("SELL");
        placeRequest.setPrice("180000");
        placeRequest.setAmount("0.001");
        placeRequest.setStopPrice("190000");
        placeRequest.setOperator("LTE");
        OrderRecordResponse order = ApiClient.createOrder(placeRequest);
        System.out.println(gson.toJson(order));
    }

    @Test
    public void getSymbols() {
        List<CommonSymbolResponse> symbols = ApiClient.getSymbols();
        System.out.println(gson.toJson(symbols));
    }

    @Test
    public void getSymbol() {
        CommonSymbolResponse symbol = ApiClient.getSymbol("BTC_BRL");
        System.out.println(gson.toJson(symbol));
    }

    @Test
    public void getOrderList() {
        OrderFilterRequest request = new OrderFilterRequest();
        request.setSymbol("BTC_BRL");
        List<OrderRecordResponse> orderList = ApiClient.getOrderList(request);
        System.out.println(gson.toJson(orderList));
    }

    @Test
    public void getTimestamp() {
        Long timestamp = ApiClient.getTimestamp();
        System.out.println(timestamp);
    }

    @Test
    public void getTickers() {
        List<MarketTickerResponse> tickers = ApiClient.getTickers();
        System.out.println(gson.toJson(tickers));
    }

    @Test
    public void getTicker() {
        MarketTickerResponse ticker = ApiClient.getTicker("BTC_BRL");
        System.out.println(gson.toJson(ticker));
    }

    @Test
    public void getDepth() {
        MarketDepthRequest marketDepthRequest = new MarketDepthRequest();
        marketDepthRequest.setSymbol("BTC_BRL");
        marketDepthRequest.setLimit(5);
        MarketDepthResponse depth = ApiClient.getDepth(marketDepthRequest);
        System.out.println(gson.toJson(depth));
    }

    @Test
    public void getTrades() {
        MarketTradesFilterRequest marketTradesFilterRequest = new MarketTradesFilterRequest();
        marketTradesFilterRequest.setSymbol("BTC_BRL");
        marketTradesFilterRequest.setLimit(5);
        List<MarketTradeResponse> trades = ApiClient.getTrades(marketTradesFilterRequest);
        System.out.println(gson.toJson(trades));
    }

    @Test
    public void cancelOrder() {
        OrderCancelResponse apiCancelOrderResponse = ApiClient.cancelOrder("654021124523479040");
        System.out.println(gson.toJson(apiCancelOrderResponse));
    }

    @Test
    public void getOrderDetail() {
        OrderRecordResponse orderDetail = ApiClient.getOrderDetail("654021124523479040");
        System.out.println(gson.toJson(orderDetail));
    }

    @Test
    public void getOrderFill() {
        List<OrderFillResponse> orderFill = ApiClient.getOrderFill("654021124523479040");
        System.out.println(gson.toJson(orderFill));
    }

    @Test
    public void getOrderFills() {
        List<OrderFillResponse> orderFills = ApiClient.getOrderFills(new OrderFillFilterRequest());
        System.out.println(gson.toJson(orderFills));
    }

    @Test
    public void getOrderTrades() {
        List<OrderFillResponse> orderTrades = ApiClient.getOrderTrades("654021124523479040");
        System.out.println(gson.toJson(orderTrades));
    }

    @Test
    public void getAccount() {
        List<AccountResponse> accounts = ApiClient.getAccounts();
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
        List<AccountSubResponse> subs = ApiClient.getSubs();
        System.out.println(gson.toJson(subs));

        // sub-balance
        String subId = "CA648855702269333504";
        List<AccountSubBalanceResponse> sb = ApiClient.getSubBalance(subId);
        System.out.println(gson.toJson(sb));

        // sub-record
        List<AccountSubTransferResponse> st = ApiClient.getSubTransfer(subId);
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
        int id = ApiClient.subTransfer(request);
        System.out.println(id);

    }

    @Test
    public void walletRecord() {
        // sub-transfer
        DepositWithdrawRequest request = new DepositWithdrawRequest();
        List<DepositWithdrawResponse> responseList = ApiClient.walletRecord(request);
        System.out.println(gson.toJson(responseList));

    }

    @Test
    public void walletWithdraw() {
        AccountWithdrawCoinRequest request = new AccountWithdrawCoinRequest();
        request.setAmount("0.05");
        request.setCode("BTC");
        request.setWallet("tb1q3vqzdh69lxffyf4n9z5ksep99qm9v4h5z3mfww");
        String res = ApiClient.withdrawCoin(request);
        System.out.println(gson.toJson(res));

    }

    @Test
    public void walletChain() {
        List<CryptoBasicResponse> res = ApiClient.cryptoChain(null);
        System.out.println(gson.toJson(res));

    }


    @Test
    public void testKline() {
        MarketKlineRequest marketKlineRequest = new MarketKlineRequest();
        marketKlineRequest.setFrom(1602406646l);
        marketKlineRequest.setTo(1602579446l);
        marketKlineRequest.setSymbol("BTC_BRL");
        marketKlineRequest.setUnit("ONE_MIN");
        System.out.println(ApiClient.getKline(marketKlineRequest));
    }
}
