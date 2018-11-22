package com.example.alexander.thevergetopnews.UI.Fragments;

import com.example.alexander.thevergetopnews.Components.ComponentProvider;
import com.example.alexander.thevergetopnews.Components.INetwork;
import com.example.alexander.thevergetopnews.Components.Injection;

import com.example.alexander.thevergetopnews.Components.RepositoryListener;
import com.example.alexander.thevergetopnews.Components.dto.News;

public class ListNewsFragmentPresenter implements ListNewsFragmentContract.IPresenter {

    private final ListNewsFragmentContract.IView view;

    private final INetwork provider;
    private RepositoryListener listener;
    private final static String TOP_NEWS = "Top";
    private final static String APPLE = "Apple";
    private final static String ANDROID = "Android";

    public ListNewsFragmentPresenter(final ListNewsFragmentContract.IView view) {
        this.view = view;
        initRepositoryListener();
        Injection.setComponentProvider(new ComponentProvider());
        provider = Injection.getComponentProvider().getNetwork();


    }

    private void initRepositoryListener() {
        listener = new RepositoryListener() {
            @Override
            public void onFinished(News data) {
                view.showList(data);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        };

    }


    @Override
    public void getData(String category) {
        switch (category) {
            case TOP_NEWS:
                provider.getTopNews(listener);
                break;
            case APPLE:
                provider.getAppleNews(listener);
                break;
            case ANDROID:
                provider.getAndroidNews(listener);
                break;
            default:
                provider.getTopNews(listener);
                break;

        }
    }
}
