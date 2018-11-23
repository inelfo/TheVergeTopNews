package com.example.alexander.thevergetopnews.UI.Activities.ScreenActivity;

public class ScreenContract {

    public interface View {

        void addFragment(String category);

     }

    public interface Presenter {
        void onItemSelected(String item);
    }
}
