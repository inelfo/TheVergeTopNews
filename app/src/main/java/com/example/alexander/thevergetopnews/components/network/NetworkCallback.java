package com.example.alexander.thevergetopnews.components.network;

public interface NetworkCallback<T> {

    void onFinished(T data);

    void onFailure(Throwable t);
}
