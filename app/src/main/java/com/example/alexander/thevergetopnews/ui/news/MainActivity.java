package com.example.alexander.thevergetopnews.ui.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.alexander.thevergetopnews.R;
import com.example.alexander.thevergetopnews.components.Injection;
import com.example.alexander.thevergetopnews.ui.news.fr.article.TopicFragment;
import com.example.alexander.thevergetopnews.ui.news.fr.article.TopicFragmentContract;
import com.example.alexander.thevergetopnews.ui.news.fr.news.ListNewsFragment;
import com.example.alexander.thevergetopnews.ui.news.fr.news.ListNewsFragmentContract;

public class MainActivity extends AppCompatActivity implements ScreenContract.View, ListNewsFragmentContract.IHost,
        TopicFragmentContract.IHost {

    private ScreenContract.Presenter presenter;
    private BottomNavigationView bottomNavigationView;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;

    public MainActivity() {
        presenter = Injection.getMainScreenPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(ListNewsFragment.newInstance(), false, null);
        initViews();
        initBottomNavigationView();
    }

    private void initViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        appBarLayout = findViewById(R.id.appBarLayout);
        toolbar = findViewById(R.id.toolbar);
    }

    private void initBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_top_news:
                        presenter.onItemSelected(menuItem.getTitle().toString());
                        break;

                    case R.id.action_android_news:
                        presenter.onItemSelected(menuItem.getTitle().toString());
                        break;

                    case R.id.action_apple_news:
                        presenter.onItemSelected(menuItem.getTitle().toString());
                        break;
                }
                return false;
            }
        });
    }

    private void addFragment(Fragment fragment, boolean toBackStack, String tag) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment);
        if(toBackStack){
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }

    @Override
    public void addFragment(String category) {
        addFragment(ListNewsFragment.newInstance(category), false, null);
    }

    @Override
    public void showTopic(String url) {
        addFragment(TopicFragment.newInstance(url), true, "s");
    }

    @Override
    public void hideElements(boolean isHidden) {
        final int visibility = isHidden ? View.GONE : View.VISIBLE;
        bottomNavigationView.setVisibility(visibility);
        appBarLayout.setVisibility(visibility);
        toolbar.setVisibility(visibility);
    }
}
