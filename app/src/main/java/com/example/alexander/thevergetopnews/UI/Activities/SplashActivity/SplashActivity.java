package com.example.alexander.thevergetopnews.UI.Activities.SplashActivity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.alexander.thevergetopnews.R;
import com.example.alexander.thevergetopnews.UI.Activities.ScreenActivity.MainActivity;
import com.example.alexander.thevergetopnews.UI.Activities.ScreenActivity.ScreenContract;

// todo Dan: each module in it's own package
public class SplashActivity extends AppCompatActivity {
    ImageView imageView;
    Intent intent;
     // todo Dan: remove if you don't use it


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        intent = new Intent(this, MainActivity.class);
       // todo Dan: alternative you can find any view and make postDelayed without creating any handler
        imageView = findViewById(R.id.imageView);
        imageView.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(intent);
                finish();
            }
        },1500);

    }

}
