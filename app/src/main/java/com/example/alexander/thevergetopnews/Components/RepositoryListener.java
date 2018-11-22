package com.example.alexander.thevergetopnews.Components;

import com.example.alexander.thevergetopnews.Components.dto.News;

public interface RepositoryListener {

    void onFinished(News data);
    void onFailure(Throwable t);
}
