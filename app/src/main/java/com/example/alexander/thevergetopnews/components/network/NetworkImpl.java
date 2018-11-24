package com.example.alexander.thevergetopnews.components.network;

import com.example.alexander.thevergetopnews.components.dto.News;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkImpl implements INetwork {

    private static final String BASE_URL = "https://newsapi.org/v2/";
    private final IApiInterface service;

    public NetworkImpl(){
        final OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).build();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(IApiInterface.class);
    }

    public void getTopNews(final NetworkCallback<News> onFinishedListener) {
        service.getHeadliners().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(onFinishedListener != null){
                    onFinishedListener.onFinished(response.body());
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                if(onFinishedListener != null) {
                    onFinishedListener.onFailure(t);
                }
                t.printStackTrace();
            }
        });
    }

    public void getAppleNews(final NetworkCallback<News> onFinishedListener) {
        service.getAppleNews().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(onFinishedListener != null) {
                    onFinishedListener.onFinished(response.body());
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                if(onFinishedListener != null) {
                    onFinishedListener.onFailure(t);
                }
                t.printStackTrace();
            }
        });
    }

    public void getAndroidNews(final NetworkCallback<News> onFinishedListener) {
        service.getAndroidNews().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(onFinishedListener != null) {
                    onFinishedListener.onFinished(response.body());
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                if(onFinishedListener != null) {
                    onFinishedListener.onFailure(t);
                }
                t.printStackTrace();
            }
        });
    }
}
