package com.freedom.auction.top;

import android.support.annotation.NonNull;

import com.freedom.auction.model.item.ItemDataSource;

public class TopPresenter implements TopContract.Presenter {

    private final ItemDataSource mItemDataSource;

    private final TopContract.View mTopView;

    public TopPresenter (@NonNull ItemDataSource itemDataSource,
                         @NonNull TopContract.View topView) {
        mItemDataSource = itemDataSource;
        mTopView = topView;
    }

    @Override
    public void start() {

    }
}
