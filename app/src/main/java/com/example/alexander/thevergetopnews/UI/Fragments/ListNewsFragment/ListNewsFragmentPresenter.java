package com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment;

import com.example.alexander.thevergetopnews.Components.Injection;
import com.example.alexander.thevergetopnews.Components.dto.News;
import com.example.alexander.thevergetopnews.Components.network.INetwork;
import com.example.alexander.thevergetopnews.Components.network.NetworkCallback;

public class ListNewsFragmentPresenter implements ListNewsFragmentContract.IPresenter {

    private final ListNewsFragmentContract.IView view;

    private final INetwork network = Injection.getComponentProvider().getNetwork();
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
        // todo Dan: move to application class
         // todo Dan: хрень!!
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

    @Override
    public void onClickedItem(int position) {
        view.openTopic(position);
    }
}
