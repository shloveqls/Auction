package com.freedom.auction.model.item;

public class Item {

    private String mItemId;

    private String mCatalogId;

    private String mName;

    private String mPrice;

    private ItemDetail mItemDetail;

    public String getItemId() {
        return mItemId;
    }

    public void setItemId(String itemId) {
        this.mItemId = itemId;
    }

    public String getCatalogId() {
        return mCatalogId;
    }

    public void setCatalogId(String catalogId) {
        this.mCatalogId = catalogId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        this.mPrice = price;
    }

    public ItemDetail getItemDetail() {
        return mItemDetail;
    }

    public void setItemDetail(ItemDetail itemDetail) {
        this.mItemDetail = itemDetail;
    }

    @Override
    public String toString() {
        return "Item{" +
                "mItemId='" + mItemId + '\'' +
                ", mCatalogId='" + mCatalogId + '\'' +
                ", mName='" + mName + '\'' +
                ", mPrice='" + mPrice + '\'' +
                ", mItemDetail=" + mItemDetail +
                '}';
    }
}
