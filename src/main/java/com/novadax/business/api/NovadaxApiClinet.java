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
public class NovadaxApiClinet {
    static final String API_URL = "https://api.novadax.com";
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
    public NovadaxApiClinet(String accessKeyId, String accessKeySecret) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }


    /**
     * query symbols
     *
     * @return List of symbols.
     */
    public List<Symbol> getSymbols() {
        ApiResponse<List<Symbol>> resp =
                get("/v1/common/symbols", null, new TypeToken<ApiResponse<List<Symbol>>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * get timestamp
     *
     * @return
     */
    public Long getTimestamp() {
        ApiResponse<Long> resp =
                get("/v1/common/timestamp", null, new TypeToken<ApiResponse<Long>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * get all tickers
     *
     * @return
     */
    public List<TickerResponse> getTickers() {
        ApiResponse<List<TickerResponse>> resp = get("/v1/market/tickers", null, new TypeToken<ApiResponse<List<TickerResponse>>>() {
        });
        return resp.checkAndReturn();
    }


    /**
     * get one ticker
     *
     * @return
     */
    public TickerResponse getTicker(String symbol) {
        Map<String, String> symbolMap = Collections.singletonMap("symbol", symbol);
        ApiResponse<TickerResponse> resp = get("/v1/market/ticker", symbolMap, new TypeToken<ApiResponse<TickerResponse>>() {
        });
        return resp.checkAndReturn();
    }

    /**
     * get depth
     *
     * @param apiDepthRequest
     * @return
     */
    public ApiTransactionMarketDepth getDepth(ApiDepthRequest apiDepthRequest) {
        Map<String, String> stringObjectMap = objectToMap(apiDepthRequest);
        ApiResponse<ApiTransactionMarketDepth> resp = get("/v1/market/depth", stringObjectMap, new TypeToken<ApiResponse<ApiTransactionMarketDepth>>() {
        });
        return resp.checkAndReturn();

    }


    /**
     * get trades
     *
     * @param apiTransactionTradeFilterRequest
     * @return
     */
    public List<ApiTransactionTradeResponse> getTrades(ApiTransactionTradeFilterRequest apiTransactionTradeFilterRequest) {
        Map<String, String> stringObjectMap = objectToMap(apiTransactionTradeFilterRequest);
        ApiResponse<List<ApiTransactionTradeResponse>> resp = get("/v1/market/trades", stringObjectMap, new TypeToken<ApiResponse<List<ApiTransactionTradeResponse>>>() {
        });
        return resp.checkAndReturn();
    }


    /**
     * create order
     *
     * @param request CreateOrderRequest object.
     * @return Order id.
     */
    public ApiTransactionOrderRecordResponse createOrder(TransactionOrderPlaceRequest request) {

        ApiResponse<ApiTransactionOrderRecordResponse> resp = post("/v1/orders/create", request, new TypeToken<ApiResponse<ApiTransactionOrderRecordResponse>>() {
        });
        return resp.checkAndReturn();
    }

    public String withdrawcoin(WithdrawCoinRequest request) {
        ApiResponse<String> resp = post("/v1/account/withdraw/coin", request, new TypeToken<ApiResponse<String>>() {
        });
        return resp.checkAndReturn();
    }


    /**
     * cancel order
     *
     * @param id
     * @return
     */
    public ApiCancelOrderResponse cancelOrder(String id) {
        Map<String, String> idMap = Collections.singletonMap("id", id);
        ApiResponse<ApiCancelOrderResponse> resp = post("/v1/orders/cancel", idMap, new TypeToken<ApiResponse<ApiCancelOrderResponse>>() {
        });
        return resp.checkAndReturn();
    }

    /**
     * get order details
     *
     * @param id
     * @return
     */
    public ApiTransactionOrderRecordResponse getOrderDetail(String id) {
        Map<String, String> idMap = Collections.singletonMap("id", id);
        ApiResponse<ApiTransactionOrderRecordResponse> resp = get("/v1/orders/get", idMap, new TypeToken<ApiResponse<ApiTransactionOrderRecordResponse>>() {
        });
        return resp.checkAndReturn();
    }

    /**
     * get order fill
     * @param id
     * @return
     */
    public List<ApiTransactionOrderDetailResponse> getOrderFill(String id){
        Map<String, String> idMap = Collections.singletonMap("id", id);
        ApiResponse<List<ApiTransactionOrderDetailResponse>> resp = get("/v1/orders/fill", idMap, new TypeToken<ApiResponse<List<ApiTransactionOrderDetailResponse>>>() {
        });
        return resp.checkAndReturn();
    }



    /**
     * get order list
     *
     * @return List of symbols.
     */
    public List<ApiTransactionOrderRecordResponse> getOrderList(ApiTransactionOrderFilterRequest request) {
        Map<String, String> stringObjectMap = objectToMap(request);
        ApiResponse<List<ApiTransactionOrderRecordResponse>> resp =
                get("/v1/orders/list", stringObjectMap, new TypeToken<ApiResponse<List<ApiTransactionOrderRecordResponse>>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * get accounts
     *
     * @return
     */
    public List<ApiAccountResponse> getAccounts() {
        ApiResponse<List<ApiAccountResponse>> resp =
                get("/v1/account/getBalance", null, new TypeToken<ApiResponse<List<ApiAccountResponse>>>() {
                });
        return resp.checkAndReturn();
    }

    /**
     * query order trades
     *
     * @param id
     * @return
     */
    public List<ApiTransactionOrderDetailResponse> getOrderTrades(String id) {
        Map<String, String> idMap = Collections.singletonMap("id", id);
        ApiResponse<List<ApiTransactionOrderDetailResponse>> resp = get("/v1/orders/get", idMap, new TypeToken<ApiResponse<List<ApiTransactionOrderDetailResponse>>>() {
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
            String bodyString = response.body().string();
            ApiResponse api = gson.fromJson(bodyString, new TypeToken<ApiResponse<Object>>() {
            }.getType());
            if (!api.code.equals("A10000")) {
                throw new ApiException(api.code, api.message);
            }
            return gson.fromJson(bodyString, ref.getType());
        } catch (Exception e) {
            throw new ApiException(e);
        }
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

