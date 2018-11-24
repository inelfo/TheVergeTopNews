package com.example.alexander.thevergetopnews.components;

import com.example.alexander.thevergetopnews.ui.news.MainScreenPresenter;
import com.example.alexander.thevergetopnews.ui.news.ScreenContract;
import com.example.alexander.thevergetopnews.ui.news.fr.article.TopicFragmentContract;
import com.example.alexander.thevergetopnews.ui.news.fr.article.TopicFragmentPresenter;
import com.example.alexander.thevergetopnews.ui.news.fr.news.ListNewsFragmentContract;
import com.example.alexander.thevergetopnews.ui.news.fr.news.ListNewsFragmentPresenter;

public class Injection {

    private static IComponentProvider provider;

    public static void setComponentProvider(IComponentProvider provider) {
        Injection.provider = provider;
    }

    public static IComponentProvider getComponentProvider() {
        return provider;
    }

    public static ScreenContract.Presenter getMainScreenPresenter(ScreenContract.View view) {
        return new MainScreenPresenter(view);
    }

    public static ListNewsFragmentContract.IPresenter getMainFragmentPresenter(ListNewsFragmentContract.IView view) {
        return new ListNewsFragmentPresenter(view, provider.getNetwork());
    }

    public static TopicFragmentContract.IPresenter  getTopicFragmentPresenter(TopicFragmentContract.IView view) {
        return new TopicFragmentPresenter(view);
    }
}
