package com.example.alexander.thevergetopnews.UI.Fragments.ListNewsFragment;

import com.example.alexander.thevergetopnews.Components.dto.Article;

public interface AdapterCallback {

    void onItemClick(Article article, int adapterPosition);
}
