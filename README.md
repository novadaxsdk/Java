# Novadax Java SDK (v1 version)

This is novadax Java SDK, This is a lightweight Java library, you can import to your Java project and use this SDK to query all market data, trading and manage your account.

The SDK supports both synchronous 


## Table of Contents

- [Beginning](#Beginning)
  - [Installation](#Installation)
  - [Quick Start](#Quick-Start)
  - [Clients](#Clients)
  - [Create client](#create-client)
- [Usage](#Usage)
  - [example](#example)
  - [Errir handling](error-handling)

- [Request example](#Request-example)


  

## Beginning

### Installation

*The SDK is compiled by Java8*

please import the source code in java IDE (idea or eclipse)

The example code is in novadax-java-sdk/src/test/java/com/novadax/business/ApiClientTest.java.

### Quick Start

In your Java project, you can follow below steps:

* Create the client instance.
* Call the interfaces provided by client.

```java
 static String access_key = "xxxx-xxxx-xxxx-xxx-xxxxx";
    static String secret_key = "xxxxxxxxxxxxxxxxxxx";
    NovadaxApiClinet novadaxApiClinet = new NovadaxApiClinet(access_key, secret_key);
List<Symbol> symbols = novadaxApiClinet.getSymbols();
        System.out.println(new Gson().toJson(symbols));
```

Please NOTE:

All timestamp which is got from SDK is the Unix timestamp based on UTC.


### Create client

You can assign the API key and Secret key when you create the client. See below:

```java
NovadaxApiClinet novadaxApiClinet = new NovadaxApiClinet("xxxxxxxx-xxxxxxxx-xxxxxxxx-xxxxx", "xxxxxxxx-xxxxxxxx-xxxxxxxx-xxxxx");
```


The API key and Secret key are used for authentication.


## Usage
### example

To invoke the interface by synchronous, you can create the ```NovadaxApiClinet``` by calling ```new NovadaxApiClinet(access_key, secret_key)```, and call the API directly.

```java
NovadaxApiClinet novadaxApiClinet = new NovadaxApiClinet(access_key, secret_key);
List<Symbol> symbols = novadaxApiClinet.getSymbols();
        System.out.println(new Gson().toJson(symbols))
```



### Error handling


In error case, such as you set the invalid orderId to ```cancelOrder()```. The ```ApiException``` will be thrown. See below example:

```java
    try {
            ApiCancelOrderResponse apiCancelOrderResponse
                    = novadaxApiClinet.cancelOrder("610563954179051520");
            System.out.println(new Gson().toJson(apiCancelOrderResponse));
        }catch (ApiException e){
            System.out.println(e.getErrCode());
            System.out.println(e.getMessage());
        }
```

## Request-example

https://doc.novadax.com/en-US/?shell#cancel-an-order


