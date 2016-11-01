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
    public void getCatalogs(@NonNull BaseListener<CatalogRes> listener) {

        // TODO
        String url = "";

        new HttpGetAsyncTask<CatalogRes>(listener, CatalogRes.class).execute(url);

    }

    @Override
    public void getItemsByPrimaryCatalogId(@NonNull String primaryCatalogId, @NonNull int start,
                                    @NonNull int end, @NonNull BaseListener<ItemRes> listener) {

        // TODO
        String url = "/items/primaryCatalogId/" + primaryCatalogId + "/" + start + "/" + end;

        new HttpGetAsyncTask<ItemRes>(listener, ItemRes.class).execute(url);

    }

    @Override
    public void getItemDetail(@NonNull String itemId, @NonNull BaseListener<ItemRes> listener) {
        // TODO
        String url = "/items/detail/" + itemId;

        new HttpGetAsyncTask<ItemRes>(listener, ItemRes.class).execute(url);
    }
}
