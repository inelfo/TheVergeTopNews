package com.example.alexander.thevergetopnews.UI.Activities.ScreenActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.alexander.thevergetopnews.R;
import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.ListNewsFragment;
import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.ListNewsFragmentContract;

public class MainActivity extends AppCompatActivity implements ScreenContract.View, ListNewsFragmentContract.IHost {

    private MainScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        presenter = new MainScreenPresenter(this);



        addFragment(ListNewsFragment.newInstance());
        initBottomNavigationView();
    }

    private void initBottomNavigationView() {
        ((BottomNavigationView)findViewById(R.id.bottom_navigation))
                .setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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

    private void addFragment(Fragment fragment) {
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
}
