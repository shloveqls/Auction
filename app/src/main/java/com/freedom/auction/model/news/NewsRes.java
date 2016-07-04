package com.freedom.auction.model.news;

import com.freedom.auction.model.Res;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsRes extends Res {

    private List<News> mNewsList;

    public static NewsRes parse(String response) {
        // TODO
        NewsRes newsRes = new NewsRes();
        newsRes.setResult(true);
        newsRes.setNewsList(createNewsListDummy());
        return newsRes;
    }

    public List<News> getNewsList() {
        return mNewsList;
    }

    public void setNewsList(List<News> newsList) {
        this.mNewsList = newsList;
    }

    //Delete
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private static List<News> createNewsListDummy() {

        int count = 20;

        ArrayList<News> newsList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            News news = new News();
            news.setNewsId(String.valueOf(i + 1));
            news.setNewsTitle("Title " + (i + 1));
            news.setNewsDetail("Detail " + (i + 1));
            news.setNewsTime(SIMPLE_DATE_FORMAT.format(new Date()));
            newsList.add(news);
        }

        return newsList;
    }
}
