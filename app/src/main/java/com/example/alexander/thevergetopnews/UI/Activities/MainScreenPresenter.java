package com.example.alexander.thevergetopnews.UI.Activities;


public class MainScreenPresenter implements ScreenContract.Presenter {

    private final ScreenContract.View view;

    public MainScreenPresenter(ScreenContract.View view) {
        this.view = view;
        }

        @Override
    public void onItemSelected(String item) {
        view.addFragment(item);
        }

}
