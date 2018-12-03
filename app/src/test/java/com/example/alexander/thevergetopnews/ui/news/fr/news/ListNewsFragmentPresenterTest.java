package com.example.alexander.thevergetopnews.ui.news.fr.news;


import com.example.alexander.thevergetopnews.components.dto.News;
import com.example.alexander.thevergetopnews.components.network.INetwork;
import com.example.alexander.thevergetopnews.components.network.NetworkCallback;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListNewsFragmentPresenterTest {

    private ListNewsFragmentPresenter presenter;

    private final static String TOP_NEWS = "Top";
    private final static String APPLE = "Apple";
    private final static String ANDROID = "Android";

    @Mock
   private INetwork mockNetwork;

    @Mock
   private ListNewsFragmentContract.IView mockView;

    @Mock
     private NetworkCallback mockListener;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new ListNewsFragmentPresenter(mockView, mockNetwork);
        }

    @Test
    public void getDataSuccessTest() {
        News data = new News();
       presenter.getData(TOP_NEWS);
     //  verify(mockNetwork).getTopNews(mockListener);
        verify(mockView).showList(data);

    }

    @After
    public void tearDown() {
    }
}