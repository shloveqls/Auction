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
    public void getItemsByPrimaryCatalogId(String primaryCatalogId, int start, int end,
                                           final ItemFragment itemFragment, final boolean isSwipe) {
        mItemDataSource.getItemsByPrimaryCatalogId(primaryCatalogId, start, end, new BaseListener<ItemRes>() {
            @Override
            public void onResponse(ItemRes response) {
                if (response.getResult()) {
                    mTopView.refreshItems(response.getItemList(), itemFragment, isSwipe);
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
