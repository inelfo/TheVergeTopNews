package com.example.alexander.thevergetopnews.UI.Activities;

public class ScreenContract {

    public interface View {

        void addFragment(String category);

     }

    public interface Presenter {
        void onItemSelected(String item);
    }


}
