package com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment;

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
import com.example.alexander.thevergetopnews.UI.Activities.TopicActivity.TopicActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    // todo Dan: why so long?
    private AdapterCallback listener;
    public static final String CONTENT_NEWS = "content_news";
    private List<Article> articles;
    private Context mContext;
    private  final RequestOptions options = new RequestOptions()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher);

    RecyclerViewAdapter(List<Article> articles, Context context, AdapterCallback listener) {
        this.articles = articles;
        mContext = context;
        this.listener = listener ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false );
        return new MyViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // todo Dan: better make holder.bindItem(articles.get(position))
        final Article article = articles.get(position);

        holder.name.setText(position + 1 + ". " + article.getTitle());
        holder.text.setText(article.getSource().getName());


        Glide.with(mContext).load(article.getUrlToImage()).apply(options).into(holder.mImageView);

        // todo Dan: it's a problem for next fixes (single responsibility)
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View view) {
//              Intent intent = new Intent(mContext, TopicActivity.class);
//              intent.putExtra(CONTENT_NEWS, article.getUrl());
//              intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//              mContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView name, text;
        private final ImageView mImageView;
        private AdapterCallback listener;

        MyViewHolder(View itemView, AdapterCallback listener) {
            super(itemView);
            this.listener = listener;
            name = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.article_text);
            mImageView = itemView.findViewById(R.id.image_article);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(getAdapterPosition());
        }
    }
}