package com.freedom.auction.model.item;

public class Item {

    private String mItemId;

    private String mExhibitorId;

    private String mPrimaryCatalogId;

    private String mSecondaryCatalogId;

    private String mMinorCatalogId;

    private ItemDetail mItemDetail;

    public String getItemId() {
        return mItemId;
    }

    public void setItemId(String itemId) {
        this.mItemId = itemId;
    }

    public String getExhibitorId() {
        return mExhibitorId;
    }

    public void setExhibitorId(String exhibitorId) {
        this.mExhibitorId = exhibitorId;
    }

    public String getPrimaryCatalogId() {
        return mPrimaryCatalogId;
    }

    public void setPrimaryCatalogId(String primaryCatalogId) {
        this.mPrimaryCatalogId = primaryCatalogId;
    }

    public String getSecondaryCatalogId() {
        return mSecondaryCatalogId;
    }

    public void setSecondaryCatalogId(String secondaryCatalogId) {
        this.mSecondaryCatalogId = secondaryCatalogId;
    }

    public String getMinorCatalogId() {
        return mMinorCatalogId;
    }

    public void setMinorCatalogId(String minorCatalogId) {
        this.mMinorCatalogId = minorCatalogId;
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
                ", mExhibitorId='" + mExhibitorId + '\'' +
                ", mPrimaryCatalogId='" + mPrimaryCatalogId + '\'' +
                ", mSecondaryCatalogId='" + mSecondaryCatalogId + '\'' +
                ", mMinorCatalogId='" + mMinorCatalogId + '\'' +
                ", mItemDetail=" + mItemDetail +
                '}';
    }
}
