package com.novadax.business.listener;

public interface WebSocketListener<T> {
    void call(T t);
}