package com.example.alexander.thevergetopnews.UI.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexander.thevergetopnews.R;

public class SplashActivity extends AppCompatActivity {
    Handler handler;
    Intent intent;
    ScreenContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        intent = new Intent(this, MainActivity.class);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(intent);
                finish();
            }
        },1500);

    }

}
