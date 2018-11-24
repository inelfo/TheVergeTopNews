package com.example.alexander.thevergetopnews.ui.news.fr.news;

import com.example.alexander.thevergetopnews.components.dto.News;
import com.example.alexander.thevergetopnews.components.network.INetwork;
import com.example.alexander.thevergetopnews.components.network.NetworkCallback;

public class ListNewsFragmentPresenter implements ListNewsFragmentContract.IPresenter {

    private final static String TOP_NEWS = "Top";
    private final static String APPLE = "Apple";
    private final static String ANDROID = "Android";
    private final ListNewsFragmentContract.IView view;
    private final INetwork network;

    private final NetworkCallback<News> listener = new NetworkCallback<News>() {
        @Override
        public void onFinished(News data) {
            view.showList(data);
        }

        @Override
        public void onFailure(Throwable t) {}
    };

    public ListNewsFragmentPresenter(final ListNewsFragmentContract.IView view, INetwork network) {
        this.network = network;
        this.view = view;
    }

    @Override
    public void getData(String category) {
        switch (category) {
            case TOP_NEWS:
                network.getTopNews(listener);
                break;
            case APPLE:
                network.getAppleNews(listener);
                break;
            case ANDROID:
                network.getAndroidNews(listener);
                break;
            default:
                network.getTopNews(listener);
                break;
        }
    }
}
