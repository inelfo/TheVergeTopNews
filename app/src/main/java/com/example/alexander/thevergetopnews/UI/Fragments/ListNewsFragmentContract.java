package com.example.alexander.thevergetopnews.UI.Fragments;

import com.example.alexander.thevergetopnews.Components.dto.News;

public class ListNewsFragmentContract {

    public interface IView {
        void showList(News data);
    }

    public interface IPresenter {

        public void  getData(String category);
    }

    public interface IFragment {

        }

    public interface IHost {}
}
