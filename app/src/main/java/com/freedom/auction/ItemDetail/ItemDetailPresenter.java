package com.freedom.auction.ItemDetail;

import android.support.annotation.NonNull;

import com.freedom.auction.model.item.ItemDataSource;

public class ItemDetailPresenter implements ItemDetailContract.Present {

    private ItemDataSource mItemDataSource;

    private ItemDetailContract.View mItemDetailView;

    public ItemDetailPresenter(@NonNull ItemDataSource itemDataSource,
                               @NonNull ItemDetailContract.View itemDetailView) {
        mItemDataSource = itemDataSource;
        mItemDetailView = itemDetailView;
        mItemDetailView.setPresenter(this);
    }

    @Override
    public void start() {
    }
}
