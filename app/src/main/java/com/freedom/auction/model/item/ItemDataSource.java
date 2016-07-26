package com.freedom.auction.model.item;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;

public interface ItemDataSource {

    void getCatalogs(@NonNull BaseListener<CatalogRes> listener);

    void getItemsByPrimaryCatalogId(@NonNull String primaryCatalogId, @NonNull int start,
                                    @NonNull int end, @NonNull BaseListener<ItemRes> listener);

    void getItemDetail(@NonNull String itemId, @NonNull BaseListener<ItemRes> listener);

}
