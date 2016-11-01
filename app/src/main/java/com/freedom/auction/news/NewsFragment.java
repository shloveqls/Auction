package com.freedom.auction.news;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.freedom.auction.R;
import com.freedom.auction.model.news.News;
import com.freedom.auction.util.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements NewsContract.View {

    private NewsContract.Presenter mNewsPresenter;

    private ListView mListView;

    private NewsArrayAdapter mNewsArrayAdapter;

    private ProgressDialog mProgressDialog;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mListView = (ListView) inflater.inflate(R.layout.fragment_news, container, false);

        mNewsArrayAdapter = new NewsArrayAdapter(this, new ArrayList<News>());
        mListView.setAdapter(mNewsArrayAdapter);

        createProgressDialog();

        return mListView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mNewsPresenter.start();
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        mNewsPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (mProgressDialog != null) {
            if (active) {
                mProgressDialog.show();
            } else {
                mProgressDialog.dismiss();
            }
        }
    }

    @Override
    public void showNews(List<News> newsList) {
        mNewsArrayAdapter.replaceData(newsList);
    }

    @Override
    public void showNewsDetail(News news) {
        // TODO show news detail activity
    }

    private void createProgressDialog() {
        mProgressDialog = new ProgressDialog(getContext(), R.style.AppTheme_Dark_Dialog);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(ActivityUtils.getResource(getContext(), R.string.dialog_loading, String.class));
    }

}
