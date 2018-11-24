package com.example.alexander.thevergetopnews.ui.news.fr.news;

import com.example.alexander.thevergetopnews.components.dto.News;

public class ListNewsFragmentContract {

    public interface IView {
        void showList(News data);
    }

    public interface IPresenter {
        void  getData(String category);
    }

    public interface IFragment {}

    public interface IHost {
        void showTopic(String url);
    }
}
