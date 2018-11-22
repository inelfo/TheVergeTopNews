package com.example.alexander.thevergetopnews.Components.network;

import com.example.alexander.thevergetopnews.Components.dto.News;

// todo Dan: move to network package
public interface RepositoryListener {

    void onFinished(News data);
    void onFailure(Throwable t);
}
