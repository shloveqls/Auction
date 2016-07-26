package com.freedom.auction.model.item;

public class Catalog {

    private String mCatalogId;

    private String mName;

    private String mDisplayOrder;

    public String getCatalogId() {
        return mCatalogId;
    }

    public void setPrimaryCatalogId(String catalogId) {
        this.mCatalogId = catalogId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDisplayOrder() {
        return mDisplayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.mDisplayOrder = displayOrder;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId='" + mCatalogId + '\'' +
                ", name='" + mName + '\'' +
                ", displayOrder='" + mDisplayOrder + '\'' +
                '}';
    }
}
