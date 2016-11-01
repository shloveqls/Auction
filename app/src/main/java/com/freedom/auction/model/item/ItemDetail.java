package com.freedom.auction.model.item;

import java.util.List;

public class ItemDetail {

    private String mName;

    private String mPrice;

    private String mImageIcon;

    private List<String> mImageDetailList;

    private String mDescription;

    private String mBrand;

    private String mSize;

    private String mCondition;

    private String mDeliveryChargePayer;

    private String mDeliveryMethod;

    private String mDeliveryFromLocation;

    private String mDeliveryDays;

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

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getBrand() {
        return mBrand;
    }

    public void setBrand(String brand) {
        this.mBrand = brand;
    }

    public String getSize() {
        return mSize;
    }

    public void setSize(String size) {
        this.mSize = size;
    }

    public String getCondition() {
        return mCondition;
    }

    public void setCondition(String condition) {
        this.mCondition = condition;
    }

    public String getDeliveryChargePayer() {
        return mDeliveryChargePayer;
    }

    public void setDeliveryChargePayer(String deliveryChargePayer) {
        this.mDeliveryChargePayer = deliveryChargePayer;
    }

    public String getDeliveryMethod() {
        return mDeliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.mDeliveryMethod = deliveryMethod;
    }

    public String getDeliveryFromLocation() {
        return mDeliveryFromLocation;
    }

    public void setDeliveryFromLocation(String deliveryFromLocation) {
        this.mDeliveryFromLocation = deliveryFromLocation;
    }

    public String getDeliveryDays() {
        return mDeliveryDays;
    }

    public void setDeliveryDays(String deliveryDays) {
        this.mDeliveryDays = deliveryDays;
    }

    @Override
    public String toString() {
        return "ItemDetail{" +
                "mName='" + mName + '\'' +
                ", mPrice='" + mPrice + '\'' +
                ", mImageIcon='" + mImageIcon + '\'' +
                ", mImageDetailList=" + mImageDetailList +
                ", mDescription='" + mDescription + '\'' +
                ", mBrand='" + mBrand + '\'' +
                ", mSize='" + mSize + '\'' +
                ", mCondition='" + mCondition + '\'' +
                ", mDeliveryChargePayer='" + mDeliveryChargePayer + '\'' +
                ", mDeliveryMethod='" + mDeliveryMethod + '\'' +
                ", mDeliveryFromLocation='" + mDeliveryFromLocation + '\'' +
                ", mDeliveryDays='" + mDeliveryDays + '\'' +
                '}';
    }
}
