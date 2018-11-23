package com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment;

import com.example.alexander.thevergetopnews.Components.Injection;
import com.example.alexander.thevergetopnews.Components.dto.News;
import com.example.alexander.thevergetopnews.Components.network.INetwork;
import com.example.alexander.thevergetopnews.Components.network.NetworkCallback;

public class ListNewsFragmentPresenter implements ListNewsFragmentContract.IPresenter {

    private final ListNewsFragmentContract.IView view;
    private final INetwork network;
    private final static String TOP_NEWS = "Top";
    private final static String APPLE = "Apple";
    private final static String ANDROID = "Android";
    // todo Dan: network implementation must be injected into constructor from outside

    private final NetworkCallback<News> listener = new NetworkCallback<News>() {
        @Override
        public void onFinished(News data) {
            view.showList(data);
        }

        @Override
        public void onFailure(Throwable t) {}
    };

    public ListNewsFragmentPresenter(final ListNewsFragmentContract.IView view) {
        network = Injection.getComponentProvider().getNetwork();
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
