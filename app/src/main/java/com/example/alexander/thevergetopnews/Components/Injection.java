package com.example.alexander.thevergetopnews.Components;

import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.ListNewsFragmentPresenter;
import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.ListNewsFragmentContract;
import com.example.alexander.thevergetopnews.UI.Activities.ScreenActivity.MainScreenPresenter;
import com.example.alexander.thevergetopnews.UI.Activities.ScreenActivity.ScreenContract;
import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.TopicFragment.TopicFragmentContract;
import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.TopicFragment.TopicFragmentPresenter;

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
        return new ListNewsFragmentPresenter(view);
    }

    public static TopicFragmentContract.IPresenter  getTopicFragmentPresenter(TopicFragmentContract.IView view) {
        return new TopicFragmentPresenter(view);
    }
}
