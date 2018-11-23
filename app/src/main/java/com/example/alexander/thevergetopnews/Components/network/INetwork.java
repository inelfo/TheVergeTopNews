package com.example.alexander.thevergetopnews.Components.network;


import com.example.alexander.thevergetopnews.Components.dto.News;

// todo Dan: move to network package
// todo Dan: clean: unused imports, modifiers etc
public interface INetwork {

         void getTopNews(NetworkCallback<News> listener);

         void getAppleNews(NetworkCallback<News> listener);

         void getAndroidNews(NetworkCallback<News> listener);


}
