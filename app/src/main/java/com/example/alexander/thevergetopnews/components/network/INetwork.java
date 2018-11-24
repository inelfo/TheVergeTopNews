package com.example.alexander.thevergetopnews.components.network;


import com.example.alexander.thevergetopnews.components.dto.News;


public interface INetwork {

         void getTopNews(NetworkCallback<News> listener);

         void getAppleNews(NetworkCallback<News> listener);

         void getAndroidNews(NetworkCallback<News> listener);


}
