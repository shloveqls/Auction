package com.freedom.auction.top;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;
import com.freedom.auction.model.item.CatalogRes;
import com.freedom.auction.model.item.ItemDataSource;

public class TopPresenter implements TopContract.Presenter {

    private final ItemDataSource mItemDataSource;

    private final TopContract.View mTopView;

    public TopPresenter (@NonNull ItemDataSource itemDataSource,
                         @NonNull TopContract.View topView) {
        mItemDataSource = itemDataSource;
        mTopView = topView;
        mTopView.setPresenter(this);
    }

    @Override
    public void start() {
        loadItems();
    }

    private void loadItems() {
        mTopView.setLoadingIndicator(true);
        mItemDataSource.getCatalogs(new BaseListener<CatalogRes>() {
            @Override
            public void onResponse(CatalogRes response) {

                mTopView.setLoadingIndicator(false);

                if (response.getResult()) {
                    mTopView.showCatalogs(response.getCatalogList(), response.getItemMap());
                }
            }
        });
    }
}
