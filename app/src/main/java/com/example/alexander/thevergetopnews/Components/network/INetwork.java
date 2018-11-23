package com.example.alexander.thevergetopnews.Components.network;


import com.example.alexander.thevergetopnews.Components.dto.News;


public interface INetwork {

         void getTopNews(NetworkCallback<News> listener);

         void getAppleNews(NetworkCallback<News> listener);

         void getAndroidNews(NetworkCallback<News> listener);


}
