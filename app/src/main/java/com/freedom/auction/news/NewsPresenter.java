package com.freedom.auction.news;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;
import com.freedom.auction.model.news.NewsDataSource;
import com.freedom.auction.model.news.NewsRes;

public class NewsPresenter implements NewsContract.Presenter {

    private final NewsDataSource mNewsDataSource;

    private final NewsContract.View mNewsView;

    public NewsPresenter(@NonNull NewsDataSource newsDataSource,
                         @NonNull NewsContract.View newsView) {
        mNewsDataSource = newsDataSource;
        mNewsView = newsView;
        mNewsView.setPresenter(this);
    }

    @Override
    public void start() {
        loadInitNews();
    }

    private void loadInitNews() {
        mNewsView.setLoadingIndicator(true);
        mNewsDataSource.getNews(new BaseListener<NewsRes>() {
            @Override
            public void onResponse(NewsRes response) {

                mNewsView.setLoadingIndicator(false);

                if (response.getResult()) {
                    mNewsView.showNews(response.getNewsList());
                }
            }
        });
    }

}
