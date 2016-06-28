package com.freedom.auction.model.item;

import java.util.List;

public class ItemDetail {

    private String mPrice;

    private String mImageIcon;

    private List<String> mImageDetailList;

    private String mExhibitNum;

    private String mDescription;

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        this.mPrice = price;
    }

    public String getImageIcon() {
        return mImageIcon;
    }

    public void setImageIcon(String imageIcon) {
        this.mImageIcon = imageIcon;
    }

    public List<String> getImageDetailList() {
        return mImageDetailList;
    }

    public void setImageDetailList(List<String> imageDetailList) {
        this.mImageDetailList = imageDetailList;
    }

    public String getExhibitNum() {
        return mExhibitNum;
    }

    public void setExhibitNum(String exhibitNum) {
        this.mExhibitNum = exhibitNum;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    @Override
    public String toString() {
        return "ItemDetail{" +
                "mPrice='" + mPrice + '\'' +
                ", mImageIcon='" + mImageIcon + '\'' +
                ", mImageDetailList=" + mImageDetailList +
                ", mExhibitNum='" + mExhibitNum + '\'' +
                ", mDescription='" + mDescription + '\'' +
                '}';
    }
}
