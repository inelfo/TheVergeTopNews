package com.example.alexander.thevergetopnews.UI.Fragments.TopicFragment;

public class TopicFragmentPresenter implements TopicFragmentContract.IPresenter {

    private TopicFragmentContract.IView view;

    public TopicFragmentPresenter(TopicFragmentContract.IView view) {
        this.view = view;
    }

    @Override
    public void getData(String url) {
        view.showWebPage(url);
        view.changeUI();
    }
}
