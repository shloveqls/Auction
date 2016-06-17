package com.freedom.auction.model.item;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;

public interface ItemDataSource {

    void getCatalogs(@NonNull BaseListener listener);

    void getItemsByCatalogId(@NonNull String catalogId, @NonNull int start,
                             @NonNull int end, @NonNull BaseListener listener);

    void getItemDetail(@NonNull String itemId, @NonNull BaseListener listener);

}
