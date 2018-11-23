package com.example.alexander.thevergetopnews.UI.Activities.TopicActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.alexander.thevergetopnews.R;
import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.RecyclerViewAdapter;

public class TopicActivity extends AppCompatActivity {

    public static Intent newIntent(Context context, String url) {
        // todo Dan: why here is constant from adapter from different module?
        return new Intent(context, TopicActivity.class).putExtra(RecyclerViewAdapter.CONTENT_NEWS, url);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        WebView webView = findViewById(R.id.webView);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        // todo Dan: why here is constant from adapter from different module?
        webView.loadUrl(getIntent().getStringExtra(RecyclerViewAdapter.CONTENT_NEWS));
    }
}
