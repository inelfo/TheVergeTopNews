package com.example.alexander.thevergetopnews.UI.Fragments.TopicFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.alexander.thevergetopnews.Components.Injection;
import com.example.alexander.thevergetopnews.R;




public class TopicFragment extends Fragment implements TopicFragmentContract.IView, TopicFragmentContract.IFragment {

    private final TopicFragmentContract.IPresenter presenter;
    private   TopicFragmentContract.IHost host;
    private  WebView webView;
    private String url;
    private final  static String URL_PAGE = "url";
    private boolean isHidden = true;

    public static TopicFragment newInstance(String url) {
        TopicFragment topicFragment = new TopicFragment();
        Bundle arg  = new Bundle();
        arg.putString(URL_PAGE, url);
        topicFragment.setArguments(arg);
        return topicFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null)
            url = getArguments().getString(URL_PAGE);
        presenter.getData(url);
        }

    public TopicFragment() {
        presenter = Injection.getTopicFragmentPresenter(this);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_topic, container, false);
       webView = v.findViewById(R.id.webView);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        host = (TopicFragmentContract.IHost) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        host.hideElements(!isHidden);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void showWebPage(String url) {
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    @Override
    public void changeUI() {
        if (host != null) {
            host.hideElements(isHidden);
        }
        }


}
