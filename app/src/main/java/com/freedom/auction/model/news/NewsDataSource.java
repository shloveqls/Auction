package com.freedom.auction.model.news;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;

public interface NewsDataSource {

    void getNews(@NonNull BaseListener<NewsRes> listener);

}
