package com.freedom.auction.model.news;

public class News {

    private String mNewsId;

    private String mNewsTitle;

    private String mNewsDetail;

    private String mNewsTime;

    public String getNewsId() {
        return mNewsId;
    }

    public void setNewsId(String newsId) {
        this.mNewsId = newsId;
    }

    public String getNewsTitle() {
        return mNewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.mNewsTitle = newsTitle;
    }

    public String getNewsDetail() {
        return mNewsDetail;
    }

    public void setNewsDetail(String newsDetail) {
        this.mNewsDetail = newsDetail;
    }

    public String getNewsTime() {
        return mNewsTime;
    }

    public void setNewsTime(String newsTime) {
        this.mNewsTime = newsTime;
    }

    @Override
    public String toString() {
        return "News{" +
                "mNewsId='" + mNewsId + '\'' +
                ", mNewsTitle='" + mNewsTitle + '\'' +
                ", mNewsDetail='" + mNewsDetail + '\'' +
                ", mNewsTime='" + mNewsTime + '\'' +
                '}';
    }
}
