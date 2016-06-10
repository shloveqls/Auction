package com.freedom.auction.model.item;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;
import com.freedom.auction.model.http.HttpGetAsyncTask;

public class RemoteItemDataSource implements ItemDataSource {

    private static final RemoteItemDataSource INSTANCE = new RemoteItemDataSource();

    private RemoteItemDataSource() {

    }

    public static RemoteItemDataSource getInstance() {
        return RemoteItemDataSource.INSTANCE;
    }

    @Override
    public void getAllItems(@NonNull String catalogId, @NonNull BaseListener listener) {

        // TODO
        String url = "";

        new HttpGetAsyncTask<ItemRes>(listener, ItemRes.class).execute(url, catalogId);

    }

}
