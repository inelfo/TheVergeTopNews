package com.example.alexander.thevergetopnews.Components;

import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.ListNewsFragmentPresenter;
import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.ListNewsFragmentContract;
import com.example.alexander.thevergetopnews.UI.Activities.ScreenActivity.MainScreenPresenter;
import com.example.alexander.thevergetopnews.UI.Activities.ScreenActivity.ScreenContract;

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
}
