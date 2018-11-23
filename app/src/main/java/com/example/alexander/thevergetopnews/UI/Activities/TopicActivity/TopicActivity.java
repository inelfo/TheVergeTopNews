package com.example.alexander.thevergetopnews.UI.Activities.TopicActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.alexander.thevergetopnews.R;
import com.example.alexander.thevergetopnews.UI.Constants;

public class TopicActivity extends AppCompatActivity {

    public static Intent newIntent(Context context, String url) {
        Log.d("newIntent", "url");
        // todo Dan: why here is constant from adapter from different module?
        return new Intent(context, TopicActivity.class).putExtra(Constants.CONTENT_NEWS, url);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        WebView webView = findViewById(R.id.webView);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        // todo Dan: why here is constant from adapter from different module?
        webView.loadUrl(getIntent().getStringExtra(Constants.CONTENT_NEWS));
    }
}
