package com.example.alexander.thevergetopnews.UI;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.alexander.thevergetopnews.Components.dto.Article;
import com.example.alexander.thevergetopnews.R;
import com.example.alexander.thevergetopnews.UI.Activities.TopicActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    public static final String CONTENT_NEWS = "com.example.alexander.thevergetopnews.View.content_news";
    private List<Article> articles;
    private Context mContext;
    private RequestOptions options;

    public RecyclerViewAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        mContext = context;
    }

    private RequestOptions createGlideOptions() {
        if (options == null)
            options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher);
        return options;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false );
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Article article = articles.get(position);
        holder.name.setText(position + 1 + ". " + article.getTitle());
        holder.text.setText(article.getSource().getName());


        Glide.with(mContext).load(article.getUrlToImage()).apply(createGlideOptions()).into(holder.mImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

              Intent intent = new Intent(mContext, TopicActivity.class);
              intent.putExtra(CONTENT_NEWS, article.getUrl());
              intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, text;
        private ImageView mImageView;

        MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.article_text);
            mImageView = itemView.findViewById(R.id.image_article);
        }
    }
}