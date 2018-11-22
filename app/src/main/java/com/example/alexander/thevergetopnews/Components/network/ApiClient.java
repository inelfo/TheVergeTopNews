package com.example.alexander.thevergetopnews.Components.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// todo Dan: avoid singletons!
public class ApiClient {

    private static final String BASE_URL = "https://newsapi.org/v2/";
    private Retrofit retrofit;
    private IApiInterface service;
    private static ApiClient instance;

    private ApiClient() {
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(IApiInterface.class);
    }

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public IApiInterface getService(){
        return service;
    }

}
