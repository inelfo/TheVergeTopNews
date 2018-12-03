package com.example.alexander.thevergetopnews.ui.news.fr.news;


import android.accounts.NetworkErrorException;

import com.example.alexander.thevergetopnews.components.dto.News;
import com.example.alexander.thevergetopnews.components.network.INetwork;
import com.example.alexander.thevergetopnews.components.network.NetworkCallback;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListNewsFragmentPresenterTest {

    private final static String TOP_NEWS = "Top";
    private final static String APPLE = "Apple";
    private final static String ANDROID = "Android";
    final private News data = new News();

    @Mock
    private INetwork network;

    @Mock
    private ListNewsFragmentContract.IView view;

    private ListNewsFragmentPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new ListNewsFragmentPresenter(view, network);
    }

    @Test
    public void getData_getTopNews_Success() {


        final ArgumentCaptor<NetworkCallback<News>> capt = ArgumentCaptor.forClass(NetworkCallback.class);

        presenter.getData(TOP_NEWS);

        Mockito.verify(network, Mockito.times(1)).getTopNews(capt.capture());
        capt.getValue().onFinished(data);
        Mockito.verify(view, Mockito.times(1)).showList(data);


        Mockito.verify(network, Mockito.never()).getAndroidNews(capt.capture());
        Mockito.verify(network, Mockito.never()).getAppleNews(capt.capture());

    }

    @Test
    public void getData_getAndroidNews_Success() {

        final ArgumentCaptor<NetworkCallback<News>> capt = ArgumentCaptor.forClass(NetworkCallback.class);
        presenter.getData(ANDROID);

        Mockito.verify(network, Mockito.times(1)).getAndroidNews(capt.capture());
        capt.getValue().onFinished(data);
        Mockito.verify(view, Mockito.times(1)).showList(data);


        Mockito.verify(network, Mockito.never()).getAppleNews(capt.capture());
        Mockito.verify(network, Mockito.never()).getTopNews(capt.capture());

    }

    @Test
    public void getData_getAppleNews_Success() {
        final ArgumentCaptor<NetworkCallback<News>> capt = ArgumentCaptor.forClass(NetworkCallback.class);

        presenter.getData(APPLE);

        Mockito.verify(network, Mockito.times(1)).getAppleNews(capt.capture());
        capt.getValue().onFinished(data);
        Mockito.verify(view, Mockito.times(1)).showList(data);


        Mockito.verify(network, Mockito.never()).getAndroidNews(capt.capture());
        Mockito.verify(network, Mockito.never()).getTopNews(capt.capture());

    }

    @Test
    public void getData_getTopNews_Failure() {
        final ArgumentCaptor<NetworkCallback<News>> capt = ArgumentCaptor.forClass(NetworkCallback.class);

        presenter.getData(TOP_NEWS);

       Mockito.verify(network, Mockito.times(1)).getAppleNews(capt.capture());
       capt.getValue().onFailure(new NetworkErrorException());

       Mockito.verify(view, Mockito.never()).showList(data);


    }
}