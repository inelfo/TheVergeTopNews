package com.example.alexander.thevergetopnews.components.network;

import com.example.alexander.thevergetopnews.components.dto.News;

public interface NetworkCallback<T> {

    void onFinished(T data);

    void onFailure(Throwable t);


}
