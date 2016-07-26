package com.freedom.auction.top;

import com.freedom.auction.BasePresenter;
import com.freedom.auction.BaseView;
import com.freedom.auction.model.item.Catalog;
import com.freedom.auction.model.item.Item;

import java.util.List;
import java.util.Map;

public interface TopContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showCatalogs(List<Catalog> catalogList, Map<String, List<Item>> itemMap);

        void refreshItems(List<Item> itemList, ItemFragment itemFragment, boolean isSwipe);

        void showItemDetail(String itemId);

    }

    interface Presenter extends BasePresenter {

        void getItemsByPrimaryCatalogId(String primaryCatalogId, int start, int end, ItemFragment itemFragment, boolean isSwipe);

    }

}
