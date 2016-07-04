package com.freedom.auction.model.news;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;
import com.freedom.auction.model.http.HttpGetAsyncTask;

public class RemoteNewsDataSource implements NewsDataSource {

    private static final RemoteNewsDataSource INSTANCE = new RemoteNewsDataSource();

    private RemoteNewsDataSource() {

    }

    public static RemoteNewsDataSource getInstance() {
        return RemoteNewsDataSource.INSTANCE;
    }

    @Override
    public void getNews(@NonNull BaseListener<NewsRes> listener) {
        // TODO
        String url = "";

        new HttpGetAsyncTask<NewsRes>(listener, NewsRes.class).execute(url);
    }
}
