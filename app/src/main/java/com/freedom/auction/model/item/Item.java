package com.freedom.auction.model.item;

public class Item {

    private String mId;

    private String mName;

    private String mPrice;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
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

    @Override
    public String toString() {
        return "Item{" +
                "id='" + mId + '\'' +
                ", name='" + mName + '\'' +
                ", price='" + mPrice + '\'' +
                '}';
    }
}
