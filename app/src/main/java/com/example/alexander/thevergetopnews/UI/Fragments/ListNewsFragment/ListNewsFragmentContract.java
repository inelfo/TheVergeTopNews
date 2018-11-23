package com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment;

import com.example.alexander.thevergetopnews.Components.dto.News;

public class ListNewsFragmentContract {

    public interface IView {
        void showList(News data);
    }

    public interface IPresenter {

        void  getData(String category);
    }

    public interface IFragment {}

    public interface IHost {}
}
