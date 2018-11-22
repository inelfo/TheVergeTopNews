package com.example.alexander.thevergetopnews.Components.network;


// todo Dan: move to network package
// todo Dan: clean: unused imports, modifiers etc
public interface INetwork {

         void getTopNews(RepositoryListener listener);

         void getAppleNews(RepositoryListener listener);

         void getAndroidNews(RepositoryListener listener);


}
