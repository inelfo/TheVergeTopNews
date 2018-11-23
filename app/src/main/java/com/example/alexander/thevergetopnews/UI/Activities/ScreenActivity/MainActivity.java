package com.example.alexander.thevergetopnews.UI.Activities.ScreenActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.alexander.thevergetopnews.Components.Injection;
import com.example.alexander.thevergetopnews.R;

import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.ListNewsFragment;
import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.ListNewsFragmentContract;
import com.example.alexander.thevergetopnews.UI.Fragments.TopicFragment.TopicFragment;
import com.example.alexander.thevergetopnews.UI.Fragments.TopicFragment.TopicFragmentContract;

public class MainActivity extends AppCompatActivity implements ScreenContract.View, ListNewsFragmentContract.IHost, TopicFragmentContract.IHost {

    private MainScreenPresenter presenter;
    private BottomNavigationView bottomNavigationView;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;


    public MainActivity() {
        // todo Dan: use Injection to create presenters
        presenter = (MainScreenPresenter) Injection.getMainScreenPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFirstFragment(ListNewsFragment.newInstance());
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

    private void addFirstFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container, fragment).commit();
    }

    @Override
    public void addFragment(String category) {
        ListNewsFragment listNewsFragment = ListNewsFragment.newInstance(category);
        // todo Dan: wtf? you have addFragment method
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container, listNewsFragment).commit();
    }

    @Override
    public void showTopic(String url) {
        TopicFragment topicFragment = TopicFragment.newInstance(url);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container, topicFragment).addToBackStack("s").commit();
    }

    @Override
    public void hideElements(boolean isHidden) {

        if (isHidden) {

            bottomNavigationView.setVisibility(View.GONE);
            appBarLayout.setVisibility(View.GONE);
            toolbar.setVisibility(View.GONE);
        }
        else
        {
            bottomNavigationView.setVisibility(View.VISIBLE);
            appBarLayout.setVisibility(View.VISIBLE);
            toolbar.setVisibility(View.VISIBLE);
        }
        }
}
