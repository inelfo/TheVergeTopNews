package com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alexander.thevergetopnews.Components.Injection;
import com.example.alexander.thevergetopnews.Components.dto.Article;
import com.example.alexander.thevergetopnews.Components.dto.News;
import com.example.alexander.thevergetopnews.R;

public class ListNewsFragment extends Fragment implements ListNewsFragmentContract.IView,
        ListNewsFragmentContract.IFragment, AdapterCallback {
    private final static String CATEGORY = "category";
    private final static String TOP = "top";
    private final ListNewsFragmentContract.IPresenter presenter;
    private ListNewsFragmentContract.IHost host;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;


    public ListNewsFragment() {
        presenter = Injection.getMainFragmentPresenter(this);
    }

    public static ListNewsFragment newInstance() {
        ListNewsFragment listNewsFragment = new ListNewsFragment();
        Bundle arg  = new Bundle();
        arg.putString(CATEGORY, TOP);
        listNewsFragment.setArguments(arg);
        return listNewsFragment;
    }

    public static ListNewsFragment newInstance(String category) {
        ListNewsFragment listNewsFragment = new ListNewsFragment();
        Bundle arg = new Bundle();
        arg.putString(CATEGORY, category);
        listNewsFragment.setArguments(arg);
        return listNewsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recyclerview_fragment, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        swipeRefreshLayout = v.findViewById(R.id.refresh_view);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });


       return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Bundle args = getArguments();
        String category = null;
        if (args != null){
            category = args.getString(CATEGORY);
        }
        if(TextUtils.isEmpty(category)){
            category = TOP;
        }
        presenter.getData(category);
    }

    @Override
    public void showList(News news) {
        Log.d("showList", news.toString());
        adapter = new RecyclerViewAdapter(news.getArticles(), getContext(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(Article article, int position) {
        Toast.makeText(getContext(), "How can i put List<Articles> from here ?", Toast.LENGTH_SHORT).show();
        if(host != null){
            host.showTopic(article.getUrl());
        }
    }
}
