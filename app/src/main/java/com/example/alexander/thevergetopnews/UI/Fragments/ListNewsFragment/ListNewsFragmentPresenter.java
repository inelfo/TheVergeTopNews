package com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment;

import com.example.alexander.thevergetopnews.Components.ComponentProvider;
import com.example.alexander.thevergetopnews.Components.Injection;
import com.example.alexander.thevergetopnews.Components.dto.News;
import com.example.alexander.thevergetopnews.Components.network.INetwork;
import com.example.alexander.thevergetopnews.Components.network.NetworkCallback;

public class ListNewsFragmentPresenter implements ListNewsFragmentContract.IPresenter {

    private final ListNewsFragmentContract.IView view;

    private final INetwork provider;
    private final NetworkCallback<News> listener = new NetworkCallback<News>() {
        @Override
        public void onFinished(News data) {
            view.showList(data);
        }

        @Override
        public void onFailure(Throwable t) {}
    };
    private final static String TOP_NEWS = "Top";
    private final static String APPLE = "Apple";
    private final static String ANDROID = "Android";

    public ListNewsFragmentPresenter(final ListNewsFragmentContract.IView view) {
        this.view = view;
        Injection.setComponentProvider(new ComponentProvider()); // todo Dan: move to application class
        provider = Injection.getComponentProvider().getNetwork(); // todo Dan: хрень!!
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
