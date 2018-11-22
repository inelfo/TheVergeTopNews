package com.example.alexander.thevergetopnews.Components;

import com.example.alexander.thevergetopnews.Components.dto.News;

// todo Dan: move to network package
// todo Dan: clean: unused imports, modifiers etc
public interface INetwork {

        public void getTopNews(RepositoryListener listener);

        public void getAppleNews(RepositoryListener listener);

        public void getAndroidNews(RepositoryListener listener);


}
