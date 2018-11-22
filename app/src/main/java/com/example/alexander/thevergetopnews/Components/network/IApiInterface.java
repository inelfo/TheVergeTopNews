package com.example.alexander.thevergetopnews.Components.network;

import com.example.alexander.thevergetopnews.Components.dto.News;

import retrofit2.Call;
import retrofit2.http.GET;


public interface IApiInterface {

        @GET("top-headlines?country=ru&apiKey=23e308f40dc4407f8d3d743173e66218")
        Call<News> getHeadliners();

        @GET("everything?q=apple&apiKey=23e308f40dc4407f8d3d743173e66218")
        Call<News> getAppleNews();

        @GET("everything?q=android&apiKey=23e308f40dc4407f8d3d743173e66218")
        Call<News> getAndroidNews();
    }


