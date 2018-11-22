package com.example.alexander.thevergetopnews.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alexander.thevergetopnews.Components.Injection;

import com.example.alexander.thevergetopnews.Components.RepositoryListener;
import com.example.alexander.thevergetopnews.Components.dto.News;
import com.example.alexander.thevergetopnews.R;
import com.example.alexander.thevergetopnews.UI.RecyclerViewAdapter;

public class ListNewsFragment extends Fragment implements ListNewsFragmentContract.IView, ListNewsFragmentContract.IFragment, RepositoryListener {

    private final ListNewsFragmentContract.IPresenter presenter;
    private ListNewsFragmentContract.IHost host;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private String category;


    public ListNewsFragment() {
        presenter = Injection.getMainFragmentPresenter(this);
    }

    public static ListNewsFragment newInstance() {


        ListNewsFragment listNewsFragment = new ListNewsFragment();
        Bundle arg  = new Bundle();
        arg.putString("category", "Top");
        listNewsFragment.setArguments(arg);

        return listNewsFragment;

    }


    public static ListNewsFragment newInstance(String category) {

        ListNewsFragment listNewsFragment = new ListNewsFragment();
        Bundle arg = new Bundle();
        arg.putString("category", category);
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
                Toast.makeText(getContext(), "Working ....", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


       return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        category = getArguments().getString("category");
        presenter.getData(category);


    }


    @Override
    public void showList(News news) {
        Log.d("showList", news.toString());
        adapter = new RecyclerViewAdapter(news.getArticles(), getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFinished(News data) {
        showList(data);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
