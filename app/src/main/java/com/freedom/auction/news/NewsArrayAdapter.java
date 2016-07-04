package com.freedom.auction.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.freedom.auction.R;
import com.freedom.auction.model.news.News;

import java.util.List;

public class NewsArrayAdapter extends ArrayAdapter<News> {

    private NewsFragment mNewsFragment;

    public NewsArrayAdapter(NewsFragment newsFragment, List<News> newsList) {
        super(newsFragment.getContext(), R.layout.fragment_news_detail, newsList);
        mNewsFragment = newsFragment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final News news = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_news_detail, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.mTitleView = (TextView) convertView.findViewById(R.id.tv_news_title);
            viewHolder.mTimeView = (TextView) convertView.findViewById(R.id.tv_news_time);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.mTitleView.setText(news.getNewsTitle());
        viewHolder.mTimeView.setText(news.getNewsTime());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewsFragment.showNewsDetail(news);
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }

    public void replaceData(List<News> newsList) {
        clear();
        addAll(newsList);
    }

    public class ViewHolder {
        TextView mTitleView;
        TextView mTimeView;
    }

}
