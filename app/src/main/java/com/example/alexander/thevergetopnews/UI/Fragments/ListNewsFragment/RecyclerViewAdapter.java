package com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment;

import android.content.Context;
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

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private final AdapterCallback listener;
    private final List<Article> articles;
    private final Context mContext;

    RecyclerViewAdapter(List<Article> articles, Context context, AdapterCallback listener) {
        this.articles = articles;
        mContext = context;
        this.listener = listener ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false );
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.bindItem(articles.get(position), position);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher);

        private final TextView name, text;
        private final ImageView mImageView;

        MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.article_text);
            mImageView = itemView.findViewById(R.id.image_article);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null) {
                final int position = getAdapterPosition();
                listener.onItemClick(articles.get(position), position);
            }
        }

        void bindItem(Article article, int position) {
            name.setText(new StringBuffer(String.valueOf(position + 1)).append(". ").append(article.getTitle()));
            text.setText(article.getSource().getName());
            Glide.with(mContext).load(article.getUrlToImage()).apply(options).into(mImageView);
        }
    }
}