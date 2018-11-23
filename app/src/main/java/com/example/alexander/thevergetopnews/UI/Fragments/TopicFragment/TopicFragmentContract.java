package com.example.alexander.thevergetopnews.UI.Fragments.TopicFragment;

public class TopicFragmentContract {

    public interface IPresenter {

        void getData(String url);
    }

    public interface IView {

        void showWebPage(String url);

        void changeUI();
    }
     interface IFragment {

    }

    public interface IHost {

        void hideElements(boolean isHidden);
    }
}
