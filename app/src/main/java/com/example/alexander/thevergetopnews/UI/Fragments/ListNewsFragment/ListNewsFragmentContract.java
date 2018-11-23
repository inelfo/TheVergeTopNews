package com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment;

import com.example.alexander.thevergetopnews.Components.dto.News;

public class ListNewsFragmentContract {

    public interface IView {
        void showList(News data);
        void openTopic(int position);
    }

    public interface IPresenter {

        void  getData(String category);
        void onClickedItem(int position);
    }

    public interface IFragment {}

    public interface IHost {}
}
