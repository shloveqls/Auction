package com.freedom.auction.news;

import com.freedom.auction.BasePresenter;
import com.freedom.auction.BaseView;
import com.freedom.auction.model.news.News;

import java.util.List;

public interface NewsContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showNews(List<News> newsList);

        void showNewsDetail(News news);

    }

    interface Presenter extends BasePresenter {

    }

}
