package com.example.alexander.thevergetopnews.Components.network;

public interface NetworkCallback<T> {

    void onFinished(T data);

    void onFailure(Throwable t);
}
