package com.example.alexander.thevergetopnews.UI.Activities.ScreenActivity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.ListNewsFragment;
import com.example.alexander.thevergetopnews.R;
import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.ListNewsFragmentContract;

// todo Dan: each module in it's own package
public class MainActivity extends AppCompatActivity implements ScreenContract.View, ListNewsFragmentContract.IHost {

    private BottomNavigationView bottomNavigationView;
    private MainScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainScreenPresenter(this);
        initViews();
        addFragment(ListNewsFragment.newInstance());
        initBottomNavigationView();
    }

    private void initBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_top_news:
                        Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                            presenter.onItemSelected(menuItem.getTitle().toString());
                        break;

                    case R.id.action_android_news:
                        Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        presenter.onItemSelected(menuItem.getTitle().toString());
                        break;

                    case R.id.action_apple_news:
                        Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
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


    private void initViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }


    @Override
    public void addFragment(String category) {
        ListNewsFragment listNewsFragment = ListNewsFragment.newInstance(category);
        // todo Dan: wtf? you have addFragment method
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container, listNewsFragment).commit();
    }
}
