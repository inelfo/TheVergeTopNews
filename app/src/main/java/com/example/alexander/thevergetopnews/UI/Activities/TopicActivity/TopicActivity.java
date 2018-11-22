package com.example.alexander.thevergetopnews.UI.Activities.TopicActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.alexander.thevergetopnews.R;
import com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment.RecyclerViewAdapter;

// todo Dan: each module in it's own package
public class TopicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        WebView webView = findViewById(R.id.webView);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getIntent().getStringExtra(RecyclerViewAdapter.CONTENT_NEWS));
    }
}
