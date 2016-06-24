package com.freedom.auction.top;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;
import com.freedom.auction.model.item.CatalogRes;
import com.freedom.auction.model.item.ItemDataSource;
import com.freedom.auction.model.item.ItemRes;

public class TopPresenter implements TopContract.Presenter {

    private final ItemDataSource mItemDataSource;

    private final TopContract.View mTopView;

    public TopPresenter(@NonNull ItemDataSource itemDataSource,
                        @NonNull TopContract.View topView) {
        mItemDataSource = itemDataSource;
        mTopView = topView;
        mTopView.setPresenter(this);
    }

    @Override
    public void start() {
        loadInitItems();
    }

    @Override
    public void getItemsByCatalogId(String catalogId, final ItemFragment itemFragment) {
        mItemDataSource.getItemsByCatalogId(catalogId, 0, 30, new BaseListener<ItemRes>() {
            @Override
            public void onResponse(ItemRes response) {
                if (response.getResult()) {
                    mTopView.refreshItems(response.getItemList(), itemFragment);
                }
            }
        });
    }

    private void loadInitItems() {
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
