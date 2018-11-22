package com.example.alexander.thevergetopnews.Components;

import com.example.alexander.thevergetopnews.Components.dto.News;

public interface INetwork {

        public void getTopNews(RepositoryListener listener);

        public void getAppleNews(RepositoryListener listener);

        public void getAndroidNews(RepositoryListener listener);


}
