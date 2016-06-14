package com.freedom.auction.top;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freedom.auction.R;

public class TopFragment extends Fragment implements TopContract.View {

    private TopContract.Presenter mTopPresenter;

    public static TopFragment newInstance() {
        return new TopFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_top, container, false);

        return root;
    }

    @Override
    public void setPresenter(TopContract.Presenter presenter) {
        mTopPresenter = presenter;
    }
}
