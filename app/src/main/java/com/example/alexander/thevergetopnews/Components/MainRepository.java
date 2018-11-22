package com.example.alexander.thevergetopnews.Components;


import android.util.Log;

import com.example.alexander.thevergetopnews.Components.RepositoryListener;
import com.example.alexander.thevergetopnews.Components.dto.News;
import com.example.alexander.thevergetopnews.Components.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 class MainRepository  implements INetwork{
    private News news;

    public void getTopNews(final RepositoryListener onFinishedListener) {

        Call<News> newsCall = ApiClient.getInstance().getService().getHeadliners();
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                news = response.body();
                Log.d("!!!!!getNews", (onFinishedListener == null) + "");
                assert onFinishedListener != null;
                onFinishedListener.onFinished(news);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                onFinishedListener.onFailure(t);
                t.printStackTrace();
            }
        });

    }
    public void getAppleNews(final RepositoryListener onFinishedListener) {

        Call<News> newsCall = ApiClient.getInstance().getService().getAppleNews();
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                news = response.body();
                Log.d("!!!!!getAppleNews", (onFinishedListener == null) + "");
                assert onFinishedListener != null;
                onFinishedListener.onFinished(news);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                onFinishedListener.onFailure(t);
                t.printStackTrace();
            }
        });

    }
    public void getAndroidNews(final RepositoryListener onFinishedListener) {

        Call<News> newsCall = ApiClient.getInstance().getService().getAndroidNews();
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                news = response.body();
                Log.d("!!!!!getAndroidNews", (onFinishedListener == null) + "");
                assert onFinishedListener != null;
                onFinishedListener.onFinished(news);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                onFinishedListener.onFailure(t);
                t.printStackTrace();
            }
        });

    }

}
