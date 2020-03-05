package com.novadax.business.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.novadax.business.exception.ApiException;
import com.novadax.business.request.*;
import com.novadax.business.response.*;
import okhttp3.*;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author bh
 * @date 2019/8/8
 */
public class NovadaxApiClient {
    static final String API_URL = "https://stage04-api.novadax.com";
    static final MediaType JSON = MediaType.parse("application/json");
    static final OkHttpClient client = createOkHttpClient();
    static final int CONN_TIMEOUT = 5;
    static final int READ_TIMEOUT = 5;
    static final int WRITE_TIMEOUT = 5;

    final String accessKeyId;
    final String accessKeySecret;

    static Gson gson = new Gson();


    /**
     * create ApiClient
     *
     * @param accessKeyId     AccessKeyId
     * @param accessKeySecret AccessKeySecret
     */
    public NovadaxApiClient(String accessKeyId, String accessKeySecret) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }

    /**
     * query symbols
     *
     * @return List of symbols.
     */
    public CommonSymbolResponse getSymbol(String symbol) {
        Map<String, String> symbolMap = Collections.singletonMap("symbol", symbol);
        BaseResponse<CommonSymbolResponse> resp =
                get("/v1/common/symbol", symbolMap, new TypeToken<BaseResponse<CommonSymbolResponse>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * query symbols
     *
     * @return List of symbols.
     */
    public List<CommonSymbolResponse> getSymbols() {
        BaseResponse<List<CommonSymbolResponse>> resp =
                get("/v1/common/symbols", null, new TypeToken<BaseResponse<List<CommonSymbolResponse>>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * get timestamp
     *
     * @return
     */
    public Long getTimestamp() {
        BaseResponse<Long> resp =
                get("/v1/common/timestamp", null, new TypeToken<BaseResponse<Long>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * get all tickers
     *
     * @return
     */
    public List<MarketTickerResponse> getTickers() {
        BaseResponse<List<MarketTickerResponse>> resp = get("/v1/market/tickers", null, new TypeToken<BaseResponse<List<MarketTickerResponse>>>() {
        });
        return resp.checkAndReturn();
    }


    /**
     * get one ticker
     *
     * @return
     */
    public MarketTickerResponse getTicker(String symbol) {
        Map<String, String> symbolMap = Collections.singletonMap("symbol", symbol);
        BaseResponse<MarketTickerResponse> resp = get("/v1/market/ticker", symbolMap, new TypeToken<BaseResponse<MarketTickerResponse>>() {
        });
        return resp.checkAndReturn();
    }

    /**
     * get depth
     *
     * @param marketDepthRequest
     * @return
     */
    public MarketDepthResponse getDepth(MarketDepthRequest marketDepthRequest) {
        Map<String, String> stringObjectMap = objectToMap(marketDepthRequest);
        BaseResponse<MarketDepthResponse> resp = get("/v1/market/depth", stringObjectMap, new TypeToken<BaseResponse<MarketDepthResponse>>() {
        });
        return resp.checkAndReturn();

    }


    /**
     * get trades
     *
     * @param marketTradesFilterRequest
     * @return
     */
    public List<MarketTradeResponse> getTrades(MarketTradesFilterRequest marketTradesFilterRequest) {
        Map<String, String> stringObjectMap = objectToMap(marketTradesFilterRequest);
        BaseResponse<List<MarketTradeResponse>> resp = get("/v1/market/trades", stringObjectMap, new TypeToken<BaseResponse<List<MarketTradeResponse>>>() {
        });
        return resp.checkAndReturn();
    }


    /**
     * create order
     *
     * @param request CreateOrderRequest object.
     * @return Order id.
     */
    public OrderRecordResponse createOrder(OrderCreateRequest request) {

        BaseResponse<OrderRecordResponse> resp = post("/v1/orders/create", request, new TypeToken<BaseResponse<OrderRecordResponse>>() {
        });
        return resp.checkAndReturn();
    }

    public String withdrawcoin(AccountWithdrawCoinRequest request) {
        BaseResponse<String> resp = post("/v1/account/withdraw/coin", request, new TypeToken<BaseResponse<String>>() {
        });
        return resp.checkAndReturn();
    }


    public Integer subTransfer(AccountSubTransferRequest request) {
        BaseResponse<Integer> resp = post("/v1/account/subs/transfer", request, new TypeToken<BaseResponse<Integer>>() {
        });
        return resp.checkAndReturn();
    }

    /**
     * cancel order
     *
     * @param id
     * @return
     */
    public OrderCancelResponse cancelOrder(String id) {
        Map<String, String> idMap = Collections.singletonMap("id", id);
        BaseResponse<OrderCancelResponse> resp = post("/v1/orders/cancel", idMap, new TypeToken<BaseResponse<OrderCancelResponse>>() {
        });
        return resp.checkAndReturn();
    }

    /**
     * get order details
     *
     * @param id
     * @return
     */
    public OrderRecordResponse getOrderDetail(String id) {
        Map<String, String> idMap = Collections.singletonMap("id", id);
        BaseResponse<OrderRecordResponse> resp = get("/v1/orders/get", idMap, new TypeToken<BaseResponse<OrderRecordResponse>>() {
        });
        return resp.checkAndReturn();
    }

    /**
     * get order fill
     *
     * @param id
     * @return
     */
    public List<OrderDetailResponse> getOrderFill(String id) {
        Map<String, String> idMap = Collections.singletonMap("id", id);
        BaseResponse<List<OrderDetailResponse>> resp = get("/v1/orders/fill", idMap, new TypeToken<BaseResponse<List<OrderDetailResponse>>>() {
        });
        return resp.checkAndReturn();
    }


    /**
     * get order list
     *
     * @return List of symbols.
     */
    public List<OrderRecordResponse> getOrderList(OrderFilterRequest request) {
        Map<String, String> stringObjectMap = objectToMap(request);
        BaseResponse<List<OrderRecordResponse>> resp =
                get("/v1/orders/list", stringObjectMap, new TypeToken<BaseResponse<List<OrderRecordResponse>>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * get accounts
     *
     * @return
     */
    public List<AccountResponse> getAccounts() {
        BaseResponse<List<AccountResponse>> resp =
                get("/v1/account/getBalance", null, new TypeToken<BaseResponse<List<AccountResponse>>>() {
                });
        return resp.checkAndReturn();
    }

    public List<AccountSubResponse> getSubs() {
        BaseResponse<List<AccountSubResponse>> resp =
                get("/v1/account/subs", null, new TypeToken<BaseResponse<List<AccountSubResponse>>>() {
                });
        return resp.checkAndReturn();
    }

    public List<AccountSubBalanceResponse> getSubBalance(String subId) {
        Map<String, String> params = Collections.singletonMap("subId", subId);
        BaseResponse<List<AccountSubBalanceResponse>> resp =
                get("/v1/account/subs/balance", params, new TypeToken<BaseResponse<List<AccountSubBalanceResponse>>>() {
                });
        return resp.checkAndReturn();
    }

    public List<AccountSubTransferResponse> getSubTransfer(String subId) {
        Map<String, String> params = Collections.singletonMap("subId", subId);
        BaseResponse<List<AccountSubTransferResponse>> resp =
                get("/v1/account/subs/transfer/record", params, new TypeToken<BaseResponse<List<AccountSubTransferResponse>>>() {
                });
        return resp.checkAndReturn();
    }


    /**
     * query order trades
     *
     * @param id
     * @return
     */
    public List<OrderDetailResponse> getOrderTrades(String id) {
        Map<String, String> idMap = Collections.singletonMap("id", id);
        BaseResponse<List<OrderDetailResponse>> resp = get("/v1/orders/fill", idMap, new TypeToken<BaseResponse<List<OrderDetailResponse>>>() {
        });
        return resp.checkAndReturn();
    }


    <T> T get(String uri, Map<String, String> params, TypeToken<T> ref) {
        if (params == null) {
            params = new HashMap<>();
        }
        return call("GET", uri, null, params, ref);
    }

    <T> T post(String uri, Object object, TypeToken<T> ref) {
        return call("POST", uri, object, new HashMap<String, String>(), ref);
    }

    <T> T call(String method, String uri, Object object, Map<String, String> params,
               TypeToken<T> ref) {
        ApiSignature sign = new ApiSignature();
        BaseResponse api;
        String bodyString;
        try {
            Request.Builder builder = null;
            String bodyStr = null;
            if ("POST".equals(method)) {
                bodyStr = gson.toJson(object);
                RequestBody body = RequestBody.create(JSON, bodyStr);
                builder = new Request.Builder().url(API_URL + uri + "?" + toQueryString(params)).post(body);
            } else {
                builder = new Request.Builder().url(API_URL + uri + "?" + toQueryString(params)).get();
            }
            String timestamp = String.valueOf(System.currentTimeMillis());

            builder.addHeader("X-Nova-Access-Key", this.accessKeyId);
            builder.addHeader("X-Nova-Timestamp", timestamp);
            builder.addHeader("X-Nova-Signature",
                    sign.getSignature(method, uri, toQueryString(params), bodyStr, timestamp, this.accessKeySecret));

            Request request = builder.build();
            Response response = client.newCall(request).execute();
            bodyString = response.body().string();
            api = gson.fromJson(bodyString, new TypeToken<BaseResponse<Object>>() {
            }.getType());
        } catch (Exception e) {
            throw new ApiException(e);
        }
        if (!api.getCode().equals("A10000")) {
            throw new ApiException(bodyString);
        }
        return gson.fromJson(bodyString, ref.getType());
    }


    static OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS).writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    public static String toQueryString(Map<String, String> params) {
        return params.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(set -> urlEncode(set.getKey()) + "=" + urlEncode(set.getValue()))
                .collect(Collectors.joining("&"));
    }

    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("UTF-8 encoding not supported!");
        }
    }


    /**
     * objects change map
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public Map<String, String> objectToMap(Object obj) {
        Map<String, String> map = new HashMap<String, String>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value != null) {
                map.put(fieldName, value.toString());
            }
        }
        return map;
    }


}

